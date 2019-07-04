package com.dioneadam.core.challenge.managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.dioneadam.core.challenge.models.Sale;

public class SalesManager {

    private List<Sale> sales;

    public SalesManager() {
        sales = new ArrayList<>();
    }

    public List<Sale> getSales() {
        return sales;
    }

    public Boolean addSale(Sale sale) {
        return sales.add(sale);
    }

    public void clearSales() {
        sales.clear();
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
            Entry<String, Double> worstSalesman = Collections.min(map.entrySet(),
                    Comparator.comparing(Map.Entry::getValue));

            return Optional.of(worstSalesman.getKey());
        }
        return Optional.empty();
    }

}