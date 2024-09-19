package org.example.java;

import org.example.java.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

//        //All data from the customer table

//        Query query = session.createQuery(" from Customer");

        //Specific data from the customer table

//        Query query = session.createQuery(" from Customer where cid = 1");



/*        //Unique one Data from the customer table
        Query query = session.createQuery("FROM Customer WHERE cid = ?1");
        query.setParameter(1,"1");
        Customer customer = (Customer) query.uniqueResult();
        System.out.println(customer.getCid());*/

/*        //load only one row
        Customer customer = (Customer) query.getSingleResult();
        System.out.println(customer.getCid());
        System.out.print(customer.getName());*/

/*
        //load only one coloumn
        Query query1 = session.createQuery("SELECT name FROM Customer WHERE cid = 1");
        String name = (String) query1.getSingleResult();
        System.out.println(name);
*/

        //
        Query query = session.createQuery("SELECT cid,name FROM Customer where name = 'Dilshan'");
        Object[] objects = (Object[]) query.getSingleResult();
        System.out.println(objects[0]);


        transaction.commit();
        session.close();


    }
}