package com.lotaproject.bookTracking.controller;

import com.lotaproject.bookTracking.model.MyUser;
import com.lotaproject.bookTracking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final UserService userService;

    @Autowired
    public ProductController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping
//    public ResponseEntity<List<MyUser>> getAllProducts(){
//        List<MyUser> products = userService.getProducts();
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
//
//    @GetMapping("/find/{id}")
//    public ResponseEntity<MyUser> getProductById(@PathVariable("id") Long id){
//        MyUser product = userService.findProductById(id);
//
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<MyUser> addProduct(@RequestBody MyUser product){
//        MyUser newProduct = userService.addProduct(product);
//        return new ResponseEntity<>(product, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<MyUser> updateProduct(@PathVariable("id") Long id, @RequestBody MyUser product){
//        MyUser updateProduct = userService.addProduct(product);
//        updateProduct.setName(product.getName());
//        updateProduct.setDescription(product.getDescription());
//        updateProduct.setPrice(updateProduct.getPrice());
//        updateProduct.setImageUrl(product.getImageUrl());
//
//        userService.addProduct(updateProduct);
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }
}
