package com.dioneadam.dataanalyzer.parser.factory;

import com.dioneadam.dataanalyzer.models.Customer;
import com.dioneadam.dataanalyzer.models.Sale;
import com.dioneadam.dataanalyzer.models.Salesman;
import com.dioneadam.dataanalyzer.parser.CustomerParser;
import com.dioneadam.dataanalyzer.parser.Parser;
import com.dioneadam.dataanalyzer.parser.SaleParser;
import com.dioneadam.dataanalyzer.parser.SalesmanParser;

public class ParserFactory {

    public static Parser of(String type) {

        if (Salesman.ID.equals(type)) {
            return SalesmanParser.of();
        }

        if (Customer.ID.equals(type)) {
            return CustomerParser.of();
        }

        if(Sale.ID.equals(type)) {
            return SaleParser.of();
        }

        throw new IllegalArgumentException(String.format("Unknown type %s", type));
    }

}
