/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

import customer.Account;
import customer.User;

/**
 *
 * @author Caleb Jones
 */
public class AccountDB {

    public static void insert(Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(account);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static void update(Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(account);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static Account getAccount(long accountId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a from Account a WHERE a.accountId = :accountId";
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        q.setParameter("accountId", accountId);
        try {
            Account account = q.getSingleResult();
            return account;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static List<Account> getAccounts(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a from Account a WHERE a.user = :user";
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        q.setParameter("user", user);
        List<Account> accounts;
        try {
            accounts = q.getResultList();
            if (accounts == null || accounts.isEmpty())
                accounts = null;
        } finally {
            em.close();
        }
        return accounts;
    }
}
