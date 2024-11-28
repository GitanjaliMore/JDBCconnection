package jdbc;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteRecordUsingPreStmt {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		        String driver = "com.mysql.cj.jdbc.Driver";
		        String url = "jdbc:mysql://localhost:3306/info";
		        String username = "root";
		        String password = "GITU@30";

		        Connection conn = null;
		        PreparedStatement pst = null;
		        ResultSet rs = null;
		        int sid,sage;
			    //float sfees;
				//String semail,sname,sdob;

		        Scanner sc = new Scanner(System.in);

		        System.out.println("Enter Student ID ");
		        sid = sc.nextInt();

		        // Load the driver
		        Class.forName(driver);

		        // Make a connection
		        conn = DriverManager.getConnection(url, username, password);

		        // Check if the student ID exists
		        String sel = "Select * from student where sid=?";
		        pst = conn.prepareStatement(sel);
		        pst.setInt(1, sid);
		        rs = pst.executeQuery();

		        if (rs.next()) {
		            // Student ID exists, proceed to delete
		            String del = "delete from student where sid=?";
		            pst = conn.prepareStatement(del);
		            pst.setInt(1, sid);

		            int ret = pst.executeUpdate();
		            if (ret > 0) {
		                System.out.println("Student record successfully deleted.");
		            } else {
		                System.out.println("database error ");
		            }
		        } else {
		            System.out.println("Student not exists");
		        }

	
		        conn.close();
		    }
		
	}
	
