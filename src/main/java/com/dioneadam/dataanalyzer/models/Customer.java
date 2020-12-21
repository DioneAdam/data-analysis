package com.dioneadam.dataanalyzer.models;

public class Customer implements Line {

    public static final String ID = "002";

    private String cnpj;
    private String name;
    private String businessArea;

    @Override
    public boolean isEquals(String id) {
        return ID.equals(id);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public static Builder of() {
        return new Builder();
    }

    public static final class Builder {
        private final Customer customer;

        private Builder() {
            customer = new Customer();
        }

        public Builder cnpj(String cnpj) {
            customer.setCnpj(cnpj);
            return this;
        }

        public Builder name(String name) {
            customer.setName(name);
            return this;
        }

        public Builder businessArea(String businessArea) {
            customer.setBusinessArea(businessArea);
            return this;
        }

        public Customer build() {
            return customer;
        }
    }

}