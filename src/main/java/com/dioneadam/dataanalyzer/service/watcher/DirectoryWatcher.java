package com.dioneadam.dataanalyzer.service.watcher;

import com.dioneadam.dataanalyzer.configuration.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

@Configuration
public class DirectoryWatcher {

    private WatchService watchService;
    private WatchKey watchKey;

    private static final Logger logger = LoggerFactory.getLogger(DirectoryWatcher.class);

    public DirectoryWatcher() {
        configureWatcher();
    }

    private void configureWatcher() {
        try {
            watchService = FileSystems.getDefault().newWatchService();
            AppConfig.getInputPath()
                    .register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY);
        } catch (IOException e) {
            logger.error("Error on configure watch directory", e);
        }
    }

    public void resetWatchKey() {
        this.watchKey.reset();
    }

    public void getNextWatchKey() {
        try {
            watchKey = watchService.take();
        } catch (ClosedWatchServiceException | InterruptedException e) {
        logger.error("Error on watch directory", e);
        }
    }

    public List<WatchEvent<?>> getEvents() {
        return watchKey.pollEvents();
    }

}