package com.dioneadam.dataanalyzer.managers;

import com.dioneadam.dataanalyzer.models.Sale;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SalesManager {

    private final List<Sale> sales;

    public SalesManager() {
        sales = new ArrayList<>();
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void addSale(Sale sale) {
        this.sales.add(sale);
    }

    public Optional<Integer> getIdOfTheMostExpensiveSale() {
        sales.sort(Comparator.comparing(Sale::getSalePrice).reversed());
        if (getSales().size() > 0) {
            return Optional.of(getSales().get(0).getSaleId());
        }
        return Optional.empty();
    }

    public Optional<String> getWorstSalesmanEver() {
        Map<String, Double> map = sales.stream()
                .collect(Collectors.groupingBy(Sale::getSalesmanName, Collectors.summingDouble(Sale::getSalePrice)));

        if (map.size() > 0) {
            Entry<String, Double> worstSalesman = Collections.min(map.entrySet(), Entry.comparingByValue());

            return Optional.of(worstSalesman.getKey());
        }
        return Optional.empty();
    }

}