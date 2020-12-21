package com.dioneadam.dataanalyzer.service;

import com.dioneadam.dataanalyzer.configuration.AppConfig;
import com.dioneadam.dataanalyzer.models.DataWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.Optional;

@Component
public class DataWriter {

    private static final Logger logger = LoggerFactory.getLogger(DataWriter.class);

    public void writeDataReport(DataWrapper dataWrapper, String file) {
        try (BufferedWriter outputStream = new BufferedWriter(new FileWriter(Paths.get(AppConfig.OUTPUT_PATH.toString(), String.format(AppConfig.OUTPUT_FILENAME, file)).toString()))) {

            String amountOfClients = "Amount of clients in the input file: ";
            String amountOfSalesman = "Amount of salesman in the input file: ";
            String idOfTheMostExpensiveSale = "Id of the most expensive sale: ";
            String worstSalesmanEver = "Worst salesman ever: ";

            amountOfClients += dataWrapper.getCustomerManager().amountOfClients();

            amountOfSalesman += dataWrapper.getSalesmanManager().amountOfSalesman();

            Optional<Integer> mostExpensiveSale = dataWrapper.getSalesManager().getIdOfTheMostExpensiveSale();
            idOfTheMostExpensiveSale += mostExpensiveSale.isPresent() ? mostExpensiveSale.get() : "" ;

            Optional<String> worstSalesman = dataWrapper.getSalesManager().getWorstSalesmanEver();
            worstSalesmanEver += worstSalesman.orElse("");

            outputStream.write(amountOfClients + "\r\n" 
                            + amountOfSalesman + "\r\n" 
                            + idOfTheMostExpensiveSale + "\r\n"
                            + worstSalesmanEver);
        } catch (Exception e) {
            logger.error("Error on writing output file! Path = " + Paths.get(AppConfig.OUTPUT_PATH.toString(), String.format(AppConfig.OUTPUT_FILENAME, file)).toString());
        }
    }
}