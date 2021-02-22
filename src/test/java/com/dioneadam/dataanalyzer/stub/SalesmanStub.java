package com.dioneadam.dataanalyzer.stub;

import com.dioneadam.dataanalyzer.models.data.Salesman;

import java.math.BigDecimal;

public class SalesmanStub {
    public static Salesman createSalesman() {
        return Salesman.of()
                .cpf("75563189951")
                .name("Leonaldo")
                .salary(BigDecimal.valueOf(5000))
                .build();
    }
}
