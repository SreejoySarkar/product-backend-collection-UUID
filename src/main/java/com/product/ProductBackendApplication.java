package com.product;

import com.product.entity.Product;
import com.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@AllArgsConstructor
public class ProductBackendApplication {
//    private final ProductService service;


    public static void main(String[] args) {
        SpringApplication.run(ProductBackendApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner amitava() {
//        return (m) -> {
//            service.addProduct(new Product(1, "Laptop", 50000.0));
//            service.addProduct(new Product(2, "Mobile", 20000.7));
//            service.addProduct(new Product(3, "Tablet", 30000.7));
//            IO.println("--added from main--");
//        };
//    }


}
