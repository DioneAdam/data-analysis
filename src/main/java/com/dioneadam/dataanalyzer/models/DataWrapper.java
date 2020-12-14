package com.dioneadam.dataanalyzer.models;

import com.dioneadam.dataanalyzer.managers.CustomerManager;
import com.dioneadam.dataanalyzer.managers.SalesManager;
import com.dioneadam.dataanalyzer.managers.SalesmanManager;

public class DataWrapper {

    private CustomerManager customerManager;
    private SalesManager salesManager;
    private SalesmanManager salesmanManager;


    public DataWrapper() { }

    public DataWrapper(CustomerManager customerManager, SalesManager salesManager, SalesmanManager salesmanManager) {
        this.customerManager = customerManager;
        this.salesManager = salesManager;
        this.salesmanManager = salesmanManager;
    }

    public CustomerManager getCustomerManager() {
        return customerManager;
    }

    public void setCustomerManager(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    public SalesManager getSalesManager() {
        return salesManager;
    }

    public void setSalesManager(SalesManager salesManager) {
        this.salesManager = salesManager;
    }

    public SalesmanManager getSalesmanManager() {
        return salesmanManager;
    }

    public void setSalesmanManager(SalesmanManager salesmanManager) {
        this.salesmanManager = salesmanManager;
    }
}
