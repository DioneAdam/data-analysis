package com.dioneadam.dataanalyzer.parser;

import com.dioneadam.dataanalyzer.models.data.Line;

import java.util.Optional;
import java.util.StringTokenizer;

public interface Parser {

    Optional<Line> parse(String data);

    default StringTokenizer split(String str) {
        return split(str, "ç");
    }

    default StringTokenizer split(String str, String delimiter) {
        return new StringTokenizer(str, delimiter);
    }
}
