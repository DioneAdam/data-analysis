package com.dioneadam.dataanalyzer.models;

public class DataAnalyse {

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

    public static Builder of() {
        return new Builder();
    }

    public static final class Builder {
        private final DataAnalyse dataAnalyse;

        private Builder() {
            dataAnalyse = new DataAnalyse();
        }

        public Builder amountOfClients(Integer amountOfClients) {
            dataAnalyse.setAmountOfClients(amountOfClients);
            return this;
        }

        public Builder amountOfSalesman(Integer amountOfSalesman) {
            dataAnalyse.setAmountOfSalesman(amountOfSalesman);
            return this;
        }

        public Builder mostExpensiveSale(Integer mostExpensiveSale) {
            dataAnalyse.setMostExpensiveSale(mostExpensiveSale);
            return this;
        }

        public Builder worstSalesman(String worstSalesman) {
            dataAnalyse.setWorstSalesman(worstSalesman);
            return this;
        }

        public DataAnalyse build() {
            return dataAnalyse;
        }
    }
}
