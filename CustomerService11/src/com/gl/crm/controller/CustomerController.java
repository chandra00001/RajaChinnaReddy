package com.gl.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.crm.entity.Customer;
import com.gl.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//Need to inject our customer service
	@Autowired
	
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
	
		System.out.println("in List");
        //get customers from the service
	    List<Customer> theCustomers = customerService.getCustomers();
	
	    //add the customers to the model
	    theModel.addAttribute("customers", theCustomers);
	    
	    return "list-customers";
	    
  }
	@GetMapping("/showFormForAdd")
	public String showForAdd(Model theModel) {
		
		//create model attribute to bind data
		Customer theCustomer=  new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";			
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		//save the customer using service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel){
		//get the customer from service
		Customer theCustomer = customerService.getCustomer(theId);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		//send over to form
		return "customer-form";
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")int theId) {
		//delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}

}
