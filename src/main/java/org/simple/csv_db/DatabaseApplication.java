package org.simple.csv_db;

import org.apache.camel.CamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DatabaseApplication {

    public static void main(String[] args) throws Exception {
	ApplicationContext applicationContext = SpringApplication.run(DatabaseApplication.class, args);
	CamelContext camelContext = applicationContext.getBean(CamelContext.class);
	camelContext.startAllRoutes();
	Thread.sleep(100000);
    }
}
