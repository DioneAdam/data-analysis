package com.dioneadam.dataanalyzer.service.util;

import com.dioneadam.dataanalyzer.configuration.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class DirectoryUtil {

    private static final Logger logger = LoggerFactory.getLogger(DirectoryUtil.class);

    public static void createInputDirectory() {
        createDirectory(AppConfig.getInputPath());
    }

    public static void createOutputDirectory() {
        createDirectory(AppConfig.getOutputPath());
    }

    private static void createDirectory(Path path) {
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            logger.error("error on create directories!" + e);
        }
    }
}
