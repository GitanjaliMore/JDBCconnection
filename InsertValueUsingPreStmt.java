import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertValueUsingPreStmt {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String driver = "com.mysql.cj.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/info";
		String username = "root";
		String password = "GITU@30";
		
		int sid,sage;
	    float sfees;
		String semail,sname,sdob;

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Student id:");
		sid = sc.nextInt();
		//Load The driver
		Class.forName(driver);
		
		//Make a Connection
		conn = DriverManager.getConnection(url, username, password);
		
		//create a statement
		String sel = "select * from student where sid=?";
		pst = conn.prepareStatement(sel);
		pst.setInt(1, sid);
		rs = pst.executeQuery();
		if(!rs.next()) {
		
			 
			//sid | Sname     | sage | semail              | sfees | sdob       
			String ins = "insert into student(sid,sname,sage,semail,sfees,sdob) values(?,?,?,?,?,?)";
			pst = conn.prepareStatement(ins);
			System.out.println("Enter name");
			sname=sc.nextLine();
			
			sname=sc.nextLine();
			  System.out.println("Enter age");
			  sage = sc.nextInt();
			  System.out.println("Enter email");
			  semail = sc.next();
			  System.out.println("Enter fees");
			  sfees = sc.nextFloat();
			  System.out.println("Enter dob");
			  sdob = sc.next();
			pst.setInt(1, sid);
			pst.setString(2,sname);
			pst.setInt(3, sage);
			pst.setString(4, semail);
			pst.setFloat(5, sfees);
			pst.setString(6, sdob);
			
			int ret = pst.executeUpdate();
			if(ret>0) {
				System.out.println("Successfully Registered");
			}else {
				System.out.println("Error in sql query");
			}
		
		
		}else {
			System.out.println("That student id already exist");
		}
		conn.close();


	}


}