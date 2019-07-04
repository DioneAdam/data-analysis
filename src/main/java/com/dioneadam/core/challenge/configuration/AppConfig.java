package com.dioneadam.core.challenge.configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.dioneadam.core.challenge.controllers.DataAnalysis;
import com.dioneadam.core.challenge.controllers.DirectoryWatcher;
import com.dioneadam.core.challenge.managers.CustomerManager;
import com.dioneadam.core.challenge.managers.SalesManager;
import com.dioneadam.core.challenge.managers.SalesmanManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.dioneadam.core.desafio"})
public class AppConfig {

    private static final String OUTPUT_FILENAME = "dataAnalysis.done.dat";
    private static final Path HOMEPATH = Paths.get(System.getProperty("user.home"));
    private static final Path INPUT_PATH = Paths.get(HOMEPATH.toString(), "data", "in");
    private static final Path OUTPUT_PATH = Paths.get(HOMEPATH.toString(), "data", "out");
    private static final Path OUTPUT_FILEPATH = Paths.get(OUTPUT_PATH.toString(), OUTPUT_FILENAME);

    @Bean
    public CustomerManager customerManager() {
        return new CustomerManager();
    }

    @Bean
    public SalesManager salesManager() {
        return new SalesManager();
    }

    @Bean
    public SalesmanManager salesmanManager() {
        return new SalesmanManager();
    }

    @Bean
    public DataAnalysis dataAnalysis() {
        return new DataAnalysis();
    }

    @Bean
    public DirectoryWatcher directoryWatcher() {
        return new DirectoryWatcher();
    }

    @Bean
    public Path inputPath() {
        return INPUT_PATH;
    }

    @Bean
    public Path outputPath() {
        return OUTPUT_PATH;
    }

    @Bean
    public Path outputFilePath() {
        return OUTPUT_FILEPATH;
    }

}