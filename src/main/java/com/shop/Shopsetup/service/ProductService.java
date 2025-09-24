package com.shop.Shopsetup.service;

import com.shop.Shopsetup.model.Product;
import com.shop.Shopsetup.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

//    List<Product> productList = new ArrayList<>(Arrays.asList(
//            new Product(1, "iphone", 2000),
//            new Product(2, "camera", 1000)));

    public List<Product> getproducts(){

        return repo.findAll();
    }

    public Product getbyproductid(int id){
        return repo.findById(id).orElse(new Product());
    }

    public Product addproduct(Product product) {
       return repo.save(product);
    }


    public void updateproduct(Product prod) {
       repo.save(prod);

    }

    public void deleteproduct(int id) {
        repo.deleteById(id);
    }
}
