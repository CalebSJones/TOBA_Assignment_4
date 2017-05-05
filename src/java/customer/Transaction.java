/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import customer.Account;
import data.DBUtil;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Caleb Jones
 */
@Entity
public class Transaction implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;
    
    @ManyToOne
    private Account account;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date transactionDate;
    
    private double amount;
    
    public Transaction() {
    }
    
    public Transaction(double amount) {
        this.amount = amount;
    }
}
