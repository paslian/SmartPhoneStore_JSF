/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import DAO.DAOLogin;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RAMA
 */
public class EmployeeTest {
    
    public EmployeeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    System.out.println("** Start Testing **");
    }
    
    @AfterClass
    public static void tearDownClass() {
    System.out.println("** End Testing **");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
   public void tearDown() {
    System.out.println("\n");
  }
   
/*
    mengetes method login user yang mana method ini dipakai saat user mengklik
    tombol login. Langkah pertama yaitu dengan set semua data yang dibutuhkan.
    Setelah itu, membuat ekspetasi result. Jika hasilnya sama dengan result maka
    test berhasil.
  */  
   
    @Test
    public void testValidasiUser() {
        System.out.println("Test Login User");
    Employee instance = new Employee();
    instance.setUsername("asep@gmail.com");
    instance.setPassword("345"); 
    
    String expResult = "LoginFailed";
    String result = instance.validasiUser();
    System.out.println(expResult);
    System.out.println(result);
    assertEquals(expResult, result);
    }

    
}