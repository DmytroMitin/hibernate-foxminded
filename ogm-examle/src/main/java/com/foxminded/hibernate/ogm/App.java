package com.foxminded.hibernate.ogm;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;


public class App {

    public static void main(String... strings) {
        //accessing JBoss's Transaction can be done differently but this one works nicely
        TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();

        //build the EntityManagerFactory as you would build in in Hibernate ORM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "ogm-jpa-tutorial");

        final Logger logger = Logger.getLogger(App.class.getName());

        try {

            //Persist entities the way you are used to in plain JPA
            tm.begin();
            logger.info("About to store dog and breed");
            EntityManager em = emf.createEntityManager();
            Breed collie = new Breed();
            collie.setName("Collie");
            em.persist(collie);
            Dog dina = new Dog();
            dina.setName("Dina");
            dina.setBreed(collie);
            em.persist(dina);
            Long dinaId = dina.getId();

            Dog aDog = new Dog();
            Breed chihuahua = new Breed();
            chihuahua.setName("chihuahua");
            aDog.setBreed(chihuahua);
            aDog.setName("a dog");
            em.persist(chihuahua);
            em.persist(aDog);
            Long aDogId = aDog.getId();

            em.flush();
            em.close();
            tm.commit();


            //Retrieve your entities the way you are used to in plain JPA
            tm.begin();
            logger.info("About to retrieve dog and breed");
            em = emf.createEntityManager();
            dina = em.find(Dog.class, dinaId);
            aDog = em.find(Dog.class, aDogId);
            logger.info("Found dog " + dina.getName() + " of breed " + dina.getBreed().getName());
            logger.info("Found dog " + aDog.getName() + " of breed " + aDog.getBreed().getName());
            em.flush();
            em.close();
            tm.commit();


            emf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
