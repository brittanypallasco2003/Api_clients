package com.Api_clients.service;

import com.Api_clients.domain.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@ConditionalOnProperty(name = "service.products", havingValue = "list")
public class ProductsServiceImpl implements ProductService {

    List <Product> productList= new ArrayList<>(Arrays.asList(
          new Product(1, "Laptop", 799.99, 10),
          new Product(2, "Smartphone", 499.99, 25),
          new Product(3, "Tablet", 299.99, 15),
          new Product(4, "Smartwatch", 199.99, 30)
    ));

    @Override
    public List<Product> getProductList(){
        return productList;
    }

}
