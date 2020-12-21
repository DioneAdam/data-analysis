package com.dioneadam.dataanalyzer.parser;

import com.dioneadam.dataanalyzer.models.Line;
import com.dioneadam.dataanalyzer.models.Salesman;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.StringTokenizer;

public class SalesmanParser implements Parser {

    public static SalesmanParser of() {
        return new SalesmanParser();
    }

    @Override
    public Optional<Line> parse(String data) {
        StringTokenizer tokenizer = split(data);

        if (tokenizer.countTokens() < 3) {
            return Optional.empty();
        }

        return Optional.of(
                Salesman.of()
                        .cpf(tokenizer.nextToken())
                        .name(tokenizer.nextToken())
                        .salary(new BigDecimal(tokenizer.nextToken()))
                        .build());
    }

}
