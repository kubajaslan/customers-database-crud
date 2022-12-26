package com.example.dao;

import com.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
//repository for dao impl
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);


        List<Customer> customers = query.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Customer where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String name) {
        Session session = sessionFactory.getCurrentSession();

        Query query = null;
        System.out.println("getting here");
        if (name != null && name.trim()
                                .length() > 0) {
            query = session.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name", Customer.class);

            query.setParameter("name", "%" + name.toLowerCase() + "%");
        } else {
            query = session.createQuery("from Customer", Customer.class);
        }

        List<Customer> customers = query.getResultList();

        return customers;
    }




        @Override
        public List<Customer> searchCustomersById(String id){
            Session session = sessionFactory.getCurrentSession();

            Query query = null;

            if (id != null && id.trim()
                                .length() > 0) {
                query = session.createQuery("from Customer where id=:id", Customer.class);

                query.setParameter("id", Integer.parseInt(id));
            } else {
                query = session.createQuery("from Customer", Customer.class);
            }

            List<Customer> customers = query.getResultList();

            return customers;
        }
    }

