package gestionEcole;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administration
 */
import java.sql.Connection;
import java.sql.DriverManager;
public class MyConnection {
 public static Connection getConnection(){
 Connection con = null;
 try {
 Class.forName("org.postgresql.Driver");
 con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ecoleGestionDB", "postgres", "samy");
 } catch (Exception ex) {
 System.out.println(ex.getMessage());
 }
 return con;
 }
}

