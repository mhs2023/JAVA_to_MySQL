
package practicedbconfig;
import java.sql.*;

public class PracticeDBCONFig {

   
    public static void main(String[] args) throws Exception{
       final String DB_CON = "jdbc:mysql://localhost:3306/sakila";
       final String USER_NAME = "root";
       final String PASSWORD = "root";
       final String INSERT_QUERY = "select * from actor";
       
       Connection conn = DriverManager.getConnection(DB_CON, USER_NAME, PASSWORD);
       PreparedStatement prs = conn.prepareStatement(INSERT_QUERY);
       ResultSet rs = prs.executeQuery(INSERT_QUERY);
        
        
        try {
           while (rs.next()) {
            Integer actor_id = rs.getInt("actor_id");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            String last_update = rs.getString("last_update");
            System.out.println(actor_id +", " +first_name +", " +last_name +", " +last_update);
        }
        prs.close();
        rs.close(); 
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
