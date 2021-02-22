package com.dioneadam.dataanalyzer.stub;

import com.dioneadam.dataanalyzer.models.data.Customer;

public class CustomerStub {
    public static Customer createCustomer() {
        return Customer.of()
                .businessArea("Tech")
                .cnpj("89663784000130")
                .name("Arlindo")
                .build();
    }
}
