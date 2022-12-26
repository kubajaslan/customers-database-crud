package com.example.service;

import com.example.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomer(int id);

    public void delete(int id);

    public List<Customer> searchCustomers(String name);

    List<Customer> searchCustomersById(String id);
}
