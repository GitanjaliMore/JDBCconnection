package jdbc;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecordEmployee {
	public static void main(String[]ags) throws ClassNotFoundException, SQLException {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/info";
		String un="root";
		String pass="GITU@30";

		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		int empid,deptid;
	    

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter employee id");
		empid =sc.nextInt();

		//load the driver
		Class.forName(driver);

		//make the connection 
		conn = DriverManager.getConnection(url, un, pass);

		//create statment

		stmt = conn.createStatement();
		String s ="select * from employee where empid="+empid;
		rs=stmt.executeQuery(s);
		if(rs.next()) {
			String del=" delete from employee where empid="+empid;
			
			int ret=stmt.executeUpdate(del);
			if(ret>0){
				System.out.println("Record is deleted");
			}
			else{
				System.out.println("database error");
			}
		}else
			{
				System.out.println("Student not exists");
			}
			
		}

	}


