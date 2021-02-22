package com.dioneadam.dataanalyzer.models;

public class AnalyzedData {

    private Integer amountOfClients;
    private Integer amountOfSalesman;
    private Integer mostExpensiveSale;
    private String worstSalesman;

    public Integer getAmountOfClients() {
        return amountOfClients;
    }

    public void setAmountOfClients(Integer amountOfClients) {
        this.amountOfClients = amountOfClients;
    }

    public Integer getAmountOfSalesman() {
        return amountOfSalesman;
    }

    public void setAmountOfSalesman(Integer amountOfSalesman) {
        this.amountOfSalesman = amountOfSalesman;
    }

    public Integer getMostExpensiveSale() {
        return mostExpensiveSale;
    }

    public void setMostExpensiveSale(Integer mostExpensiveSale) {
        this.mostExpensiveSale = mostExpensiveSale;
    }

    public String getWorstSalesman() {
        return worstSalesman;
    }

    public void setWorstSalesman(String worstSalesman) {
        this.worstSalesman = worstSalesman;
    }

    @Override
    public String toString() {
        return "AnalyzedData:" +
                "\nAmount of customers: " + amountOfClients +
                "\nAmount of salesmen: " + amountOfSalesman +
                "\nID of the most expensive sale: " + removeNullOfText(String.valueOf(mostExpensiveSale)) +
                "\nWorst salesman ever: " + worstSalesman;
    }

    private String removeNullOfText(String text) {
        return text.replaceAll("null", "");
    }

    public byte[] getBytes() {
        return this.toString().getBytes();
    }

    public static Builder of() {
        return new Builder();
    }

    public static final class Builder {
        private final AnalyzedData analyzedData;

        private Builder() {
            analyzedData = new AnalyzedData();
        }

        public Builder amountOfClients(Integer amountOfClients) {
            analyzedData.setAmountOfClients(amountOfClients);
            return this;
        }

        public Builder amountOfSalesman(Integer amountOfSalesman) {
            analyzedData.setAmountOfSalesman(amountOfSalesman);
            return this;
        }

        public Builder mostExpensiveSale(Integer mostExpensiveSale) {
            analyzedData.setMostExpensiveSale(mostExpensiveSale);
            return this;
        }

        public Builder worstSalesman(String worstSalesman) {
            analyzedData.setWorstSalesman(worstSalesman);
            return this;
        }

        public AnalyzedData build() {
            return analyzedData;
        }
    }
}
