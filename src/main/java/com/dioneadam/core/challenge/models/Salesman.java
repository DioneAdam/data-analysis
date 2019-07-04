package com.dioneadam.core.challenge.models;

public class Salesman {

    private final int ID = 1;
    private String cpf;
    private String name;
    private Double salary;

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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

}