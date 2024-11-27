package jdbc;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecord {
	public static void main(String[]ags) throws ClassNotFoundException, SQLException {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/info";
		String un="root";
		String pass="GITU@30";

		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		int sid,sage;
	    float sfees;
		String semail,sname,sdob;


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
			System.out.println("student id already exists cannot add record");
			
		
		}
			else{//not there go for insert
				System.out.println("Enter name");
				sname=sc.nextLine();
				
				sname=sc.nextLine();
				  System.out.println("Enter age");
				  sage = sc.nextInt();
				  System.out.println("Enter email");
				  semail = sc.next();
				  System.out.println("Enter fees");
				  sfees = sc.nextFloat();
				  System.out.println("Enter dob (yyyy-mm-dd)");
				  sdob = sc.next();
				  //| sid | sname  | sage | semail| sfees | sdob       |
		String ins ="insert into student values("+sid+",'"+sname+"',"+sage+",'"+semail+"',"+sfees+",'"+sdob+"')";
		          int ret = stmt.executeUpdate(ins);
		          if(ret>0) {
		        	  System.out.println("Registerd successfully");
		          }else {
		        	  System.out.println("database error");
		          }
			  }
			    conn.close();
			} 
				  
			}

