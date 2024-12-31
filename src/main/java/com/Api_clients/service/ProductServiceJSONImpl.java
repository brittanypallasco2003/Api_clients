package com.Api_clients.service;

import com.Api_clients.domain.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("jsonResourceService")
public class ProductServiceJSONImpl implements ProductService {

    @Override
    public List<Product> getProductList() {
        List<Product> products;
        try {
            products = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/products.json"),
                            new TypeReference<List<Product>>() {
                            });
            return products;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
