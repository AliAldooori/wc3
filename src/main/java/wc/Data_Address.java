package wc;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Data_Address {


    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Address.class)
            .buildSessionFactory() ;
    Session session = null;

Scanner input = new Scanner(System.in);


    public void Insert_Adresses( ) {
        try {

            session = factory.openSession();
            session.beginTransaction();
            Address address= new Address();
            // 0-gata 1-husnummer 2-postnummer 3-ort
            System.out.println("Enter the Street name ");
            String gata = input.next();
            address.setGata(gata);
            System.out.println("Enter the house number ");
            String husnummer = input.next();
            address.setHusnummer(husnummer);
            System.out.println("Enter the Postnumber ");
            String postnummer = input.next();
            address.setPostnummer(postnummer);
            System.out.println("Enter the City ");
            String city = input.next();
            address.setOrt(city);

            session.save(address) ;
            session.getTransaction().commit();
        }catch (Exception e ){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            if (session != null) session.close();
        }



    }
    public  void DeleteAddress(int id){
        try {
            session = factory.openSession();
            session.beginTransaction();
            Address address = session.find(Address.class, id);
            session.delete(address);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void UpdateAdresses (int id ) {
        try {
            session = factory.openSession();
            session.beginTransaction();
            Address address = session.find(Address.class, id);
            System.out.println("Enter the Street name ");
            String gata = input.next();
            address.setGata(gata);
            System.out.println("Enter the house number ");
            String husnummer = input.next();
            address.setHusnummer(husnummer);
            System.out.println("Enter the Postnumber ");
            String postnummer = input.next();
            address.setPostnummer(postnummer);
            System.out.println("Enter the City ");
            String city = input.next();
            address.setOrt(city);
            session.update(address);
            session.getTransaction().commit();
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }public void getAdresses (int id ) {
        try {
            session = factory.openSession();
            session.beginTransaction();
            Address address = session.find(Address.class, id);
            System.out.println(address.toString());
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }



}
