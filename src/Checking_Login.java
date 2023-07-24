
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Checking_Login {
    
    private String Admin_Name;
    private String Password;
    
    Checking_Login(String name,String pass)
    {
        Admin_Name=name;
        Password=pass;
    }
    public int check() throws SQLException
    {
        String sql="Select * from ADMIN where admin_username ='"+Admin_Name+"' and "+"Admin_password='"+Password+"'";
       
        Connectivity c=new  Connectivity();
       ResultSet r= c.getRs(sql);
       //data get from database;
       boolean  count=false;
       while(r.next()){
           
       
       
        if(Admin_Name.equals(r.getString(1)) && Password.equals(r.getString(3)))
        {
            JOptionPane.showMessageDialog(null,"Login Successful");
            count=true;
            return 1;
            
        }}
        if(true!=count)
            JOptionPane.showMessageDialog(null,"Login Failed");
        
        return 0;
    }
    
    
}
