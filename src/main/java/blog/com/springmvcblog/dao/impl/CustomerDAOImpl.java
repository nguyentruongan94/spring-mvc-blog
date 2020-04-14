package blog.com.springmvcblog.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import blog.com.springmvcblog.dao.CustomerDAO;
import blog.com.springmvcblog.model.Customer;

@Transactional
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	SessionFactory sessionFactory;

	public Customer findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return (Customer) session.get(Customer.class, id);
	}

	public List<Customer> findAll() {
		String hql = "FROM Customer";
		Session session = sessionFactory.getCurrentSession();
		List<Customer> list = session.createQuery(hql).list();
		return list;
	}

	public void insert(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		 session.save(customer);
	}

	public void update(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		 session.update(customer);

	}

	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		 session.delete(id);
	}

}
