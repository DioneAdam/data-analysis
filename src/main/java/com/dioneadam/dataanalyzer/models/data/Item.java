package com.dioneadam.dataanalyzer.models.data;

import java.math.BigDecimal;

public class Item {

    private int id;
    private int quantity;
    private BigDecimal unityPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnityPrice() {
        return unityPrice;
    }

    public void setUnityPrice(BigDecimal unityPrice) {
        this.unityPrice = unityPrice;
    }

    public BigDecimal getTotalPrice() {
        return unityPrice.multiply(new BigDecimal(quantity));
    }

    public static Builder of() {
        return new Builder();
    }

    public static final class Builder {
        private final Item item;

        private Builder() {
            item = new Item();
        }

        public Builder id(int id) {
            item.setId(id);
            return this;
        }

        public Builder quantity(int quantity) {
            item.setQuantity(quantity);
            return this;
        }

        public Builder unityPrice(BigDecimal unityPrice) {
            item.setUnityPrice(unityPrice);
            return this;
        }

        public Item build() {
            return item;
        }
    }

}