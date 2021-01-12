package com.dioneadam.dataanalyzer.service.file;

import com.dioneadam.dataanalyzer.configuration.AppConfig;
import com.dioneadam.dataanalyzer.models.AnalyzedData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class DataWriter {

    private static final Logger logger = LoggerFactory.getLogger(DataWriter.class);

    public void writeDataReport(AnalyzedData analyzedData, String file) {
        Path path = Paths.get(AppConfig.OUTPUT_PATH.toString(), String.format(AppConfig.OUTPUT_FILENAME, file));
        try {
            Files.write(path, analyzedData.getBytes());
        } catch (IOException e) {
            logger.error("Error on writing output file! Path = " + path);
        }
    }
}