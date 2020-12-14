package com.dioneadam.dataanalyzer.managers;

import com.dioneadam.dataanalyzer.models.Salesman;

import java.util.ArrayList;
import java.util.List;

public class SalesmanManager {
    
    private final List<Salesman> salesmen;

    public SalesmanManager() {
        salesmen = new ArrayList<>();
    }

    public List<Salesman> getSalesmen() {
        return salesmen;
    }

    public void addSalesman(Salesman salesman) {
       this.salesmen.add(salesman);
    }

	public int amountOfSalesman() {
		return salesmen.size();
	}

}