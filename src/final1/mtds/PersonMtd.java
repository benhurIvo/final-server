/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final1.mtds;

import final1.dao.Life;
import final1.domain.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author benhur
 */

//Methods used to manipulate data of the person table in db
public class PersonMtd {
    //Retrieve a person using the id
    public static Person returnPersonById(int personId) {
        EntityManager em = Life.instance.createEntityManager();
        Person p = em.find(Person.class, personId);
	Life.instance.closeConnections(em);
        return p;
    }

    
    //return a list of all people in db
    public static List<Person> getAllPeople() {	
	List<Person> pz = new ArrayList<Person>();
        EntityManager em = Life.instance.createEntityManager();
        List<Person> Plist = em.createNamedQuery("Person.findAll", Person.class)
          .getResultList();	
        Life.instance.closeConnections(em);
        return Plist;
    }

    //Get a person by id
     public static Person getPersonById(int personId) {
       EntityManager em = Life.instance.createEntityManager();
       List<Person> plist = em.createNamedQuery("Person.findByPid", Person.class)
	    .setParameter("pid", personId)
		.getResultList();
        Life.instance.closeConnections(em);
        return plist.get(0);
    }
    
     
     //Save a new person
    public static Person savePerson(Person p) {
        EntityManager em = Life.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(p);
        tx.commit();
        Life.instance.closeConnections(em);
        return p;
    } 

    //update the person's info
    public static Person updatePerson(Person p) {
        EntityManager em = Life.instance.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        p=em.merge(p);
        tx.commit();
        Life.instance.closeConnections(em);
        return p;
    }

    //delete a person from the db
    public static void removePerson(int pid) {
	System.out.println("person removing "+pid);
	Person p = new Person();
	p.setPid(pid);
        EntityManager em = Life.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        p=em.merge(p);
        em.remove(p);
        tx.commit();
        Life.instance.closeConnections(em);
    }
    
    //Get a person's health profile
      public static List<Healthprofile> getHProfByPrsnMeasure(int personId,String ms) {
	EntityManager em = Life.instance.createEntityManager();
       List<Healthprofile> list = new ArrayList<Healthprofile>();//getHealthprof(personId);
	List<Type> tt = TypeMtd.getTypeByString(ms);
	if(!tt.equals(null))
	    list = HealthMtd.getHealthByPidTid(personId, tt.get(0).getTid());
	
        Life.instance.closeConnections(em);
        return list;
    }     
     
      //Get a person's healthpofile using his id
        public static List<Healthprofile> getHealthprofByPid(int personId) {
        EntityManager em = Life.instance.createEntityManager(); 
         List<Healthprofile> list = em.createNamedQuery("Healthprofile.findByPid", Healthprofile.class)
		.setParameter("pid", personId)
		.getResultList();
        Life.instance.closeConnections(em);
        return list;
    }
      
	//Get a person's healthpofile using his person id and the type id
      public static Healthprofile getHealthProfByPidTid(int pid,int mid) {
	 EntityManager em = Life.instance.createEntityManager();
       List<Healthprofile> list = HealthMtd.getHealthByPidTid(pid, mid);	
        Life.instance.closeConnections(em);
        return list.get(0);
    }    
      
}
