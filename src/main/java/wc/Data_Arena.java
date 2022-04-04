package wc;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Data_Arena {

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Arena.class).addAnnotatedClass(Address.class)
            .buildSessionFactory() ;
    Session session = null;

    Scanner input = new Scanner(System.in);


    public void Insert_Arena( ) {
        try {
            Data_Address dataAddress=new Data_Address();
             Boolean flag = false ;
            session = factory.openSession();
            session.beginTransaction();
           Arena arena = new Arena();

            System.out.println("Enter the Arena name ");
            String arena_name = input.next();
            arena.setArenaName(arena_name);
            System.out.println("Enter if insaide or outside");
            Boolean place = input.nextBoolean();
            arena.setInomhusUtomhus(place);

             dataAddress.Insert_Adresses();



            session.save(arena) ;
            session.getTransaction().commit();
        }catch (Exception e ){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            if (session != null) session.close();
        }


    }
    public  void DeleteArena(int id){
        try {
            session = factory.openSession();
            session.beginTransaction();
            Arena arena = session.find(Arena.class, id);
            session.delete(arena);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void UpdateArena (int id ) {
        try {
            session = factory.openSession();
            session.beginTransaction();
           Arena arena = session.find(Arena.class, id);
            session.update(arena);
            session.getTransaction().commit();
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }public void getArena (int id ) {
        try {
            session = factory.openSession();
            session.beginTransaction();
            Arena arena = session.find(Arena.class, id);
            System.out.println(arena.toString());
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
