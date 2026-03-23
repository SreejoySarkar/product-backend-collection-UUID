package com.product.config;

import com.product.entity.Product;
import com.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Configuration
//@Component
public class ProductDemoData implements CommandLineRunner {

    public final ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        productService.addProduct(new Product("Laptoppp", 50000.0));
        productService.addProduct(new Product("Mobileee", 20000.7));
        productService.addProduct(new Product("Tablettt", 30000.7));
        productService.addProduct(new Product("WATCH", 35000.7));
        productService.addProduct(new Product("CricketBat", 10000.7));

        IO.println("-------------------------------ADDED----------------------");

    }
}
