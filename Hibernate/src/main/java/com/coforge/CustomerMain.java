package com.coforge;

import com.coforge.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerMain {

    public static void main(String[] args) {
        Configuration configuration=new Configuration().configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.getTransaction();
        Customer customer=new Customer();
        customer.setId(10001);
        customer.setName("sumit kumar");
        customer.setSalary(15000);

        transaction.begin();
        session.save(customer);
        transaction.commit();

        Query<Customer> fromCustomer = session.createQuery("from Customer");

        List<Customer> list = fromCustomer.list();
        list.forEach(a-> System.out.println(a.getId()+"\t"+a.getName()+"\t"+a.getSalary()));
    }

}
