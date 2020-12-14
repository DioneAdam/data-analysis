package com.dioneadam.dataanalyzer.models;

public class Salesman {

    private static final int ID = 1;

    private final String cpf;
    private final String name;
    private final Double salary;

    public Salesman(String cpf, String name, Double salary) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return ID;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

}