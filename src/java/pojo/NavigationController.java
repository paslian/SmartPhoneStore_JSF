/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author hp
 */

@ManagedBean
public class NavigationController implements java.io.Serializable {
    
     public String addpage() {
      return "create";
   }
   
   public String mainpage(){
       return "LoginSuccses";
    }
   
      public String editpage(){
       return "edit";
    }
      
    public String logout(){
       return "index";
    }
    
    public String sortAsc(){
        return "LoginSuccses_asc";
    }
    
        public String sortDesc(){
        return "LoginSuccses_desc";
    }
}
