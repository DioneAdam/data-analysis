package com.dioneadam.dataanalyzer.service;

import com.dioneadam.dataanalyzer.managers.CustomerManager;
import com.dioneadam.dataanalyzer.managers.SalesManager;
import com.dioneadam.dataanalyzer.managers.SalesmanManager;
import com.dioneadam.dataanalyzer.models.*;
import com.dioneadam.dataanalyzer.parser.CustomerParser;
import com.dioneadam.dataanalyzer.parser.SaleParser;
import com.dioneadam.dataanalyzer.parser.SalesmanParser;
import com.dioneadam.dataanalyzer.parser.factory.ParserFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ParseService {

    private static final Logger logger = LoggerFactory.getLogger(ParseService.class);

    CustomerManager customerManager;
    SalesManager salesManager;
    SalesmanManager salesmanManager ;

    public DataWrapper parseLines(List<String> lines) {

        customerManager = new CustomerManager();
        salesManager = new SalesManager();
        salesmanManager = new SalesmanManager();

        lines
                .stream()
                .filter(StringUtils::hasText)
                .map(this::parseLine)
                .filter(Optional::isPresent)
                .forEach(line -> {
                    if (line.get().isEquals(Salesman.ID)) {
                        salesmanManager.addSalesman((Salesman) line.get());
                    } else if (line.get().isEquals(Customer.ID)) {
                        customerManager.addCustomer((Customer) line.get());
                    } else if (line.get().isEquals(Sale.ID)) {
                        salesManager.addSale((Sale) line.get());
                    }
                });

        return new DataWrapper(customerManager, salesManager, salesmanManager);

//                .map(Optional::get)
//                .collect(Collectors.toList());
    }

    private Optional<Line> parseLine(String line) {
        try {
            String type = line.substring(0,3);
            String data = line.substring(4);
            return ParserFactory
                    .of(type)
                    .parse(data);
        } catch (Exception e) {
            logger.error("error converting data entry: " + line);
            return Optional.empty();
        }
    }

}