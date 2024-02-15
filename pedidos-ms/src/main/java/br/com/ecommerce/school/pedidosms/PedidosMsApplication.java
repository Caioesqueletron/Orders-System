package br.com.ecommerce.school.pedidosms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PedidosMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidosMsApplication.class, args);
	}
}
