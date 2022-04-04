package wc;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Data_Customer {
    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Customer.class)
            .buildSessionFactory() ;
    Session session = null;

    Scanner input = new Scanner(System.in);


    public void Insert_Customer( ) {
        try {

            session = factory.openSession();
            session.beginTransaction();
            Customer customer= new Customer();
            // 0-gata 1-husnummer 2-postnummer 3-ort
            System.out.println("Enter the First name ");
            String first_name = input.next();
            customer.setFörnamn(first_name);
            System.out.println("Enter the Last name ");
            String Last_name = input.next();
            customer.setEfternamn(Last_name);
            System.out.println("Enter the Birthday ");
            String födelsedatum = input.next();
            customer.setFödelsedatum(födelsedatum);
            System.out.println("Enter telefon number ");
            String telefon = input.next();
            customer.setTelefonnummer(telefon);

            session.save(customer) ;
            session.getTransaction().commit();
        }catch (Exception e ){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            if (session != null) session.close();
        }


    }
    public  void Delete_Customer (int id){
        try {
            session = factory.openSession();
            session.beginTransaction();
            Customer customer = session.find(Customer.class, id);
            session.delete(customer);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void Update_Customer (int id ) {
        try {
            session = factory.openSession();
            session.beginTransaction();
            Customer customer = session.find(Customer.class, id);
            session.update(customer);
            session.getTransaction().commit();
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }public void get_Customer  (int id ) {
        try {
            session = factory.openSession();
            session.beginTransaction();
            Customer customer = session.find(Customer.class, id);
            System.out.println(customer.toString());
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
