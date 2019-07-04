package com.dioneadam.core.challenge.controllers;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import com.dioneadam.core.challenge.controllers.DataAnalysis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectoryWatcher {

    @Autowired
    private DataAnalysis dataAnalysis;

    @Autowired
    private Path inputPath;

    private static Logger logger = LoggerFactory.getLogger(DirectoryWatcher.class);

    public void watchDirectory() {

        try {
            logger.info("watching input directory for any change");

            WatchService watchService = FileSystems.getDefault().newWatchService();
            inputPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

            WatchKey key;
            while ((key = watchService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    Path path = (Path) event.context();
                    if (path.toString().endsWith(".dat")) {
                        if (event.kind().equals(StandardWatchEventKinds.ENTRY_CREATE)) {
                            Path filepath = Paths.get(inputPath.toString(), path.toString());
                            dataAnalysis.analyze(filepath);
                        } else {           
                            dataAnalysis.analyze();
                        }
                    }
                }
                key.reset();
            }
            watchService.close();
            
        } catch (IOException | InterruptedException e) {
            logger.error("Error on watch directory", e);
        }
    }

}