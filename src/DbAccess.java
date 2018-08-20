import java.sql.*;
import java.util.Scanner;


public class DbAccess {
    public static void main(String args[])
    {
        System.out.println("enter username password");
        Scanner sc=new Scanner(System.in);
        String username=sc.nextLine();
        String password=sc.nextLine();
        String password_input="";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@10.9.181.210:1521:XE","project","project");
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select PASSWORD from customers where CUSTOMER_ID="+username);
            while(rs.next())
                password_input=rs.getString(1);
            if(password.equals(password_input))
                System.out.println("login successful");
            else
                System.out.println("Invalid login");

        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }

}
