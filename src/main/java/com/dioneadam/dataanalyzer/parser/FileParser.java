package com.dioneadam.dataanalyzer.parser;

import com.dioneadam.dataanalyzer.models.data.Line;
import com.dioneadam.dataanalyzer.parser.factory.ParserFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FileParser {

    private static final Logger logger = LoggerFactory.getLogger(FileParser.class);

    public List<Line> parseLines(List<String> lines) {

        return lines
                .stream()
                .filter(StringUtils::hasText)
                .map(this::parseLine)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private Optional<Line> parseLine(String line) {
        try {
            String type = line.substring(0,3);
            String data = line.substring(4);
            return ParserFactory
                    .of(type)
                    .parse(data);
        } catch (Exception e) {
            logger.error("error converting data entry: " + line);
            return Optional.empty();
        }
    }

}