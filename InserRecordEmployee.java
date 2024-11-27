package jdbc;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InserRecordEmployee {
	public static void main(String[]ags) throws ClassNotFoundException, SQLException {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/info";
		String un="root";
		String pass="GITU@30";

		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		 int empid,deptid;
		  float empsalary;
		  String empname,empdob,empmail,empphone;
	

		  //  empid | empname   | empdob     | empmail             | empphone   | empsalary | deptid | 
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Employee empid");
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
			System.out.println("employee id already exists cannot add record");
			
		
		}
			else{//not there go for insert
				System.out.println("Enter name");
				 empname =sc.nextLine();
				 
				 empname =sc.nextLine();
				 System.out.println("Enter dob");
				 empdob=sc.nextLine();
				  System.out.println("Enter email");
				  empmail = sc.nextLine();
				  System.out.println("Enter phone ");
				  empphone = sc.next();
				  System.out.println("Enter salary ");
				  empsalary = sc.nextFloat();
				  System.out.println("Enter deptid");
				  deptid = sc.nextInt();
				  //  empid | empname   | empdob     | empmail             | empphone   | empsalary | deptid | 
		String ins ="insert into employee values("+empid+",'"+empname +"','"+empdob+"','"+empmail+"','"+empphone+"','"+empsalary+"','"+deptid+"')";
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



