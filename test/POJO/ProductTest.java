/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import DAO.DAOProduct;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RANGGA RADITYA
 */
public class ProductTest {
  
  public ProductTest() {
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
    mengetes method getAllRecord apakah berhasil menampilkan semua produk pada
    table. Untuk mengujinya, saya menggunakan variabel test yaitu expResult yang 
    berupa jumlah seluruh produk yang ada. Setelah itu, saya mengubah variabel
    result menjadi array. Selajutnya, bandingkan panjang array tersebut dengan 
    expresult. Jika hasilnya sama, maka test berhasil.
  */
  @Test
  public void testGetAllRecords() {
    System.out.println("Test Get All Record");
    Product instance = new Product();
    int expResult = 11;
    List<Product> result = instance.getallrecords();
    assertEquals(expResult, result.toArray().length);
  }

     /*
    mengetes apakah method getById berhasil menampilkan data berdasarkan ID atau
    tidak. Langkah pertama, yaitu set id produk. Selanjutnya, membuat variabel
    test expResult dan bandingkan dengan hasil dari method getById. Jika 
    hasilnya sama, maka test berhasil.
  */
  @Test
  public void testGetById() {
    System.out.println("Test Get by ID");
      
    Product instance = new Product();
    instance.setIdProduct(1);
    
    String expResult = "LoginSuccses_search";
    String result = instance.getById();

    assertEquals(expResult, result);
  }

 /*
    mengetes method saveProduct yang berfungsi untuk menambahkan data produk
    di database dan method ini dipakai saat user mengklik tombol create. 
    Langkah pertama, set semua data produk yang ingin ditambahkan. Selanjutnya,
    membuat variabel test expResult dan bandingkan dengan hasil dari method
    saveProduct. Jika hasilnya sama, maka test berhasil.
  */
  @Test
  public void testSaveProduct() {
    System.out.println("Test Save Product");
    
    Product instance = new Product();
    instance.setMerk("Testing Save");
    instance.setSeries("REAGENT");
    instance.setPrice (Long.valueOf(2000000));
    instance.setStock(20);
    
    String expResult = "LoginSuccses";
    String result = instance.saveProduct();

    assertEquals(expResult, result);
  }   
    
  /*
    mengetes method editProduct yang berfungsi untuk mengubah data produk
    di database dan method ini dipakai saat user mengklik tombol update. 
    Langkah pertama, set semua data produk yang ingin diubah. Selanjutnya,
    membuat variabel test expResult dan bandingkan dengan hasil dari method
    editProduct. Jika hasilnya sama, maka test berhasil.
  */
  @Test
  public void testEditProduct() {
    System.out.println("editProduct");
    
    Product instance = new Product();
    instance.setIdProduct(2);
    instance.setMerk("Testing Edit");
    instance.setSeries("REAGENT");
    instance.setPrice (Long.valueOf(2000000));
    instance.setStock(20);
    
    String expResult = "LoginSuccses";
    String result = instance.update();

    assertEquals(expResult, result);
  }
  
  /*
    mengetes method deleteProduct yang berfungsi untuk menghapus data produk
    di database berdasarkan id product dan method ini dipakai saat user 
    mengklik tombol delete. Langkah pertama, yaitu set id product yang ingin 
    dihapus. Selanjutnya, membuat variabel test expResult dan bandingkan 
    dengan hasil dari method deleteProduct. Jika hasilnya sama, maka test berhasil.
  */
  @Test
  public void testDeleteProduct() {
    System.out.println("deleteProduct");
    
    Product instance = new Product();
    instance.setIdProduct(20);
    
    String expResult = "LoginSuccses";
    String result = instance.deleteProduct();
    
    assertEquals(expResult, result);
  }
}