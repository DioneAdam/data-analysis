package com.dioneadam.dataanalyzer.stub;

import com.dioneadam.dataanalyzer.models.data.Item;
import com.dioneadam.dataanalyzer.models.data.Sale;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SaleStub {
    public static Sale createSale(int id, int itemQuantity) {
        return Sale.of()
                .saleId(id)
                .items(createSalesItemsList(itemQuantity))
                .salesmanName("the worst salesman ever")
                .build();
    }

    private static List<Item> createSalesItemsList(Integer quantity) {
        return IntStream.range(1, ++quantity)
                .mapToObj(index -> createItem(index, index))
                .collect(Collectors.toList());
    }

    private static Item createItem(Integer id, int quantity) {
        return Item.of()
                .id(id)
                .unityPrice(BigDecimal.valueOf(quantity))
                .quantity(quantity)
                .build();
    }
}
