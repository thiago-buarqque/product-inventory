package com.company.inventory.product_inventory.controller;

import com.company.inventory.product_inventory.model.Product;
import com.company.inventory.product_inventory.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/products")
@Validated
public class ProductController {
    @Autowired
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/sku/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@PathVariable Integer sku, @RequestBody Product product) {
        return productService.updateProduct(sku, product);
    }

    @GetMapping(value = "/sku/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductBySku(@PathVariable Integer sku) {
        return productService.getProductBySku(sku);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllProducts() {
        productService.deleteAllProducts();
    }

    @DeleteMapping(value = "/sku/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable Integer sku) {
        productService.deleteProduct(sku);
    }

    @GetMapping("/warehouse-by-locality")
    public List<Product> getProductsByWarehouse(@RequestParam String locality) {
        return productService.getProductsByWarehouse(locality);
    }

}
