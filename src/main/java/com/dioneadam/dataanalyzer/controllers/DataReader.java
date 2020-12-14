package com.dioneadam.dataanalyzer.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataReader {

    private static final String LINE_SPLIT = "(?=\\s[0-9]{3})";
    private static final Logger logger = LoggerFactory.getLogger(DataReader.class);

    public List<String> readFile(File file) {
        List<String> entrys = new ArrayList<>();
        long start = System.currentTimeMillis();
        long end = start + 2000;
        while(true) {
            try (BufferedReader inputStream = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = inputStream.readLine()) != null) {
                    String[] lines = line.split(LINE_SPLIT);
                    for (String entry : lines) {
                        entrys.add(entry.trim());
                    }
                }
                return entrys;
            } catch (IOException e) {
                logger.warn(String.format("Trying reading %s ...", file.getName()));
            }
            if(System.currentTimeMillis() > end) {
                logger.error("Error on reading " + file.getName());
                return entrys;
            }    
        }
    }

    public List<File> getAllFiles(Path path) {
        try {
            return Files.walk(path).filter(Files::isRegularFile).filter(x -> x.toString().endsWith(".dat"))
                    .map(Path::toFile).collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("Error on get file list from " + path);
        }
        return new ArrayList<>();
    }

}