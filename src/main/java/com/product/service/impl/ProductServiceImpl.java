package com.product.service.impl;

import com.product.entity.Product;
import com.product.exception.ProductNotFoundException;
import com.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class ProductServiceImpl implements ProductService {
    private List<Product> products = new ArrayList<>();

    @Override
    public Product addProduct(Product product) {
        product.setId(UUID.randomUUID().toString().replace("-", ""));//UUID auto-generate
        products.add(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Optional<Product> getProductById(String id) {
        Stream<Product> sp = products.stream();//create a stream
        Stream<Product> sp2 = sp.filter(x -> Objects.equals(x.getId(), id));//apply filter then get another new stream
        Optional<Product> op = sp2.findFirst();//terminal operation will result in an optional
        return op;
    }

    @Override
    public Product updateProduct(String id, Product product) {
        Product existing = getProductById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
        existing.setId(product.getId());
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        //products.add(existing);
        return product;
    }

    @Override
    public String deleteProduct(String id) {
        //Product existing = getProductById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
        if (products.removeIf(x -> Objects.equals(x.getId(), id)))
            return "the product has been deleted with id " + id;
        else
            return "the product has not been deleted with id " + id;
    }

    @Override
    public Optional<Product> getMaxPriceProduct() {
        return products.stream()
                .max(Comparator.comparingDouble(Product::getPrice));
    }


//    @Override
//    public Optional<Product> getProductById(Integer id) {
//        return products.stream()
//                .filter(p -> p.getId() == id)
//                .findFirst();
//    }


}
