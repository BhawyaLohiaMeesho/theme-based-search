package com.hacksmiths.themesearch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ThemeSearchApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(ThemeSearchApplication.class, args);
		} catch (Exception e) {
			log.error("Error in running application", e);
		}
	}
}
