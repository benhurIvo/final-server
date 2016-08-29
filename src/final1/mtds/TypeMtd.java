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
//Methods used to maniputate the type class from the database
public class TypeMtd {
    
    //Retrieve type by id
       public static Type getTypeById(int tid) {
        EntityManager em = Life.instance.createEntityManager();
        Type t = em.find(Type.class, tid);
        Life.instance.closeConnections(em);
        return t;
    }

       //Return all types in the db
    public static List<Type> getAllType() {
        EntityManager em = Life.instance.createEntityManager();
        List<Type> list = em.createNamedQuery("Type.findAll", Type.class)
            .getResultList();
        Life.instance.closeConnections(em);
        return list;
    }

    //Return a type's information given its tag name
     public static List<Type> getTypeByString(String st) {
        EntityManager em = Life.instance.createEntityManager();
        List<Type> list = em.createNamedQuery("Type.findByType", Type.class)
		.setParameter("type", st)
		.getResultList();
        Life.instance.closeConnections(em);
        return list;
    }
    
     //save a new type in the db
    public static Type saveType(Type t) {
        EntityManager em = Life.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(t);
        tx.commit();
        Life.instance.closeConnections(em);
        return t;
    } 

    //update a type stored in the db
    public static Type updateType(Type t) {
        EntityManager em = Life.instance.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        t=em.merge(t);
        tx.commit();
        Life.instance.closeConnections(em);
        return t;
    }

    //delete a given type
    public static void removeType(Type t) {
        EntityManager em = Life.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        t=em.merge(t);
        em.remove(t);
        tx.commit();
        Life.instance.closeConnections(em);
    }

}
