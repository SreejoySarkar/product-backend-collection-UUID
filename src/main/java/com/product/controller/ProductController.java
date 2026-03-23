package com.product.controller;

import com.product.entity.Product;
import com.product.exception.ProductNotFoundException;
import com.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        //Product added=productService.addProduct(product);
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);//201 Created
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAllProducts());// 200 OK status code
        //return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getAProduct(@PathVariable String id) {
        return ResponseEntity.ok(productService.getProductById(id).orElseThrow(() -> new ProductNotFoundException
                ("Product not found with id " + id)));


    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));

    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.NO_CONTENT);//204 status code

    }


//    @GetMapping("{id}")
//    public ResponseEntity<Product> getAProduct2(@PathVariable int id) {
//        Product got = productService.getProductById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
//        return ResponseEntity.ok(got);
//    }


    @GetMapping("/max")
    public ResponseEntity<Product> getAProductMaxPrice() {
        return ResponseEntity.ok(productService.getMaxPriceProduct().orElseThrow(() -> new ProductNotFoundException
                ("Product not found")));


    }

}
