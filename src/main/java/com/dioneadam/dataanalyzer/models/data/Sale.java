package com.dioneadam.dataanalyzer.models.data;

import java.math.BigDecimal;
import java.util.List;

public class Sale implements Line {

    public static final String ID = "003";

    private Integer saleId;
    private List<Item> items;
    private String salesmanName;

    @Override
    public boolean isEquals(String id) {
        return ID.equals(id);
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public BigDecimal getSalePrice() {
        return items
                .stream()
                .map(Item::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static Builder of() {
        return new Builder();
    }

    public static final class Builder {
        private final Sale sale;

        private Builder() {
            sale = new Sale();
        }

        public Builder saleId(Integer saleId) {
            sale.setSaleId(saleId);
            return this;
        }

        public Builder items(List<Item> items) {
            sale.setItems(items);
            return this;
        }

        public Builder salesmanName(String salesmanName) {
            sale.setSalesmanName(salesmanName);
            return this;
        }

        public Sale build() {
            return sale;
        }
    }

}