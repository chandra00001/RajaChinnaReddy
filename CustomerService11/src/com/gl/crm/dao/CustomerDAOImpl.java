package com.gl.crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.gl.crm.entity.Customer;

@Repository
@Transactional
@EnableTransactionManagement

public class CustomerDAOImpl implements CustomerDAO {
	
	//Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		
		//create a query....sort by lastname
		Query<Customer> theQuery =
		   currentSession.createQuery("from Customer order by lastName",Customer.class);
		//execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		//return the results
		return customers;
	}
	
	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		//get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		
		//save/update the customer
		currentSession.saveOrUpdate(theCustomer);
	}
	
	@Override
	@Transactional
	public Customer getCustomer(int theId){
	
		//get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		
		// retrieve/read from database using primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
	
        return theCustomer;
	}
	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		Session currentSession= sessionFactory.getCurrentSession();
		Query theQuery= currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	
	 }
      
    }
