package com.dioneadam.dataanalyzer.service;

import com.dioneadam.dataanalyzer.configuration.AppConfig;
import com.dioneadam.dataanalyzer.models.DataAnalyse;
import com.dioneadam.dataanalyzer.models.DataWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.util.List;

@Service
public class ProcessFileService {

    private final DirectoryWatcher watcher;
    private final DataReader dataReader;
    private final ParseService parseService;
    private final DataWriter dataWriter;
    private final DataAnalysisService dataAnalysisService;

    private static final Logger logger = LoggerFactory.getLogger(ProcessFileService.class);

    public ProcessFileService(DirectoryWatcher watcher, DataReader dataReader, ParseService dataConverter, DataWriter dataWriter, DataAnalysisService dataAnalysisService) {
        this.watcher = watcher;
        this.dataReader = dataReader;
        this.parseService = dataConverter;
        this.dataWriter = dataWriter;
        this.dataAnalysisService = dataAnalysisService;
    }

    @PostConstruct
    public void analyze() {
        logger.info("initializing data analysis");
        createDirectories();

        dataReader.getAllFiles(AppConfig.INPUT_PATH).forEach(this::analyze);

        logger.info("done fisrt data analysis");
    }

    @Scheduled(initialDelayString = "${app.job.scheduler.delay}", fixedRateString = "${app.job.scheduler.interval}")
    public void handleNewOrModifyFile() {
        watcher.getNextWatchKey();
        for (WatchEvent<?> event : watcher.getEvents()) {
            Path path = (Path) event.context();
            if (path.toString().endsWith(".dat")) {
                Path filepath = Paths.get(AppConfig.INPUT_PATH.toString(), path.toString());
                analyze(filepath.toFile());
            }
        }
        watcher.resetWatchKey();
    }

    private void analyze(File file) {
        List<String> lines = dataReader.readFile(file);
        DataWrapper parsedData = parseService.parseLines(lines);
        DataAnalyse dataAnalyse = dataAnalysisService.analyseData(parsedData);
        dataWriter.writeDataReport(dataAnalyse, file.getName().replaceAll(".dat", ""));
    }

    private void createDirectories() {
        try {
            Files.createDirectories(AppConfig.INPUT_PATH);
            Files.createDirectories(AppConfig.OUTPUT_PATH);
        } catch (IOException e) {
            logger.error("error on create directories!" + e);
        }
    }

}