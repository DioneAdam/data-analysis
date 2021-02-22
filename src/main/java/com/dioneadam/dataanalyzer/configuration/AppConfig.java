package com.dioneadam.dataanalyzer.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;

@Configuration
public class AppConfig {

    private static String INPUT_FILE_EXTENSION;
    private static String OUTPUT_FILE_EXTENSION;
    private static Path INPUT_PATH;
    private static Path OUTPUT_PATH;

    @Value("${application.file.extension.input}")
    private void setInputFileExtension(String inputFileExtension){
        AppConfig.INPUT_FILE_EXTENSION = inputFileExtension;
    }

    @Value("${application.file.extension.output}")
    private void setOutputFileExtension(String outputFileExtension){
        AppConfig.OUTPUT_FILE_EXTENSION = outputFileExtension;
    }

    @Value("${application.directory.input}")
    private void setInputPath(Path inputPath){
        AppConfig.INPUT_PATH = inputPath;
    }

    @Value("${application.directory.output}")
    private void setOutputPath(Path outputPath){
        AppConfig.OUTPUT_PATH = outputPath;
    }

    public static String getInputFileExtension() {
        return INPUT_FILE_EXTENSION;
    }

    public static String getOutputFileExtension() {
        return OUTPUT_FILE_EXTENSION;
    }

    public static Path getInputPath() {
        return INPUT_PATH;
    }

    public static String getInputPathAsString() {
        return INPUT_PATH.toString();
    }

    public static Path getOutputPath() {
        return OUTPUT_PATH;
    }

}