package com.product.service;

import com.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAllProducts();

    Optional<Product> getProductById(String id);

    Product updateProduct(String id, Product product);

    String deleteProduct(String id);

    // add some methods other than CRUD Custom Operation
    // Get the product with maximum price
    // get the average of all price of all products
    Optional<Product> getMaxPriceProduct();


}
