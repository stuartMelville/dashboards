package com.anaplan.dashboards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DashboardsApplication {

	public static void main(String[] args) {
		try {
			System.out.println("Waiting");
			Thread.sleep(5000);
			System.out.println("Starting");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SpringApplication.run(DashboardsApplication.class, args);
	}
}
