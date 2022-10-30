/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Product;
import pojo.SmartphoneStoreUtil;

/**
 *
 * @author RAMA
 */

@ManagedBean
public class DAOProduct {
    
     public void addProduct(Product product)
    {
        Transaction trans=null;
        Session session=SmartphoneStoreUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.save(product);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
     
     public void deleteProduct (int idProduct)
    {
        Transaction trans=null;
        Session session=SmartphoneStoreUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Product prod=(Product)session.load(Product.class, new Integer(idProduct));
            session.delete(prod);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
        public List<Product> getbyID(int id_Product)
    {
        Product product=new Product();
        List<Product> product1=new ArrayList();
       
         Transaction trans=null;
        Session session=SmartphoneStoreUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Product where id_product= :id");
            query.setInteger("id", id_Product);
            product=(Product)query.uniqueResult();
            product1=query.list();
         
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        return product1;
    }
    
        public List<Product> retrieveProduct()
    {
       
        List prod=new ArrayList();
        Product prod1=new Product();
        Transaction trans=null;
        Session session=SmartphoneStoreUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Product");
            prod=query.list();
            prod.add(prod1.getMerk());
            prod.add(prod1.getSeries());
            prod.add(prod1.getPrice());
            prod.add(prod1.getStock());
            
            trans.commit();
            
        }
        catch(Exception e)
        {
            
        }
        return prod;
    }
        
    public List<Product> retrieveProduct_bystock_asc()
    {
       
        List prod=new ArrayList();
        Product prod1=new Product();
        Transaction trans=null;
        Session session=SmartphoneStoreUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Product order by stock asc");
            prod=query.list();
            prod.add(prod1.getMerk());
            prod.add(prod1.getSeries());
            prod.add(prod1.getPrice());
            prod.add(prod1.getStock());
            
            trans.commit();
            
        }
        catch(Exception e)
        {
            
        }
        return prod;
    }
    
        public List<Product> retrieveProduct_bystock_desc()
    {
       
        List prod=new ArrayList();
        Product prod1=new Product();
        Transaction trans=null;
        Session session=SmartphoneStoreUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Product order by stock desc");
            prod=query.list();
            prod.add(prod1.getMerk());
            prod.add(prod1.getSeries());
            prod.add(prod1.getPrice());
            prod.add(prod1.getStock());
            
            trans.commit();
            
        }
        catch(Exception e)
        {
            
        }
        return prod;
    }
    
    public void updateProduct(Product product)
    {
        Transaction trans=null;
        Session session=SmartphoneStoreUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.update(product);
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        
    }
    
}
    

