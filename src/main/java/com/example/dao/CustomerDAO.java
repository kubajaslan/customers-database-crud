package com.example.dao;

import com.example.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    public Customer getCustomer(int id);

    public void delete(int id);

    List<Customer> searchCustomers(String name);

    List<Customer> searchCustomersById(String id);
}
