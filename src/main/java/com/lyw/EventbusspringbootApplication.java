package com.lyw;

import com.lyw.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventbusspringbootApplication {

	static MainService service;
	public static void main(String[] args) throws InterruptedException {

		SpringApplication.run(EventbusspringbootApplication.class, args);
		service.execute();
	}
	@Autowired
	public void setService(MainService service) {
		EventbusspringbootApplication.service = service;
	}
}
