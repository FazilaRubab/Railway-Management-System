
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class CLASS_STANDARD_USER {
    
    private String User_name;
    private String User_id;
    private String  phone;
    private String  id_card;
   private String  Adress;
      private String  password;
    public CLASS_STANDARD_USER()
    { this.User_name=null;
     this.User_id=null;
     this. phone=null;
     this.id_card=null;
     this. Adress=null;
       this. password=null;
    }
    
    
    
    
    
    
    public CLASS_STANDARD_USER(String User_name,String password,String User_id,String phone, String id_card,String Adress)
    {
      this.User_name=User_name;
     this.User_id=User_id;
     this. phone=phone;
     this.id_card=id_card;
     this. Adress=Adress;
       this. password=password;
       
    }
    
     public int InsertStatement() throws SQLException
    {String qry=null;
     Connectivity obj = new Connectivity();
        Connectivity c=new Connectivity();
        String CheckDatabase="Select user_id,user_name,phone from standard_user";
        ResultSet rs=c.getRs(CheckDatabase);
        
        Boolean um=false,uid=false,p=false;
        
        while(rs.next())
       {
           if(this.User_name.equals(rs.getString(2)))
           {
               um=true;
           
           }
           
           else if(this.phone.equals(rs.getString(3)))
           {
               uid=true;
           }
           
             else if(this.User_id.equals(rs.getString(1)))
           {
               p=true;
           }}
          
        
        if(um==true){
            JOptionPane.showMessageDialog(null, "This Username is already Registerd Try Again with Different Username");
     
        }
        else if(p==true){
         JOptionPane.showMessageDialog(null, "This Phone Number is already Registerd ");   
        }
        
        else if(uid=false)    
        {JOptionPane.showMessageDialog(null, "This User is already Registerd ");
        
        }
        else
        { qry="INSERT INTO standard_user( user_id,user_name,userpassword,phone,idcard_number,adress) VALUES ('"+this.User_id+"','"+this.User_name+"','"+this.password+"','"+this.phone+"'"+",'"+this.id_card+"','"+this.Adress+"')";
     
        }

   return obj.ins(qry);}



}