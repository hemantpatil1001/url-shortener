package com.urlytics.shorttrace_service;

import com.urlytics.shorttrace_service.service.UrlShortener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ShorttraceServiceApplication {

	public static void main(String[] args) {


		ApplicationContext context = SpringApplication.run(ShorttraceServiceApplication.class, args);

		// Get the UrlShortener bean from the context
		UrlShortener urlShortener = context.getBean(UrlShortener.class);

		System.out.println(urlShortener.shortenUrl("https://google.com"));
	}

}
