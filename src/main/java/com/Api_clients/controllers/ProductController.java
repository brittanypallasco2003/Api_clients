package com.Api_clients.controllers;

import com.Api_clients.service.ProductService;
import com.Api_clients.service.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    //Instancia de clase
    //ProductService productService= new ProductsServiceImpl();
    //Inyección de Dependencia
    @Autowired
    //@Qualifier("jsonResourceService")
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> showProducts() {
        return ResponseEntity.ok(productService.getProductList());
    }

}
