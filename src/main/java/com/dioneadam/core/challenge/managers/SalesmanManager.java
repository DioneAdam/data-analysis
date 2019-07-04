package com.dioneadam.core.challenge.managers;

import java.util.ArrayList;
import java.util.List;
import com.dioneadam.core.challenge.models.Salesman;

public class SalesmanManager {
    
    private List<Salesman> salesmen;

    public SalesmanManager() {
        salesmen = new ArrayList<>();
    }

    public List<Salesman> getSalesmen() {
        return salesmen;
    }

    public Boolean addSalesman(Salesman salesman) {
       return salesmen.add(salesman);
    }

    public void clearSalesmen() {
        salesmen.clear();
    }

	public int amountOfSalesman() {
		return salesmen.size();
	}

}