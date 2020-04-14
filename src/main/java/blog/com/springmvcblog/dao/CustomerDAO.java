package blog.com.springmvcblog.dao;

import java.util.List;

import blog.com.springmvcblog.model.Customer;

public interface CustomerDAO {

	Customer findById(String id);

	List<Customer> findAll();

	void insert(Customer customer);

	void update(Customer customer);

	void delete(String id);
}
