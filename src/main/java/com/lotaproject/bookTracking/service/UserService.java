package com.lotaproject.bookTracking.service;

import com.lotaproject.bookTracking.dto.RegisterUserDto;

public interface UserService {
    void registerUser(RegisterUserDto dto);

//    private final ProductRepository productRepository;
//
//    public UserService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    public MyUser addProduct(MyUser product) {
//        return productRepository.save(product);
//    }
//
//    public List<MyUser> getProducts() {
//        return productRepository.findAll();
//    }
//
//    public MyUser findProductById(Long id){
//        return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product with" + id + "not found"));
//    }
//
//    public void delete(Long id){
//        productRepository.deleteById(id);
//    }

}
