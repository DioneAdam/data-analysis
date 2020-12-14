package com.dioneadam.dataanalyzer.managers;

import com.dioneadam.dataanalyzer.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    
    private final List<Customer> customers;

    public CustomerManager() {
        customers = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) { this.customers.add(customer);
    }

	public int amountOfClients() {
		return customers.size();
    }

}