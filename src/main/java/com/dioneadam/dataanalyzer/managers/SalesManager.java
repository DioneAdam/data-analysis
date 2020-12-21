package com.dioneadam.dataanalyzer.managers;

import com.dioneadam.dataanalyzer.models.Sale;

import java.math.BigDecimal;
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
        Map<String, BigDecimal> map = sales
                .stream()
                .collect(Collectors.toMap(Sale::getSalesmanName, Sale::getSalePrice));

        if (map.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(Collections
                .min(map.entrySet(), Entry.comparingByValue())
                .getKey());

    }

}