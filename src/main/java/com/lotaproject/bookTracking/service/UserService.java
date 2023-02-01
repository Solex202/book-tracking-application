package com.lotaproject.bookTracking.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id){
        return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product with" + id + "not found"));
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
