package com.dioneadam.dataanalyzer.service.file;

import com.dioneadam.dataanalyzer.configuration.AppConfig;
import com.dioneadam.dataanalyzer.models.AnalyzedData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Paths;

@Component
public class DataWriter {

    private static final Logger logger = LoggerFactory.getLogger(DataWriter.class);

    public void writeDataReport(AnalyzedData analyzedData, String file) {
        try (BufferedWriter outputStream = new BufferedWriter(new FileWriter(Paths.get(AppConfig.OUTPUT_PATH.toString(), String.format(AppConfig.OUTPUT_FILENAME, file)).toString()))) {

            final String amountOfClients = String.format("Amount of clients in the input file: %s", analyzedData.getAmountOfClients());
            final String amountOfSalesman = String.format("Amount of salesman in the input file: %s", analyzedData.getAmountOfSalesman());
            final String idOfTheMostExpensiveSale = String.format("Id of the most expensive sale: %s", analyzedData.getMostExpensiveSale());
            final String worstSalesmanEver = String.format("Worst salesman ever: %s", analyzedData.getWorstSalesman());

            outputStream.write(amountOfClients + "\r\n"
                    + amountOfSalesman + "\r\n"
                    + removeNullOfText(idOfTheMostExpensiveSale) + "\r\n"
                    + removeNullOfText(worstSalesmanEver));

        } catch (Exception e) {
            logger.error("Error on writing output file! Path = " + Paths.get(AppConfig.OUTPUT_PATH.toString(), String.format(AppConfig.OUTPUT_FILENAME, file)).toString());
        }
    }

    private String removeNullOfText(String text) {
        return text.replaceAll(" null", "");
    }

}