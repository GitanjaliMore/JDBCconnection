package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchAllRecords {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Step 1: Load the driver
        String driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(driver);

        // Step 2: Make the connection
        String url = "jdbc:mysql://localhost:3306/info";
        String username = "root";
        String password = "GITU@30";
        Connection conn = DriverManager.getConnection(url, username, password);

        // Step 3: Create a PreparedStatement
        String query = "select * from student";
        PreparedStatement pst = conn.prepareStatement(query);

        // Step 4: Execute the query
        ResultSet rs = pst.executeQuery();

        // Display the results
        int sid, sage;
        float sfees;
        String semail, sname, sdob;

        System.out.println("SID\tSNAME\tSAGE\tSEMAIL\tSFEES\tSDOB");
        while (rs.next()) {
            sid = rs.getInt("sid"); // rs.getInt(1);
            sname = rs.getString("sname");
            sage = rs.getInt("sage");
            semail = rs.getString("semail");
            sfees = rs.getFloat("sfees");
            sdob = rs.getString("sdob");
            System.out.println(sid + "\t" + sname + "\t" + sage + "\t" + semail + "\t" + sfees + "\t" + sdob);
        }

        
       
        conn.close();
    }
}
