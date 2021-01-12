package com.dioneadam.dataanalyzer.service.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataReader {

    private static final Logger logger = LoggerFactory.getLogger(DataReader.class);

    public List<String> readFile(File file) {
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            logger.error("Error on reading " + file.getName());
            return new ArrayList<>();
        }
    }

    public List<File> getAllFiles(Path path) {
        try {
            return Files.walk(path)
                    .filter(Files::isRegularFile)
                    .filter(file -> file.toString().endsWith(".dat"))
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("Error on get file list from " + path);
        }
        return new ArrayList<>();
    }

}