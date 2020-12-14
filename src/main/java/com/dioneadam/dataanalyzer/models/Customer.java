package com.dioneadam.dataanalyzer.models;

public class Customer {

    private static final int ID = 2;

    private final String cnpj;
    private final String name;
    private final String businessArea;

    public Customer(String cnpj, String name, String businessArea) {
        this.cnpj = cnpj;
        this.name = name;
        this.businessArea = businessArea;
    }

    public int getId() {
        return ID;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getName() {
        return name;
    }

    public String getBusinessArea() {
        return businessArea;
    }

}