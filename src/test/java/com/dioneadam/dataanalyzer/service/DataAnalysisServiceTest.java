package com.dioneadam.dataanalyzer.service;

import com.dioneadam.dataanalyzer.models.AnalyzedData;
import com.dioneadam.dataanalyzer.models.data.Line;
import com.dioneadam.dataanalyzer.stub.AnalyzedDataStub;
import com.dioneadam.dataanalyzer.stub.DataStub;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DataAnalysisServiceTest {

    private final DataAnalysisService dataAnalysisService;

    public DataAnalysisServiceTest() {
        dataAnalysisService = new DataAnalysisService();
    }

    @Test
    public void shouldGetAnalyzedDataWithSuccess() {
        List<Line> dataToAnalyse = DataStub.createListWithAllElements();

        AnalyzedData expectedAnalyzedData = AnalyzedDataStub.createAnalyzedData();

        AnalyzedData analyzedData = dataAnalysisService.getAnalyzedData(dataToAnalyse);

        Assertions.assertThat(analyzedData)
                .usingRecursiveComparison()
                .isEqualTo(expectedAnalyzedData);
    }

    @Test
    public void shouldGetAnalyzedDataWithoutSalesman() {
        List<Line> dataToAnalyse = DataStub.createListWithoutSalesman();

        AnalyzedData expectedAnalyzedData = AnalyzedDataStub.createAnalyzedDataWithoutSalesman();

        AnalyzedData analyzedData = dataAnalysisService.getAnalyzedData(dataToAnalyse);

        Assertions.assertThat(analyzedData)
                .usingRecursiveComparison()
                .isEqualTo(expectedAnalyzedData);
    }

    @Test
    public void shouldGetAnalyzedDataWithoutCustomers() {
        List<Line> dataToAnalyse = DataStub.createListWithoutCustomer();

        AnalyzedData expectedAnalyzedData = AnalyzedDataStub.createAnalyzedDataWithoutCustomer();

        AnalyzedData analyzedData = dataAnalysisService.getAnalyzedData(dataToAnalyse);

        Assertions.assertThat(analyzedData)
                .usingRecursiveComparison()
                .isEqualTo(expectedAnalyzedData);
    }

    @Test
    public void ShouldGetAnalyzedDataWithOnlySales() {
        List<Line> dataToAnalyse = DataStub.createListWithOnlySales();

        AnalyzedData expectedAnalyzedData = AnalyzedDataStub.createAnalyzedDataWithOnlySales();

        AnalyzedData analyzedData = dataAnalysisService.getAnalyzedData(dataToAnalyse);

        Assertions.assertThat(analyzedData)
                .usingRecursiveComparison()
                .isEqualTo(expectedAnalyzedData);
    }

    @Test
    public void shouldGetAnalyzedDataWithoutMostExpensiveSale() {
        List<Line> dataToAnalyse = DataStub.createListWithoutMostExpensiveSaleId();

        AnalyzedData expectedAnalyzedData = AnalyzedDataStub.createAnalyzedDataWithoutMostExpensiveSale();

        AnalyzedData analyzedData = dataAnalysisService.getAnalyzedData(dataToAnalyse);

        Assertions.assertThat(analyzedData)
                .usingRecursiveComparison()
                .isEqualTo(expectedAnalyzedData);
    }

}