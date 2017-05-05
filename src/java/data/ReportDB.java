/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import customer.User;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Caleb Jones
 */
public class ReportDB {
    
    public static Workbook getUserEmail() {
        
        // get the data from the database
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u WHERE u.registrationDate > = :startDate" +
                "ORDER BY u.lastName";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        List<User> users = null;
        
        // Get first date of currentMonth.
        Date date = new Date();
        String startDate = new SimpleDateFormat("yyyy-MM").format(date);
        startDate += "-01";
        try {
            q.setParameter("startDate", startDate);
            users = q.getResultList();
        } catch (NoResultException e) {
            System.err.println(e);
            return null;
        } finally {
            em.close();
        }
        
        // create the workbook, its worksheet, and its title row
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("User Report");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("The User Report");
        
        // create the header row
        row = sheet.createRow(2);
        row.createCell(0).setCellValue("LastName");
        row.createCell(1).setCellValue("FirstName");
        row.createCell(2).setCellValue("Email");
        row.createCell(3).setCellValue("CompanyName");
        row.createCell(4).setCellValue("Address1");
        row.createCell(5).setCellValue("Address2");
        row.createCell(6).setCellValue("City");
        row.createCell(7).setCellValue("State");
        row.createCell(8).setCellValue("Zip");
        row.createCell(9).setCellValue("Country");
        row.createCell(10).setCellValue("UserID");

        // create the data rows
        int i = 3;
        for (User u : users) {
            row = sheet.createRow(i);
            row.createCell(0).setCellValue(u.getLastName());
            row.createCell(1).setCellValue(u.getFirstName());
            row.createCell(2).setCellValue(u.getEmail());
            row.createCell(4).setCellValue(u.getAddress());
            row.createCell(6).setCellValue(u.getCity());
            row.createCell(7).setCellValue(u.getState());
            row.createCell(8).setCellValue(u.getZip());
            row.createCell(10).setCellValue(u.getUserId());
            i++;
        }
            
        return workbook;
    }
    
}
