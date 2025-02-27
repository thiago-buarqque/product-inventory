package com.company.inventory.product_inventory.service;

import com.company.inventory.product_inventory.exception.ProductAlreadyExistsException;
import com.company.inventory.product_inventory.exception.ProductNotFoundException;
import com.company.inventory.product_inventory.model.Product;
import com.company.inventory.product_inventory.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        if (productRepository.existsById(product.getSku())) {
            throw new ProductAlreadyExistsException("Product with sku " + product.getSku() + " already exists.");
        }
        product.getInventory().quantity();
        product.updateMarketableStatus();
        return productRepository.save(product);
    }

    public Product updateProduct(Integer sku, Product product) {
        if (!productRepository.existsById(sku)) {
            throw new ProductNotFoundException("Produto com SKU " + sku + " não encontrado.");
        }
        if (!sku.equals(product.getSku())) {
            throw new IllegalArgumentException("SKU do produto não pode ser alterado.");
        }
        Product productBySku = productRepository.findProductBySku(product.getSku());

        productBySku.setSku(product.getSku());
        productBySku.setName(product.getName());
        productBySku.setInventory(product.getInventory());
        productBySku.setMarketable(product.isMarketable());
        productBySku.getInventory().quantity();
        productBySku.updateMarketableStatus();
        return productRepository.save(product);
    }

    public Product getProductBySku(Integer sku) {
        return productRepository.findById(sku)
                .orElseThrow(() -> new ProductNotFoundException("Product with sku " + sku + " not found."));
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    public void deleteProduct(Integer sku) {
        if (!productRepository.existsById(sku)) {
            throw new ProductNotFoundException("Product with sku " + sku + " not found.");
        }
        productRepository.deleteById(sku);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByWarehouse(String locality) {
        List<Product> products = productRepository.findByWarehouseLocality(locality);
        if (products.isEmpty()) {
            throw new ProductNotFoundException("Nenhum produto encontrado para o armazém localizado em: " + locality);
        }
        return products;
    }
}
