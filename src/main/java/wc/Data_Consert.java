package wc;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data_Consert {
    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Consert.class)
            .addAnnotatedClass(Arena.class)
            .addAnnotatedClass(Address.class)
            .buildSessionFactory() ;
    Session session = null;

    Scanner input = new Scanner(System.in);


    public void Insert_Concert ( ) {
        try {

            session = factory.openSession();
            session.beginTransaction();
            Consert consert= new Consert();
            Address address = new Address();
            Arena arena = new Arena();
            List<Arena> arenas = new ArrayList<>();

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

            System.out.println("Enter the Arena name ");
            String arena_name = input.next();
            arena.setArenaName(arena_name);
            System.out.println("Enter if insaide or outside");
            Boolean place = input.nextBoolean();
            arena.setInomhusUtomhus(place);


            System.out.println("Enter the Artist name ");
            String artistName = input.next();
            consert.setArtistnamn(artistName);
            System.out.println("Enter the Datum ");
            String datum = input.next();
            consert.setDatum(datum);
            System.out.println("Enter the Ticket price ");
            String biljettpris = input.next();
            consert.setBiljettpris(biljettpris);

           /* Data_Arena dataArena = new Data_Arena() ;
            dataArena.Insert_Arena();

            Data_Address dataAddress = new Data_Address();
            dataAddress.Insert_Adresses();*/

            arena.setArena_adress(address);
            consert.getArena().add(arena);
            consert.setArena(arenas);


            session.save(consert) ;
            session.getTransaction().commit();
        }catch (Exception e ){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            if (session != null) session.close();
        }


    }
    public  void Delete_Consert (int id){
        try {
            session = factory.openSession();
            session.beginTransaction();
            Consert consert = session.find(Consert.class, id);
            session.delete(consert);
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
            Consert consert = session.find(Consert.class, id);
            session.update(consert);
            session.getTransaction().commit();
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }public void get_Concert (int id ) {
        try {
            session = factory.openSession();
            session.beginTransaction();
            Consert consert = session.find(Consert.class, id);
            System.out.println(consert.toString());
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
