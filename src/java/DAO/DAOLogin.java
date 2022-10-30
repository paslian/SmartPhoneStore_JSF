/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Employee;
import pojo.SmartphoneStoreUtil;

/**
 *
 * @author Wikon3
 */
public class DAOLogin {
    public List<Employee> getBy(String uName, String uPass) {
        Employee u = new Employee();
        List<Employee> user = new ArrayList();

        Transaction trans = null;
        Session session = SmartphoneStoreUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Employee where username= :uName AND password= :uPass");
            query.setString("uName", uName);
            query.setString("uPass", uPass);
            u = (Employee) query.uniqueResult();
            user = query.list();

            trans.commit();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return user;
    }


}
