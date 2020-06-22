package com.fm.virtue.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.fm.virtue")
@EnableJpaRepositories(basePackages = "com.fm.virtue")
@EntityScan(basePackages = "com.fm.virtue")
public class VirtueApplication {

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
