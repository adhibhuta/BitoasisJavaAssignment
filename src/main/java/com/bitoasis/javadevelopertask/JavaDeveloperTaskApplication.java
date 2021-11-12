package com.bitoasis.javadevelopertask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavaDeveloperTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaDeveloperTaskApplication.class, args);
	}

}
