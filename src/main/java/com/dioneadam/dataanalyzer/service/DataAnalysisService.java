package com.dioneadam.dataanalyzer.service;

import com.dioneadam.dataanalyzer.models.AnalyzedData;
import com.dioneadam.dataanalyzer.models.data.Customer;
import com.dioneadam.dataanalyzer.models.data.Line;
import com.dioneadam.dataanalyzer.models.data.Sale;
import com.dioneadam.dataanalyzer.models.data.Salesman;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DataAnalysisService {

    public AnalyzedData getAnalyzedData(List<Line> parsedData) {

        List<Customer> customers = getDataListFromModelClass(parsedData, Customer.class);
        List<Salesman> salesman = getDataListFromModelClass(parsedData, Salesman.class);
        List<Sale> sales = getDataListFromModelClass(parsedData, Sale.class);

        return AnalyzedData.of()
                .amountOfClients(customers.size())
                .amountOfSalesman(salesman.size())
                .mostExpensiveSale(findMostExpensiveSaleId(sales))
                .worstSalesman(findWorstSalesmanEver(sales))
                .build();
    }

    private Integer findMostExpensiveSaleId(List<Sale> salesList) {
        return salesList.stream()
                .max(Comparator.comparing(Sale::getSalePrice))
                .orElse(Sale.of().saleId(null).build())
                .getSaleId();
    }

    private String findWorstSalesmanEver(List<Sale> salesList) {
        return salesList
                .stream()
                .collect(Collectors.toMap(Sale::getSalesmanName,Sale::getSalePrice, BigDecimal::add))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .orElse(Map.entry("", new BigDecimal(0)))
                .getKey();
    }

    private <E> List<E> getDataListFromModelClass(List<Line> parsedModels, Class<E> modelClass) {
        return parsedModels.stream()
                .filter(baseModel -> modelClass.getSimpleName().equals(baseModel.getClass().getSimpleName()))
                .map(modelClass::cast)
                .collect(Collectors.toList());
    }

}
