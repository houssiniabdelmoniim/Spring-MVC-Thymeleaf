package org.example.springmvcthymeleaf;

import org.example.springmvcthymeleaf.entities.Product;
import org.example.springmvcthymeleaf.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMvcThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcThymeleafApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                            .name("Computer")
                            .price(5400)
                            .quantity(12)
                    .build());
            productRepository.save(Product.builder()
                            .name("Printer")
                            .price(2300)
                            .quantity(10)
                    .build());
            productRepository.save(Product.builder()
                            .name("Smart Phone")
                            .price(6000)
                            .quantity(20)
                    .build());
            productRepository.findAll().forEach(p ->{
                System.out.println(p.toString());
            });
        };
    }

}
