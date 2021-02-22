package com.dioneadam.dataanalyzer.stub;

import com.dioneadam.dataanalyzer.models.data.Line;

import java.util.Arrays;
import java.util.List;

import static com.dioneadam.dataanalyzer.stub.CustomerStub.createCustomer;
import static com.dioneadam.dataanalyzer.stub.SaleStub.createSale;
import static com.dioneadam.dataanalyzer.stub.SalesmanStub.createSalesman;

public class DataStub {

    public static List<Line> createListWithAllElements() {
        return Arrays.asList(createCustomer(), createSale(999, 3), createSalesman());
    }

    public static List<Line> createListWithOnlySales() {
        return Arrays.asList(createSale(999, 3), createSale(998, 2));
    }

    public static List<Line> createListWithoutSalesman() {
        return Arrays.asList(createCustomer(), createSale(999, 3));
    }

    public static List<Line> createListWithoutCustomer() {
        return Arrays.asList(createSalesman(), createSale(999, 3));
    }

    public static List<Line> createListWithoutMostExpensiveSaleId() {
        return Arrays.asList(createCustomer(), createSalesman());
    }
}
