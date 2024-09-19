package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Address;
import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery query=session.createNativeQuery("select * from customer");
        query.addEntity(Customer.class);
        List<Customer> customerList=query.list();
        for ( Customer customer:customerList){
            System.out.println(customer);
        }

/*        session.save(customer);
        session.save(address1);
        session.save(address2);
        session.save(address3);*/


        transaction.commit();
        session.close();


    }
}
