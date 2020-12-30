package com.datadriven.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigProperties {

	public static void main(String[] args) throws IOException {

		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("/Users/aniruddhabasak/BCS053/jsf-for-beginners/workspace/2020December-TestNG/src/com/datadriven/test/config.properties");

		prop.load(ip);

	}
}
