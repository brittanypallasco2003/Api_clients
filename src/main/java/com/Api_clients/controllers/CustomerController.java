package com.Api_clients.controllers;

import com.Api_clients.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class CustomerController {

    private List<Customer> customersList = new ArrayList<>(Arrays.asList(
            new Customer(123, "Gerardo Morán", "gerardoM", "pass123"),
            new Customer(124, "Ximena Veléz", "ximeVelez", "pass124"),
            new Customer(157, "Juan Peréz", "juanP", "pass157"),
            new Customer(168, "Hugo Ortiz", "hugoOrtiz", "pass168")
    ));

    @GetMapping
    public List<Customer> getCustomers() {
        return customersList;
    }

    @GetMapping("/{userName}")
    public Customer getCustomer(@PathVariable String userName) {
        for (Customer customer : customersList) {
            if ((customer.getUserName()).equalsIgnoreCase(userName)) {
                return customer;
            }
        }
        return null;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customersList.add(customer);
        return customer;
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer) {
        for (Customer c : customersList) {
            if (c.getID() == customer.getID()) {
                c.setName(customer.getName());
                c.setUserName(customer.getUserName());
                c.setPassword(customer.getPassword());
                return c;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable int id) {
        for (Customer c : customersList) {
            if (c.getID() == id) {
                customersList.remove(c);
                return c;
            }
        }
        return null;
    }

    @PatchMapping
    public Customer partialUpdateCustomer(@RequestBody Customer customer) {
        for (Customer c : customersList) {
            if (c.getID() == customer.getID()) {
                // Validate that fields are not empty
                if (customer.getName() != null) {
                    c.setName(customer.getName());
                }
                if (customer.getUserName() != null) {
                    c.setUserName(customer.getUserName());
                }
                if (customer.getPassword() != null) {
                    c.setPassword(customer.getPassword());
                }
                return c;
            }
        }
        return null;
    }


}
