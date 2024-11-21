package br.edu.catolica.ppi.costumer.ms_costumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsCostumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCostumerApplication.class, args);
	}

}
