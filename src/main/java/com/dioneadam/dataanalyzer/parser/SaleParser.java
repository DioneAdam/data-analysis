package com.dioneadam.dataanalyzer.parser;

import com.dioneadam.dataanalyzer.models.data.Item;
import com.dioneadam.dataanalyzer.models.data.Line;
import com.dioneadam.dataanalyzer.models.data.Sale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

public class SaleParser implements Parser {

    public static SaleParser of() {
        return new SaleParser();
    }

    @Override
    public Optional<Line> parse(String data) {
        StringTokenizer tokenizer = split(data);

        if (tokenizer.countTokens() < 3) {
            return Optional.empty();
        }

        return Optional.of(
                Sale.of()
                        .saleId(Integer.parseInt(tokenizer.nextToken()))
                        .items(parseSaleItems(tokenizer.nextToken()))
                        .salesmanName(tokenizer.nextToken())
                        .build());
    }

    private List<Item> parseSaleItems(String line) {
        String data = line.replaceAll("[\\[|\\]]", "");

        StringTokenizer tokenizer = split(data, ",");

        List<Item> items = new ArrayList<>();

        while(tokenizer.hasMoreTokens()) {
            items.add(parseSaleItem(tokenizer.nextToken()));
        }

        return items;
    }

    private Item parseSaleItem(String line) {
        StringTokenizer tokenizer = split(line, "-");

        return Item.of()
                .id(Integer.parseInt(tokenizer.nextToken()))
                .quantity(Integer.parseInt(tokenizer.nextToken()))
                .unityPrice(new BigDecimal(tokenizer.nextToken()))
                .build();
    }

}
