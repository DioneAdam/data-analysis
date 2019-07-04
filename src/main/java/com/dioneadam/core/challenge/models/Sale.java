package com.dioneadam.core.challenge.models;

import java.util.List;

public class Sale {

    private final int ID = 3;
    private int saleId;
    private List<Item> items;
    private String salesmanName;

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