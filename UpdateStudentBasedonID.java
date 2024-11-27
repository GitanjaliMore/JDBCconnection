package jdbc;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStudentBasedonID {
	public static void main(String[]ags) throws ClassNotFoundException, SQLException {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/info";
		String un="root";
		String pass="GITU@30";

		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		int sid,sage;
		String newemail;
	 

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter student id");
		sid =sc.nextInt();

		//load the driver
		Class.forName(driver);

		//make the connection 
		conn = DriverManager.getConnection(url, un, pass);

		//create statment

		stmt = conn.createStatement();
		String s ="select * from student where sid="+sid;
		rs=stmt.executeQuery(s);
		if(rs.next()) {
			System.out.println("Enter new email id");
			newemail= sc.next();
			
			String upd="update student set semail='"+newemail+"' where sid="+sid;
		int ret = stmt.executeUpdate(upd);
		if(ret>0) {
			System.out.println("Email id updated");
			
		}else {
			System.out.println("error in database");
		}
		
		}else
			{
				System.out.println("Student not exists");
			}
			
		}

	}


