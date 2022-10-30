/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Employee;

/**
 *
 * @author hp
 */
public class DAOLoginTest {
    
    public DAOLoginTest() {
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
  mengetes apakah method login berhasil mencari user yang terdapat di dalam
  database atau tidak, caranya dengan mengubah variable result menjadi array.
  Jika array length == 0, maka user tidak ada dan test gagal.
*/  
  @Test
  public void testGetBy() {
    System.out.println("---Test Login----");
    String uName = "sahat";
    String uPass = "admin";   
    int empty = 0;
    DAOLogin instance = new DAOLogin();
    List<Employee> result = instance.getBy(uName, uPass);
    System.out.println(result.toArray().length);
    assertThat(result.toArray().length, is(not(equalTo(empty))));
  }
    
}
