package com.fm.virtue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VirtueApplication implements CommandLineRunner {

	@Autowired
	private TestConfig testConfig;

	public static void main(String[] args) {
		SpringApplication.run(VirtueApplication.class, args);
	}

	public void run(String... args) {
		System.out.println("Property1: " + testConfig.getProperty1());
		System.out.println("Property2: " + testConfig.getProperty2());
	}

}
