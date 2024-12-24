package com.Api_clients.controllers;

import com.Api_clients.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class CustomerController {

    private List<Customer> customersList = new ArrayList<>(Arrays.asList(new Customer(123, "Gerardo Morán", "gerardoM", "pass123"), new Customer(124, "Ximena Veléz", "ximeVelez", "pass124"), new Customer(157, "Juan Peréz", "juanP", "pass157"), new Customer(168, "Hugo Ortiz", "hugoOrtiz", "pass168")));

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customersList);
    }

    //@RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @GetMapping("/{userName}")
    public ResponseEntity<?> getCustomer(@PathVariable String userName) {
        for (Customer customer : customersList) {
            if ((customer.getUserName()).equalsIgnoreCase(userName)) {
                return ResponseEntity.ok(customer);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con username " + userName);
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        customersList.add(customer);
        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userName}")
                .buildAndExpand(customer.getUserName())
                .toUri();
        //return ResponseEntity.created(location).build();
        return ResponseEntity.created(location).body(customer);
    }

    //@RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
        for (Customer c : customersList) {
            if (c.getID() == customer.getID()) {
                c.setName(customer.getName());
                c.setUserName(customer.getUserName());
                c.setPassword(customer.getPassword());
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }


    //@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        for (Customer c : customersList) {
            if (c.getID() == id) {
                customersList.remove(c);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con el ID: "+id);
    }

    //@RequestMapping(method = RequestMethod.PATCH)
    @PatchMapping
    public ResponseEntity<?> partialUpdateCustomer(@RequestBody Customer customer) {
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
                return ResponseEntity.ok("Cliente modificado satisfactoriamente: "+customer.getID());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con ID: "+customer.getID());
    }


}
