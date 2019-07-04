package com.dioneadam.core.challenge.models;

public class Item {

    private int id;
    private int quantity;
    private Double unityPrice;

    public Item(int id, int quantity, Double unityPrice) {
        this.id = id;
        this.quantity = quantity;
        this.unityPrice = unityPrice;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getUnityPrice() {
        return unityPrice;
    }

    public Double getTotalPrice() {
        return unityPrice * quantity;
    }

}