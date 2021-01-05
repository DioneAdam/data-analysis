package com.dioneadam.dataanalyzer.service;

import com.dioneadam.dataanalyzer.models.*;
import com.dioneadam.dataanalyzer.models.data.Customer;
import com.dioneadam.dataanalyzer.models.data.Line;
import com.dioneadam.dataanalyzer.models.data.Sale;
import com.dioneadam.dataanalyzer.models.data.Salesman;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
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
        salesList.sort(Comparator.comparing(Sale::getSalePrice).reversed());
        if (salesList.size() > 0) {
            return Optional.of(salesList.get(0).getSaleId()).orElse(null);
        }
        return null;
    }

    private String findWorstSalesmanEver(List<Sale> salesList) {
        Map<String, BigDecimal> map = salesList
                .stream()
                .collect(Collectors.toMap(Sale::getSalesmanName, Sale::getSalePrice));

        if (map.isEmpty()) {
            return null;
        }

        return Optional.ofNullable(Collections
                .min(map.entrySet(), Map.Entry.comparingByValue())
                .getKey())
                .orElse(null);
    }

    private <E> List<E> getDataListFromModelClass(List<Line> parsedModels, Class<E> modelClass) {
        return parsedModels.stream()
                .filter(baseModel -> modelClass.getSimpleName().equals(baseModel.getClass().getSimpleName()))
                .map(modelClass::cast)
                .collect(Collectors.toList());
    }

}
