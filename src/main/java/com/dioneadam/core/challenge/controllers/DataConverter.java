package com.dioneadam.core.challenge.controllers;

import com.dioneadam.core.challenge.models.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dioneadam.core.challenge.managers.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataConverter {

    @Autowired
    private CustomerManager customerManager;

    @Autowired
    private SalesManager salesManager;

    @Autowired
    private SalesmanManager salesmanManager;

    private static Logger logger = LoggerFactory.getLogger(DataConverter.class);

    public void convert(List<String> entrys) {
        for (String entry : entrys) {
            try {
                String separator = String.valueOf(entry.charAt(3));
                String[] data = entry.split(separator, 4);
                int id = Integer.parseInt(data[0]);

                switch (id) {
                case 1:
                    salesmanManager.addSalesman(createSalesman(data));
                    break;
                case 2:
                    customerManager.addCustomer(createCustomer(data));
                    break;
                case 3:
                    salesManager.addSale(createSale(data));
                    break;
                }
            } catch (Exception e) {
                logger.error("error converting data entry: " + entry);
            }
        }
    }

    private Salesman createSalesman(String[] entry) {
        String cpf = entry[1];
        String name = entry[2];
        Double salary = Double.parseDouble(entry[3]);
        return new Salesman(cpf, name, salary);
    }

    private Customer createCustomer(String[] entry) {
        String cnpj = entry[1];
        String name = entry[2];
        String bussinesArea = entry[3];
        return new Customer(cnpj, name, bussinesArea);
    }

    private Sale createSale(String[] entry) {
        String squareBracketsRemove = "\\[|\\]";
        String splitSales = ",";
        String splitItems = "\\D";

        int saleId = Integer.parseInt(entry[1]);
        String salesmanName = entry[3];

        String saleList = entry[2].replaceAll(squareBracketsRemove, "");
        String[] sales = saleList.split(splitSales);
        List<Item> itemsList = new ArrayList<>();
        for (String sale : sales) {
            String[] item = sale.split(splitItems, 3);
            if (item.length == 3) {
                int itemId = Integer.parseInt(item[0]);
                int itemQntd = Integer.parseInt(item[1]);
                Double itemPrice = Double.parseDouble(item[2]);
                itemsList.add(new Item(itemId, itemQntd, itemPrice));
            }
        }
        return new Sale(saleId, itemsList, salesmanName);
    }

}