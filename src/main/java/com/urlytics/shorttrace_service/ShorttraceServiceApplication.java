package com.urlytics.shorttrace_service;

import com.urlytics.shorttrace_service.service.UrlShortener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShorttraceServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShorttraceServiceApplication.class, args);
		String hash = UrlShortener.createHash("https://google.com");
		System.out.println(hash);
	}

}
