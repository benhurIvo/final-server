/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final1.mtds;

import final1.dao.Life;
import final1.domain.Goal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author benhur
 */
//Methods used to retrieve information about goals
public class GoalMtd {
    
    //get goal using goal id
     public static Goal getGoalById(int gid) {
        EntityManager em = Life.instance.createEntityManager();
        Goal h = em.find(Goal.class, gid);
        Life.instance.closeConnections(em);
        return h;
    }

     //get all goals in the db
    public static List<Goal> getAllGoal() {
        EntityManager em = Life.instance.createEntityManager();
        List<Goal> list = em.createNamedQuery("Goal.findAll", Goal.class)
            .getResultList();
        Life.instance.closeConnections(em);
        return list;
    }

    //save goal
    public static Goal saveGoal(Goal g) {
        EntityManager em = Life.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(g);
        tx.commit();
        Life.instance.closeConnections(em);
        return g;
    } 

    //update a given goal in the database
    public static Goal updateGoal(Goal g) {
        EntityManager em = Life.instance.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        g=em.merge(g);
        tx.commit();
        Life.instance.closeConnections(em);
        return g;
    }

    //retrieve a goal by person and type ids
    public static List<Goal> getGolByPidTid(int tid,int pid) {
     EntityManager em = Life.instance.createEntityManager(); 
         List<Goal> list = em.createNamedQuery("Goal.findByPidTid", Goal.class)
		.setParameter("pid", pid)
		.setParameter("tid", tid)
		.getResultList();
        Life.instance.closeConnections(em);
	return list;
    }
    
    //delete goal
    public static void removeGoal(Goal g) {
        EntityManager em = Life.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        g=em.merge(g);
        em.remove(g);
        tx.commit();
        Life.instance.closeConnections(em);
    }
    
    //get goals made by a person
     public static List<Goal> getGoalByPid(int personId) {
        EntityManager em = Life.instance.createEntityManager(); 
         List<Goal> list = em.createNamedQuery("Goal.findByPid", Goal.class)
		.setParameter("pid", personId)
		.getResultList();
        Life.instance.closeConnections(em);
        return list;
    }
    
}
