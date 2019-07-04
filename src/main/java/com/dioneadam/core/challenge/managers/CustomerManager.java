package com.dioneadam.core.challenge.managers;

import java.util.ArrayList;
import java.util.List;
import com.dioneadam.core.challenge.models.Customer;;

public class CustomerManager {
    
    private List<Customer> customers;

    public CustomerManager() {
        customers = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Boolean addCustomer(Customer customer) {
       return customers.add(customer);
    }

    public void clearCustomers() {
        customers.clear();
    }

	public int amountOfClients() {
		return customers.size();
    }

}