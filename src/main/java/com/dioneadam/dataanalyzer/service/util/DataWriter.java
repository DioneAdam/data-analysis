package com.dioneadam.dataanalyzer.service.util;

import com.dioneadam.dataanalyzer.configuration.AppConfig;
import com.dioneadam.dataanalyzer.models.AnalyzedData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class DataWriter {

    private static final Logger logger = LoggerFactory.getLogger(DataWriter.class);

    public void writeDataReport(AnalyzedData analyzedData, String file) {
        String fileName = file.replaceAll(AppConfig.getInputFileExtension(), "");
        String analyzedFileName = fileName + AppConfig.getOutputFileExtension();
        Path path = AppConfig.getOutputPath().resolve(analyzedFileName);
        try {
            Files.write(path, analyzedData.getBytes());
        } catch (IOException e) {
            logger.error("Error on writing output file! Path = " + path);
        }
    }
}