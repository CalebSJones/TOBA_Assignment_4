/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Caleb Jones
 */

public class DBUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("tobaPU");
    
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}