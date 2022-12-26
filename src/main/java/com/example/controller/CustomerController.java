package com.example.controller;

import com.example.dao.CustomerDAO;
import com.example.entity.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    //inject the service
    @Autowired
    private CustomerService customerService;


    @GetMapping("/list")
    public String listCustomers(Model model) {

        List<Customer> customers = customerService.getCustomers();

        model.addAttribute("customers", customers);


        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Customer customer = new Customer();

        model.addAttribute("customer", customer);


        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {

        customerService.saveCustomer(customer);

        return "redirect:/customer/list";

    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
        Customer customer = customerService.getCustomer(id);

        model.addAttribute("customer", customer);


        return "customer-form";

    }


    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int id){
        customerService.delete(id);
        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("name") String name, Model model){
        List<Customer> customers = customerService.searchCustomers(name);

        model.addAttribute("customers", customers);

        return "list-customers";

    }


    @GetMapping("/searchById")
    public String searchCustomersById(@RequestParam("id") String id, Model model){
        List<Customer> customers = customerService.searchCustomersById(id);

        model.addAttribute("customers", customers);

        return "list-customers";

    }

}
