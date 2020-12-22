package com.dioneadam.dataanalyzer.service;

import com.dioneadam.dataanalyzer.models.DataAnalyse;
import com.dioneadam.dataanalyzer.models.DataWrapper;
import org.springframework.stereotype.Service;

@Service
public class DataAnalysisService {

    public DataAnalyse analyseData(DataWrapper dataWrapper) {

        Integer amountOfClients = dataWrapper.getCustomerManager().amountOfClients();

        Integer amountOfSalesman = dataWrapper.getSalesmanManager().amountOfSalesman();

        Integer mostExpensiveSale = dataWrapper
                .getSalesManager()
                .getIdOfTheMostExpensiveSale()
                .orElse(null);

        String worstSalesman = dataWrapper
                .getSalesManager()
                .getWorstSalesmanEver()
                .orElse(null);

        return DataAnalyse.of()
                .amountOfClients(amountOfClients)
                .amountOfSalesman(amountOfSalesman)
                .mostExpensiveSale(mostExpensiveSale)
                .worstSalesman(worstSalesman)
                .build();

    }

}
