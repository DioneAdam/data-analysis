package com.dioneadam.dataanalyzer.stub;

import com.dioneadam.dataanalyzer.models.AnalyzedData;

public class AnalyzedDataStub {
    public static AnalyzedData createAnalyzedData() {
        return AnalyzedData.of()
                .amountOfClients(1)
                .amountOfSalesman(1)
                .mostExpensiveSale(999)
                .worstSalesman("the worst salesman ever")
                .build();
    }

    public static AnalyzedData createAnalyzedDataWithoutSalesman() {
        return AnalyzedData.of()
                .amountOfClients(1)
                .amountOfSalesman(0)
                .mostExpensiveSale(999)
                .worstSalesman("the worst salesman ever")
                .build();
    }

    public static AnalyzedData createAnalyzedDataWithoutCustomer() {
        return AnalyzedData.of()
                .amountOfClients(0)
                .amountOfSalesman(1)
                .mostExpensiveSale(999)
                .worstSalesman("the worst salesman ever")
                .build();
    }

    public static AnalyzedData createAnalyzedDataWithOnlySales() {
        return AnalyzedData.of()
                .amountOfClients(0)
                .amountOfSalesman(0)
                .mostExpensiveSale(999)
                .worstSalesman("the worst salesman ever")
                .build();
    }

    public static AnalyzedData createAnalyzedDataWithoutMostExpensiveSale() {
        return AnalyzedData.of()
                .amountOfClients(1)
                .amountOfSalesman(1)
                .mostExpensiveSale(null)
                .worstSalesman("")
                .build();
    }


}
