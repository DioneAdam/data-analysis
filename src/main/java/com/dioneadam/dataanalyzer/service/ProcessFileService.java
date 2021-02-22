package com.dioneadam.dataanalyzer.service;

import com.dioneadam.dataanalyzer.configuration.AppConfig;
import com.dioneadam.dataanalyzer.models.AnalyzedData;
import com.dioneadam.dataanalyzer.models.data.Line;
import com.dioneadam.dataanalyzer.parser.FileParser;
import com.dioneadam.dataanalyzer.service.util.DataReader;
import com.dioneadam.dataanalyzer.service.util.DataWriter;
import com.dioneadam.dataanalyzer.service.util.DirectoryUtil;
import com.dioneadam.dataanalyzer.service.watcher.DirectoryWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.util.List;

@Service
public class ProcessFileService {

    @Value("${application.features.enable-analysis-pre-existing-files}")
    private boolean enablePreExistingFilesAnalysis;

    private final DirectoryWatcher watcher;
    private final DataReader dataReader;
    private final FileParser fileParser;
    private final DataWriter dataWriter;
    private final DataAnalysisService dataAnalysisService;

    private static final Logger logger = LoggerFactory.getLogger(ProcessFileService.class);

    public ProcessFileService(DirectoryWatcher watcher, DataReader dataReader, FileParser dataConverter, DataWriter dataWriter, DataAnalysisService dataAnalysisService) {
        this.watcher = watcher;
        this.dataReader = dataReader;
        this.fileParser = dataConverter;
        this.dataWriter = dataWriter;
        this.dataAnalysisService = dataAnalysisService;
    }

    @PostConstruct
    public void analyze() {
        logger.info("Creating directories if doesn't exist");
        createDirectories();

        if(enablePreExistingFilesAnalysis) {
            analyzeAllPreExistingFiles();
        }
    }

    @Scheduled(initialDelayString = "${application.job.scheduler.delay}", fixedRateString = "${application.job.scheduler.interval}")
    public void handleNewOrModifyFile() {
        watcher.getNextWatchKey();
        watcher.getEvents()
                .stream()
                .map(WatchEvent::context)
                .map(Object::toString)
                .filter(filePath -> filePath.endsWith(AppConfig.getInputFileExtension()))
                .map(filePath -> Paths.get(AppConfig.getInputPathAsString(), filePath))
                .forEach(path -> analyzeFile(path.toFile()));
        watcher.resetWatchKey();
    }

    private void analyzeAllPreExistingFiles() {
        logger.info("Starting analysis of pre-existing files");

        dataReader.getAllFiles()
                .forEach(this::analyzeFile);

        logger.info("Completed first analysis!");
    }

    private void analyzeFile(File file) {
        List<String> lines = dataReader.readFile(file);
        List<Line> parsedData = fileParser.parseLines(lines);
        AnalyzedData analyzedData = dataAnalysisService.getAnalyzedData(parsedData);
        dataWriter.writeDataReport(analyzedData, file.getName());
    }

    private void createDirectories() {
        DirectoryUtil.createInputDirectory();
        DirectoryUtil.createOutputDirectory();
    }

}