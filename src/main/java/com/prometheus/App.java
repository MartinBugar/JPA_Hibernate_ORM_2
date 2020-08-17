package com.prometheus;

import com.prometheus.entity.*;
import com.prometheus.enums.Pohlavie;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
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


         //saveOsobaPrintOsoba(entityManager);
        //saveTelefonKOsobe(entityManager);
        // saveTelefon(entityManager);
        //deleteTelefon(entityManager);
        //deleteOsobaSTelefonom(entityManager);
        //getTelefon(entityManager);
        // saveViacTelefonovKOsobe(entityManager);
        //nacitajOsobuPridajTelefon(entityManager);
        //saveOsobaSaveTelefony(entityManager);
        //saveSkupinuAOsoby(entityManager);
        //loadSkupina(entityManager);
        addAdresaOsobe(entityManager);
        entityManager.close();

    }

    private static void addAdresaOsobe (EntityManager  entityManager){

        entityManager.getTransaction().begin();
        Osoba osoba = entityManager.find(Osoba.class, 13L);

        Adresa adresa = new Adresa();
        adresa.setMesto("Bratislava");
        adresa.setUlica("Kosicka");
        adresa.setPsc("82101");
        adresa.setOsoba(osoba);

        entityManager.persist(adresa);
        entityManager.getTransaction().commit();
    }

    private static void deleteSkupina(EntityManager entityManager){
        entityManager.getTransaction().begin();

        SkupinaKontaktov skupinaKontaktov = entityManager.find(SkupinaKontaktov.class,1L);
        entityManager.remove(skupinaKontaktov);

        entityManager.getTransaction().commit();
    }

    private static void loadSkupina(EntityManager entityManager){
        SkupinaKontaktov skupinaKontaktov = entityManager.find(SkupinaKontaktov.class,1L);
        System.out.println(skupinaKontaktov);
    }

    private static void saveSkupinuAOsoby (EntityManager entityManager){
        entityManager.getTransaction().begin();

        Osoba osoba1  = entityManager.find(Osoba.class,13L);
        Osoba osoba2 = entityManager.find(Osoba.class,14L);
        Osoba osoba3 =  entityManager.find(Osoba.class,15L);

        SkupinaKontaktov skupinaKontaktov1 = new SkupinaKontaktov();
        skupinaKontaktov1.setNazovSkupiny("Skupina1");
        skupinaKontaktov1.getOsobyVSkupine().add(osoba1);
        skupinaKontaktov1.getOsobyVSkupine().add(osoba2);

        SkupinaKontaktov skupinaKontaktov2 = new SkupinaKontaktov();
        skupinaKontaktov2.setNazovSkupiny("Skupina2");
        skupinaKontaktov2.getOsobyVSkupine().add(osoba2);
        skupinaKontaktov2.getOsobyVSkupine().add(osoba3);

        entityManager.persist(skupinaKontaktov1);
        entityManager.persist(skupinaKontaktov2);

        entityManager.getTransaction().commit();



    }

    //vytvorim novu osobu a nove telefony a nasetujem to navzajom - obojsmerne druha metoda
    private static void saveOsobaSaveTelefony2(EntityManager entityManager){
        entityManager.getTransaction().begin();

        Osoba osoba = new Osoba();
        osoba.setPohlavie(Pohlavie.MUZ);
        osoba.setMeno(new Meno(null, null, "Martin",null,"LALALA"));
        osoba.setCisloOp("X458XXXXX");

        Telefon telefon1 = new Telefon();
        telefon1.setCislo("01111111111");
        telefon1.setOsoba(osoba);

        Telefon telefon2 = new Telefon();
        telefon2.setCislo("0000000000000000");
        telefon2.setOsoba(osoba);


        osoba.getTelefons().add(telefon1);
        osoba.getTelefons().add(telefon2);

        entityManager.persist(osoba);
        entityManager.getTransaction().commit();
    }


    //vytvorim novu osobu a nove telefony a nasetujem to navzajom - obojsmerne
    private static void saveOsobaSaveTelefony(EntityManager entityManager){
        entityManager.getTransaction().begin();

        Osoba osoba = new Osoba();
        osoba.setPohlavie(Pohlavie.MUZ);
        osoba.setMeno(new Meno(null, null, "Martin",null,"LALALA"));
        osoba.setCisloOp("X458XXXXX");
        ArrayList <Telefon> telefons = new ArrayList<>();

        Telefon telefon1 = new Telefon();
        telefon1.setCislo("01111111111");
        telefon1.setOsoba(osoba);

        Telefon telefon2 = new Telefon();
        telefon2.setCislo("0000000000000000");
        telefon2.setOsoba(osoba);

        telefons.add(telefon1);
        telefons.add(telefon2);
        osoba.setTelefons(telefons);

        entityManager.persist(osoba);
        entityManager.persist(telefon1);
        entityManager.persist(telefon2);
        entityManager.getTransaction().commit();
    }

    private static void nacitajOsobuPridajTelefon(EntityManager entityManager){
        entityManager.getTransaction().begin();

        Osoba osoba = entityManager.find(Osoba.class, 8L);

        Telefon telefon = new Telefon();
        telefon.setCislo("0902156000");
        telefon.setOsoba(osoba);

        osoba.getTelefons().add(telefon); //zoberiem si vsetky telefony osoby a pridaj jej tento vytvoreny

        entityManager.persist(telefon);
        entityManager.getTransaction().commit();
    }

    private static void saveViacTelefonovKOsobe (EntityManager entityManager){
        entityManager.getTransaction().begin();

        Osoba osoba = entityManager.find(Osoba.class, 8L);

        Telefon telefon1 = new Telefon();
        telefon1.setCislo("0902123456");
        telefon1.setOsoba(osoba);
        entityManager.persist(telefon1);

        Telefon telefon2 = new Telefon();
        telefon2.setCislo("0902369825");
        telefon2.setOsoba(osoba);
        entityManager.persist(telefon2);

        Telefon telefon3 = new Telefon();
        telefon3.setCislo("0202569874");
        telefon3.setOsoba(osoba);
        entityManager.persist(telefon3);

        entityManager.getTransaction().commit();
    }

    private static void getTelefon (EntityManager entityManager){
        entityManager.getTransaction().begin();

        Telefon telefon =  entityManager.find(Telefon.class, 3L);
        System.out.println(telefon);

        entityManager.getTransaction().commit();
    }

    private static void deleteOsobaSTelefonom (EntityManager entityManager){ //toto nepojde, nejde vymazat parenta
        entityManager.getTransaction().begin();

        Osoba osoba = entityManager.find(Osoba.class,8L);
        entityManager.remove(osoba);

        entityManager.getTransaction().commit();
    }

    private static void deleteTelefon(EntityManager entityManager){
        entityManager.getTransaction().begin();

        Telefon telefon = entityManager.find(Telefon.class, 1L);
        telefon.setOsoba(null);
        entityManager.persist(telefon);

        entityManager.getTransaction().commit();
    }

    private static void saveTelefon (EntityManager entityManager){
        entityManager.getTransaction().begin();

        Telefon telefon = new Telefon();
        telefon.setCislo("0905456951");
        entityManager.persist(telefon);

        entityManager.getTransaction().commit();
    }

    private static void saveTelefonKOsobe(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        Osoba osoba1 = new Osoba();
        osoba1.setPohlavie(Pohlavie.ZENA);
        osoba1.setMeno(new Meno("Ing","Phd","Janka",null,"neviemAka"));
        osoba1.setCisloOp("xxx444x44x");
        entityManager.persist(osoba1);

        Telefon telefon = new Telefon();
        telefon.setOsoba(osoba1);
        telefon.setCislo("0903943252");
        entityManager.persist(telefon);

        entityManager.getTransaction().commit();
    }

    private static void saveOsobaPrintOsoba(EntityManager entityManager) {
        Osoba osoba1 = new Osoba();
        osoba1.setPohlavie(Pohlavie.MUZ);
        osoba1.setMeno(new Meno("Mgr.","SURIKATA","Juraj","Kratky","Phd"));
        osoba1.setCisloOp("xx4568xx55");

        entityManager.getTransaction().begin();
        entityManager.persist(osoba1);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        List <Osoba>  osoby = entityManager.createQuery("from Osoba",Osoba.class).getResultList();
        for (Osoba os : osoby){
            System.out.println("Osoba id : " + os.getId() +
                    ", pohlavie : " + os.getPohlavie() +
                    ", kod osoby : " + os.getPohlavie().getKod() +
                    ", meno :" + os.getMeno() +
                    ", OP : " + os.getCisloOp());
        }

        entityManager.getTransaction().commit();
    }
}
