package com.dioneadam.dataanalyzer.parser;

import com.dioneadam.dataanalyzer.models.Customer;
import com.dioneadam.dataanalyzer.models.Line;

import java.util.Optional;
import java.util.StringTokenizer;

public class CustomerParser implements Parser {

    public static CustomerParser of() {
        return new CustomerParser();
    }

    @Override
    public Optional<Line> parse(String data) {
        StringTokenizer tokenizer = split(data);

        if (tokenizer.countTokens() < 3) {
            return Optional.empty();
        }

        return Optional.of(
                Customer.of()
                        .cnpj(tokenizer.nextToken())
                        .name(tokenizer.nextToken())
                        .businessArea(tokenizer.nextToken())
                        .build());
    }

}
