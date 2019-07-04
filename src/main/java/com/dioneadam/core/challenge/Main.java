package com.dioneadam.core.challenge;

import com.dioneadam.core.challenge.configuration.AppConfig;
import com.dioneadam.core.challenge.controllers.DataAnalysis;
import com.dioneadam.core.challenge.controllers.DirectoryWatcher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	private static ApplicationContext applicatioContext = new AnnotationConfigApplicationContext(AppConfig.class);
	private static DataAnalysis dataAnalysis = (DataAnalysis) applicatioContext.getBean("dataAnalysis");
	private static DirectoryWatcher directoryWatcher = (DirectoryWatcher) applicatioContext.getBean("directoryWatcher");

	public static void main(String[] args) {
		dataAnalysis.analyze();
		directoryWatcher.watchDirectory();
	}
}