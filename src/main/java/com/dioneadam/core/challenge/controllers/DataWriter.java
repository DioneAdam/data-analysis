package com.dioneadam.core.challenge.controllers;

import com.dioneadam.core.challenge.managers.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.Optional;

@Component
public class DataWriter {

    @Autowired
    private CustomerManager customerManager;

    @Autowired
    private SalesManager salesManager;

    @Autowired
    private SalesmanManager salesmanManager;

    @Autowired
    private Path outputFilePath;

    private static Logger logger = LoggerFactory.getLogger(DataWriter.class);

    public void writeDataReport() {
        try (BufferedWriter outputStream = new BufferedWriter(new FileWriter(outputFilePath.toString()))) {

            String amountOfClients = "Amount of clients in the input file: ";
            String amountOfSalesman = "Amount of salesman in the input file: ";
            String idOfTheMostExpensiveSale = "Id of the most expensive sale: ";
            String worstSalesmanEver = "Worst salesman ever: ";

            amountOfClients += customerManager.amountOfClients();

            amountOfSalesman += salesmanManager.amountOfSalesman();

            Optional<Integer> mostExpensiveSale = salesManager.getIdOfTheMostExpensiveSale();
            idOfTheMostExpensiveSale += mostExpensiveSale.isPresent() ? mostExpensiveSale.get() : "" ;

            Optional<String> worstSalesman = salesManager.getWorstSalesmanEver();
            worstSalesmanEver += worstSalesman.isPresent() ? worstSalesman.get() : "";

            outputStream.write(amountOfClients + "\r\n" 
                            + amountOfSalesman + "\r\n" 
                            + idOfTheMostExpensiveSale + "\r\n"
                            + worstSalesmanEver);
        } catch (Exception e) {
            logger.error("Error on writing output file! Path = " + outputFilePath.toString());
        }
    }
}