package com.geektrust.backend;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.geektrust.backend.appconfig.ApplicationConfig;
import com.geektrust.backend.commands.CommandInvoker;

public class App {
	// To run the application ./gradlew run --args="sample_input\input1.txt"
	public static void main(String[] args) {

		ApplicationConfig configProperties = new ApplicationConfig();
		CommandInvoker commandInvoker = configProperties.getCommandInvoker();

		try {

			FileInputStream fis = new FileInputStream(args[0]);
			Scanner sc = new Scanner(fis);

			while (sc.hasNextLine()) {

				String line = sc.nextLine();
				List<String> tokens = Arrays.asList(line.split(" "));

				try {
					commandInvoker.executeCommand(tokens.get(0), tokens);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			sc.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// public static void run(List<String> commandLineArgs) {
	// // Complete the final logic to run the complete program.
	// ApplicationConfig applicationConfig = new ApplicationConfig();
	// CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();
	// BufferedReader reader;
	// String inputFile = commandLineArgs.get(0).split("=")[1];
	// commandLineArgs.remove(0);
	// try {
	// reader = new BufferedReader(new FileReader(inputFile));
	// String line = reader.readLine();
	// while (line != null) {
	// List<String> tokens = Arrays.asList(line.split(" "));
	// System.out.println(tokens.get(0));
	// commandInvoker.executeCommand(tokens.get(0), tokens);
	// // read next line
	// line = reader.readLine();
	// }
	// reader.close();
	// } catch (IOException | NoSuchCommandException e) {
	// e.printStackTrace();
	// }
}
