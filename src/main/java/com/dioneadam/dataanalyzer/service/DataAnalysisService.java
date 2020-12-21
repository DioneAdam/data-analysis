package com.dioneadam.dataanalyzer.service;

import com.dioneadam.dataanalyzer.configuration.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;

@Service
public class DataAnalysisService {

    private final DirectoryWatcher watcher;
    private final DataReader dataReader;
    private final ParseService parseService;
    private final DataWriter dataWriter;

    private static final Logger logger = LoggerFactory.getLogger(DataAnalysisService.class);

    public DataAnalysisService(DirectoryWatcher watcher, DataReader dataReader, ParseService dataConverter, DataWriter dataWriter) {
        this.watcher = watcher;
        this.dataReader = dataReader;
        this.parseService = dataConverter;
        this.dataWriter = dataWriter;
    }

    @PostConstruct
    public void analyze() {
        logger.info("initializing data analysis");
        createDirectories();

        dataReader.getAllFiles(AppConfig.INPUT_PATH).forEach(file -> {
            //List parsedData = parseService.parseLines(dataReader.readFile(file));
            dataWriter.writeDataReport(parseService.parseLines(dataReader.readFile(file)), file.getName().replaceAll(".dat", ""));
        });

        logger.info("done fisrt data analysis");
    }

    @Scheduled(initialDelayString = "${app.job.scheduler.delay}", fixedRateString = "${app.job.scheduler.interval}")
    public void handleNewOrModifyFile() {
        watcher.getNextWatchKey();
        for (WatchEvent<?> event : watcher.getEvents()) {
            Path path = (Path) event.context();
            if (path.toString().endsWith(".dat")) {
                Path filepath = Paths.get(AppConfig.INPUT_PATH.toString(), path.toString());
                analyze(filepath, filepath.getFileName().toString());
            }
        }
        watcher.resetWatchKey();
    }

    public void analyze(Path path, String fileName) {
        dataWriter.writeDataReport(parseService.parseLines(dataReader.readFile(path.toFile())), fileName.replaceAll(".dat", ""));
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