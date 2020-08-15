package com.prometheus;

import com.prometheus.entity.Meno;
import com.prometheus.entity.Message;
import com.prometheus.entity.Osoba;
import com.prometheus.enums.Pohlavie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.prometheus.jpa_Hibernate_ORM_2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //POSIELANIE DAT DO DATABAZY
//        entityManager.getTransaction().begin();
//        entityManager.persist(new Message("prva sprava"));
//        entityManager.persist(new Message("druha sprava"));
//        entityManager.getTransaction().commit();
//        entityManager.close();


//        //CITANIE DAT Z DATABAZY
//        entityManager.getTransaction().begin();
//        List<Message> result =  entityManager.createQuery("from Message",Message.class).getResultList();
//        for (Message msg : result) {
//            System.out.println("Sprava " + msg.getMessage() + ", id :" + msg.getId() + ", datum vytvorenia : " + msg.getCREATE_DATE());
//        }
//        entityManager.getTransaction().commit();
//        entityManager.close();

//        entityManager.getTransaction().begin();
//        entityManager.persist(new Osoba(Pohlavie.MUZ));
//        entityManager.persist(new Osoba(Pohlavie.ZENA));
//        entityManager.persist(new Osoba(Pohlavie.MUZ));
//        entityManager.getTransaction().commit();


        Osoba osoba1 = new Osoba();
        osoba1.setPohlavie(Pohlavie.MUZ);
        osoba1.setMeno(new Meno("Mgr.","Peter","Juraj","Kratky","Phd"));

        entityManager.getTransaction().begin();
        entityManager.persist(osoba1);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        List <Osoba>  osoby = entityManager.createQuery("from Osoba",Osoba.class).getResultList();
        for (Osoba os : osoby){
            System.out.println("Osoba id : " + os.getId() +
                    "pohlavie : " + os.getPohlavie() +
                    "kod osoby : " + os.getPohlavie().getKod());
        }
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
