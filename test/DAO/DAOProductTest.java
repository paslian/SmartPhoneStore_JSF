/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Product;
import pojo.SmartphoneStoreUtil;

/**
 *
 * @author hp
 */
public class DAOProductTest {
    
    public DAOProductTest() {
    }
    
    @Before
    public void setUpClass() {
            System.out.println("***** Start Testing *****");
    }
    
    @After
    public void tearDownClass() {
        System.out.println("***** End Testing *****");
    }
    
      
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
      System.out.println("\n");
    }

    /*
    TESTING ADD PRODUK
     */
    @Test
    public void testAddProduct() {
        System.out.println("----TEST ADD PRODUCT----");
        Product product = new Product();
        product.setMerk("IPHONE HDC");
        product.setSeries("IPHONE 14 PRO HDC");
        product.setPrice(Long.valueOf(15000000));
        product.setStock(13);

        DAOProduct instance = new DAOProduct();
        instance.addProduct(product);

        assertNotNull(product);
    }

    /*
     TESTING DELETE RPODUK
     */
    @Test
    public void testDeleteProduct() {
        System.out.println("----TEST DELETE PRODUCT----");
        
    Integer idProduct = 4;
    DAOProduct instance = new DAOProduct(); 
    Transaction transaction = null;
    Session session = SmartphoneStoreUtil.getSessionFactory().openSession();
    
    transaction = session.beginTransaction();
    instance.deleteProduct(idProduct);
    transaction.commit();
    
    Product deletedProduct = (Product) session.get(Product.class, idProduct);
    assertNull(deletedProduct);
    }

    /**
     * TESTING GET BY ID PRODUK
     */
    @Test
    public void testGetbyID() {
        System.out.println("----TEST GET BY ID PRODUCT----");
        
      Integer idProduct = 2;
      DAOProduct instance = new DAOProduct();
      List<Product> result = instance.getbyID(idProduct);
      assertFalse(result.isEmpty());
    }

    /*
     TESTING RETRIEVE PRODUCT
     */
    @Test
    public void testRetrieveProduct() {
        System.out.println("----TEST READ LIST PRODUCT----");
        
    DAOProduct instance = new DAOProduct();
    List<Product> result = instance.retrieveProduct();
    System.out.println("Total Product: " + result.toArray().length);
    assertFalse(result.isEmpty());
    }

    /*
      TESTING RETRIEVE PRODUCT BY ASCENDING
     */
    @Test
    public void testRetrieveProduct_bystock_asc() {
        System.out.println("----TEST READ LIST BY ASCENDING PRODUCT----");
        
    DAOProduct instance = new DAOProduct();
    List<Product> result = instance.retrieveProduct_bystock_asc();
    System.out.println("Total Product: " + result.toArray().length);
    assertFalse(result.isEmpty());
    }

    /*
     TESTING RETRIEVE PRODUCT BY DESCENDING
     */
    
    @Test
    public void testRetrieveProduct_bystock_desc() {
        System.out.println("----TEST READ LIST BY DESCENDING PRODUCT----");
        
    DAOProduct instance = new DAOProduct();
    List<Product> result = instance.retrieveProduct_bystock_desc();
    System.out.println("Total Product: " + result.toArray().length);
    assertFalse(result.isEmpty());
    }

    /**
     * Test of updateProduct method, of class DAOProduct.
     */
    @Test
    public void testUpdateProduct() {
        System.out.println("----TEST EDIT PRODUCT----");

            
    DAOProduct instance = new DAOProduct();
    Transaction transaction = null;
    Session session = SmartphoneStoreUtil.getSessionFactory().openSession();
    
    Integer id = 6;
    Product product = new Product();
    product.setIdProduct(id);
    product.setMerk("OPPO");
    product.setSeries("OPPO 12 PRO MAX");
    product.setPrice(Long.valueOf(10000000));
    product.setStock(20);
    
    transaction = session.beginTransaction();
    instance.updateProduct(product);
    transaction.commit();
    
    Product updatedProduct = (Product) session.get(Product.class, id);
    
    String expResult = "OPPO 12 PRO MAX";
    String result = updatedProduct.getSeries();
    
    assertEquals(expResult, result);
    }
    
}
