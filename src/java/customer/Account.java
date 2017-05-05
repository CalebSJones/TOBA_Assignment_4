/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import customer.Transaction;
import customer.User;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Caleb Jones
 */
@Entity
public class Account implements Serializable {

    public enum Type {
        Checking, Savings;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountId;
    private User user;
    
    private double balance;

    @Enumerated(EnumType.STRING)
    public Type type;    
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Transaction> transactions;
    
    public Account() {
        
    }

    public Account(Type type, double balance, User user) {
        this.user = user;
        this.type = type;
        this.balance = balance;
    }

    public String getAccountId() {
        return Long.toString(accountId);
    }

    public String getAccountType() {
        return type.toString();
    }

    public void setAccountType(Type type) {
        this.type = type;
    }

    public void credit(double credit) {
        this.balance += credit;
    }

    public void debit(double debit) {
        this.balance -= debit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
