/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sa2020;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class SA2020 {

 
    
      public static Connection conectar(){
          Connection con = null;
          final String URL = "jdbc:mysql://localhost:3306/ide?useTimezone=true&serverTimezone=UTC";
        final String USER = "root";
        final String PASS = "!@#Abc123";
          try {
                con = DriverManager.getConnection(URL, USER, PASS);
            return con;
              
          } catch (Exception e) {
          return null;
          }
          

    }
      public static void desconectar(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, e);
        }
      }

}
