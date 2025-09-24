package com.shop.Shopsetup.controller;


import com.shop.Shopsetup.model.Product;
import com.shop.Shopsetup.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public List<Product> getproducts(){


        return service.getproducts();
    }

    @GetMapping("/{id}")
    public Product getbyproductid(@PathVariable int id){

        return service.getbyproductid(id);
    }

    @PostMapping

    public Product addproduct(@RequestBody Product prod){
        System.out.println(prod);
        return service.addproduct(prod);
    }

    public void updateproduct(@RequestBody Product prod){
        service.updateproduct(prod);
    }

    public void deleteproduct(@PathVariable int id){
        service.deleteproduct(id);
    }
}
