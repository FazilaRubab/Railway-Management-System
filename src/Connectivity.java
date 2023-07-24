import java.sql.Connection;
import java.sql.*;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Connectivity {
    
 String name ="system" ,password="root";
    String url="jdbc:oracle:thin:@localhost:1521:xe";
    String Driver="orcle.jdbc.driver.OrcleDriver";
     static Connection  conn;
   
   Statement st;
     ResultSet rs;
     
     public Connectivity () 
     {  { try{
      //Class.forName("orcle.jdbc.driver.OrcleDriver");
           //"com.mysql.jdbc.Driver"
                
         conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","root");
        //      "jdbc:mysql://localhost/Project","root","" 

        
        
          }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
    } 
     }
    
   
     
    public int ins(String qry)
    {if(qry == null){
        return -1;
    }
        int x;
    try{
        
        st = conn.createStatement();
       x = st.executeUpdate(qry);
    }
    catch(SQLException ex)
      {
            JOptionPane.showMessageDialog(null,ex);
            return -1;
            
        }
        return x;
    
    }
    public int del(String qry)
    {
        int x;
    try{
        
        st = conn.createStatement();
       x = st.executeUpdate(qry);
    }
    catch(SQLException ex)
      {
            JOptionPane.showMessageDialog(null,"Record not Deleted");
            return -1;
            
        }
        return x;
    
    }
    public ResultSet getRs(String qry)
    {
    try{System.out.println(qry);
        
         PreparedStatement ps = conn.prepareStatement(qry);
         rs = ps.executeQuery();
       
       }
    catch(SQLException ex)
      {
            JOptionPane.showMessageDialog(null,ex);
           
        }
        
        
     return rs;
    }
 
   /* public static void main(String []args ) throws SQLException
    {
        Connectivity c1=new Connectivity();
        
        
        
        ResultSet r=c1.getRs("Select * from Admin");
         
      while(r.next()){
          
          System.out.println("1"+r.getString(1)+" 2"+r.getString(2)+" "+r.getString(3));
          
          
      }
   
    }*/
    
    
    }
    


