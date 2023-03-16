package com.h2example.crudlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
		@PropertySource("classpath:sample.properties"),
		@PropertySource("classpath:db.properties")
})
public class CrudloginApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CrudloginApplication.class, args);
	}

}
