package com.dioneadam.dataanalyzer.models;

import java.util.List;

public class Sale {

    private static final int ID = 3;

    private final int saleId;
    private final List<Item> items;
    private final String salesmanName;

    public Sale(int saleId, List<Item> items, String salesmanName) {
        this.saleId = saleId;
        this.items = items;
        this.salesmanName = salesmanName;
    }

    public int getId() {
        return ID;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getSaleId() {
        return saleId;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public Double getSalePrice() {
        return items.stream().map(Item::getTotalPrice).mapToDouble(Double::doubleValue).sum();
    }

}