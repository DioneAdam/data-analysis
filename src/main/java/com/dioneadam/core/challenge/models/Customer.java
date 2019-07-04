package com.dioneadam.core.challenge.models;

public class Customer {

    private final int ID = 2;
    private String cnpj;
    private String name;
    private String bussinesArea;

    public Customer(String cnpj, String name, String bussinesArea) {
        this.cnpj = cnpj;
        this.name = name;
        this.bussinesArea = bussinesArea;
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

    public String getBussinesArea() {
        return bussinesArea;
    }

    public void setBussinesArea(String bussinesArea) {
        this.bussinesArea = bussinesArea;
    }

}