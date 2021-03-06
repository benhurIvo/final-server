/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final1.mtds;

import final1.dao.Life;
import final1.domain.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author benhur
 */

//Methods used while dealing with Healthprofile
public class HealthMtd {
    
    //Retrieve health profile by h.profile id
      public static Healthprofile getHealthById(int hid) {
        EntityManager em = Life.instance.createEntityManager();
        Healthprofile h = em.find(Healthprofile.class, hid);
        Life.instance.closeConnections(em);
        return h;
    }

      //Get all healthprofiles in the db
    public static List<Healthprofile> getAllHP() {
        EntityManager em = Life.instance.createEntityManager();
        List<Healthprofile> list = em.createNamedQuery("Healthprofile.findAll", Healthprofile.class)
            .getResultList();
        Life.instance.closeConnections(em);
        return list;
    }

    //Store new h.profile in db
    public static Healthprofile saveHealthprofile(Healthprofile h) {
        EntityManager em = Life.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(h);
        tx.commit();
        Life.instance.closeConnections(em);
        return h;
    } 

    //update already stored h.profile in db
    public static Healthprofile updateHealth(Healthprofile h) {
        EntityManager em = Life.instance.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        h=em.merge(h);
        tx.commit();
        Life.instance.closeConnections(em);
        return h;
    }

    //retrive h.profile by a person's id and h.profile id
    public static List<Healthprofile> getByPidHid(int hid,int pid) {
     EntityManager em = Life.instance.createEntityManager(); 
         List<Healthprofile> list = em.createNamedQuery("Healthprofile.findByPidHid", Healthprofile.class)
		.setParameter("pid", pid)
		.setParameter("hid", hid)
		.getResultList();
        Life.instance.closeConnections(em);
	return list;
    }
    
    //Retrieve h.profile by a person's id and type id
    public static List<Healthprofile> getHealthByPidTid(int pid,int tid) {
     EntityManager em = Life.instance.createEntityManager(); 
         List<Healthprofile> list = em.createNamedQuery("Healthprofile.findByPidTid", Healthprofile.class)
		.setParameter("pid", pid)
		.setParameter("tid", tid)
		.getResultList();
        Life.instance.closeConnections(em);
	return list;
    }
    
    
    //delete a given h.profile
    public static void removeHealth(Healthprofile h) {
        EntityManager em = Life.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        h=em.merge(h);
        em.remove(h);
        tx.commit();
        Life.instance.closeConnections(em);
    }
    
}
