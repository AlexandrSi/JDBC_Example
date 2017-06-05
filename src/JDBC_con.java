import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC_con {
    public static void main(String[] args) throws SQLException {
        Connection con;
        con = null;
        Statement stmt = null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Not to load driver");
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_vk?useSSL=false", "root", "root");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users");
            int i = 0;
            List<DBtoList> Drt = new ArrayList<DBtoList>();
            while (rs.next()){
                DBtoList lis = new DBtoList();
                lis.setID(rs.getInt("id"));
                lis.setName(rs.getString("name"));
                lis.setSubName(rs.getString("subname"));
                lis.setAge(rs.getInt("age"));
                Drt.add(lis);
            }
            System.out.println(Drt);
        } catch (SQLException e){
            System.err.println("No connect");
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        }
    }
}
