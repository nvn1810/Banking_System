import java.sql.*;

public class DbCon {
    Connection conn;
    Statement st;
    static ResultSet rs;
    DbCon(String query) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@10.9.181.210:1521:XE", "project", "project");
            st = conn.createStatement();
            rs = st.executeQuery(query);


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
