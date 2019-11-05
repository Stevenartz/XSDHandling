package com.uls.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyHandler {

	private InputStream inputStream = null;
	private OutputStream outputStream = null;

	private final String CONFIG_PATH = "config/config.properties";

	public PropertyHandler() {
		createConfigFileIfDoesntExists();
	}

	private boolean createConfigFileIfDoesntExists() {
		boolean status = false;
		try {
			status = new File(CONFIG_PATH).createNewFile();
			if (status) {
				System.out.println("Successfully created new config file!");
			} else {
				System.out.println("Config file already exists!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}

	private Properties getProperties() {
		Properties props = null;
		try {
			// TODO only one stream can be opened
			inputStream = new FileInputStream(CONFIG_PATH);
			//outputStream = new FileOutputStream(CONFIG_PATH);
			props = new Properties();
			props.load(inputStream);
		} catch (IOException io) {
			io.printStackTrace();
		}
		return props;
	}

	private boolean closeStreams() {
		boolean status = false;
		try {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
			status = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public String getProperty(String propertyName) {
		String property = getProperties().getProperty(propertyName);
		closeStreams();
		return property;
	}

	public boolean removeProperty(String propertyName) {
		boolean status = false;
		Properties props = getProperties();
		if (props.remove(propertyName) != null) {
			try {
				props.store(outputStream, null);
				status = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		closeStreams();
		return status;
	}
	
	public boolean isLocationAlreadySet() {
		boolean status = false;

		try {
			OutputStream output = new FileOutputStream(CONFIG_PATH);
			Properties prop = new Properties();

			// set the properties value
			prop.setProperty("db.url", "localhost");

			// save properties to project root folder
			prop.store(output, null);

			System.out.println(prop);

		} catch (IOException io) {
			io.printStackTrace();
		}
		return status;
	}

}
