package com.dioneadam.core.challenge.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.dioneadam.core.challenge.controllers.DataConverter;
import com.dioneadam.core.challenge.controllers.DataReader;
import com.dioneadam.core.challenge.controllers.DataWriter;
import com.dioneadam.core.challenge.managers.CustomerManager;
import com.dioneadam.core.challenge.managers.SalesManager;
import com.dioneadam.core.challenge.managers.SalesmanManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataAnalysis {

    @Autowired
    private DataReader dataReader;

    @Autowired
    private DataConverter dataConverter;

    @Autowired
    private DataWriter dataWriter;

    @Autowired
    private CustomerManager customerManager;

    @Autowired
    private SalesManager salesManager;

    @Autowired
    private SalesmanManager salesmanManager;

    @Autowired
    private Path inputPath;

    @Autowired
    private Path outputPath;

    private static Logger logger = LoggerFactory.getLogger(DataAnalysis.class);

    public void analyze() {
        logger.info("initializing data analysis");
        createDirectories();
        clearAllDatas();

        dataReader.getAllFiles(inputPath).forEach(file -> {
            dataConverter.convert(dataReader.readFile(file));
        });
        dataWriter.writeDataReport();
    }

    public void analyze(Path path) {
        dataConverter.convert(dataReader.readFile(path.toFile()));
        dataWriter.writeDataReport();
    }

    private void clearAllDatas() {
        customerManager.clearCustomers();
        salesManager.clearSales();
        salesmanManager.clearSalesmen();
    }

    private void createDirectories() {
        try {
            Files.createDirectories(inputPath);
            Files.createDirectories(outputPath);
        } catch (IOException e) {
            logger.error("error on create directories!" + e);
        }
    }

}