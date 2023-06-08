/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Recep Emir
 */
public class DBConnection {
    private Connection connection=null;
    
    
    public DBConnection() throws SQLException{
        dbConnect();
    }
    
    public void dbConnect() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/loginscreendb";
        String username = "root";
        String password = "admin";
        connection = DriverManager.getConnection(url,username,password);
    }
    
    public void dbCloseConnect() throws SQLException{
        connection.close();
    }
    
    public void checkUsernameAndPassword(String sys_username,String sys_password) throws SQLException{
        String query = "SELECT count(username) as Giris FROM loginscreendb.users where username='"+sys_username+"' and password='"+sys_password+"'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            if (rs.getInt("Giris") == 1) {
                JOptionPane.showMessageDialog(null, "Hoşgeldiniz!");
            }else JOptionPane.showMessageDialog(null, "Kullanıcı adı veya şifre hatalı!");
        }
        connection.close();
    }
}
