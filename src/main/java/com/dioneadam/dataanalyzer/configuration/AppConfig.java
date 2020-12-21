package com.dioneadam.dataanalyzer.configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AppConfig {

    private static final Path HOME_PATH = Paths.get(System.getProperty("user.home"));

    public static final String OUTPUT_FILENAME = "%s.done.dat";
    public static final Path INPUT_PATH = Paths.get(HOME_PATH.toString(), "data", "in");
    public static final Path OUTPUT_PATH = Paths.get(HOME_PATH.toString(), "data", "out");

}