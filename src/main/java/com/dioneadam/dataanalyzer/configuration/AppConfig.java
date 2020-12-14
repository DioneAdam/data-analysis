package com.dioneadam.dataanalyzer.configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AppConfig {

    public static final String OUTPUT_FILENAME = "%s.done.dat";
    public static final Path HOMEPATH = Paths.get(System.getProperty("user.home"));
    public static final Path INPUT_PATH = Paths.get(HOMEPATH.toString(), "data", "in");
    public static final Path OUTPUT_PATH = Paths.get(HOMEPATH.toString(), "data", "out");

}