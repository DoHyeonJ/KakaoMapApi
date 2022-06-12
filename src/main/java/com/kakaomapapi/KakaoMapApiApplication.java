package com.kakaomapapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class KakaoMapApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KakaoMapApiApplication.class, args);

		ApiController cont = new ApiController();
		System.out.println("---------Start----------");
		System.out.println(cont.search("126.92419268231981", "37.49212679731321", "FD6", 1000));
		System.out.println("---------End------------");
	}

}
