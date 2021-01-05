package com.dioneadam.dataanalyzer.models.data;

import java.math.BigDecimal;

public class Salesman implements Line {

    public static final String ID = "001";

    private String cpf;
    private String name;
    private BigDecimal salary;

    @Override
    public boolean isEquals(String id) {
        return ID.equals(id);
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

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public static Builder of() {
        return new Builder();
    }

    public static final class Builder {
        private final Salesman salesman;

        private Builder() {
            salesman = new Salesman();
        }

        public Builder cpf(String cpf) {
            salesman.setCpf(cpf);
            return this;
        }

        public Builder name(String name) {
            salesman.setName(name);
            return this;
        }

        public Builder salary(BigDecimal salary) {
            salesman.setSalary(salary);
            return this;
        }

        public Salesman build() {
            return salesman;
        }
    }

}