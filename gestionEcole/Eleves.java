package gestionEcole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administration
 */
public class Eleves {
    // Fill Table and Search
public void fillElevesJtable(JTable table){
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    try {
        ps = con.prepareStatement("SELECT * FROM eleves");
        ResultSet rs = ps.executeQuery();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        Object[] row;
        while(rs.next()){
            row = new Object[3];
            row[0] = rs.getInt(1);
            row[1] = rs.getString(2);
            row[2] = rs.getString(3);
            model.addRow(row);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Eleves.class.getName()).log(Level.SEVERE, null, ex);
    }
} //end FillTable



public void insertUpdateDeleteStudent(char operation, Integer id, String nom, String prenom){
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
 // i for insert
    if(operation == 'i'){
        try {
            ps = con.prepareStatement("INSERT INTO eleves(nom, prenom) VALUES(?, ?)");
            ps.setString(1, nom);
            ps.setString(2, prenom);
 //System.out.println(ps);
 
 if(ps.executeUpdate() > 0){
     JOptionPane.showMessageDialog(null, "Nouveau Étudiant Ajouté");
 
 }
        } catch (SQLException ex) {
            Logger.getLogger(Eleves.class.getName()).log(Level.SEVERE, null,ex);
        }
    } // end if insert
    
    
    
    // u for update
 if(operation == 'u'){
     try {
         ps = con.prepareStatement("UPDATE eleves SET nom = ?, prenom = ? WHERE eleve_id = ?");
         ps.setString(1, nom);
         ps.setString(2, prenom);
         ps.setInt(3, id);
         System.out.println(ps);
         
         if(ps.executeUpdate() > 0){
             JOptionPane.showMessageDialog(null, "Elève Info Modifié");
         }
     } catch (SQLException ex) {
         Logger.getLogger(Eleves.class.getName()).log(Level.SEVERE, null, ex);
     }
 } // end if updat
}


public boolean isEleveExist(String nomEleve){
    Boolean isExit = false;
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    try {
        ps = con.prepareStatement("SELECT * FROM Eleves WHERE nom = ?");
        ps.setString(1, nomEleve);
        ResultSet rs = ps.executeQuery();
    while(rs.next()){
        isExit = true;
    }
    } catch (SQLException ex) {
        Logger.getLogger(Eleves.class.getName()).log(Level.SEVERE, null, ex);
    }
    return isExit;
} //End isCourseExis

//    boolean isEleveExist(String text) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }



}
