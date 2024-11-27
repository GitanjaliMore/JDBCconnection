package jdbc;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchRecordBasedID {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
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

String s="select * from student where sid="+sid;

rs=stmt.executeQuery(s);
System.out.println("SID\tSNAME\tSAGE\tSEMAIL\tSFEES\tSDOB");
if(rs.next()) {
	sid = rs.getInt("sid"); //rs.getInt(1);
	  sname = rs.getString("sname");
	  sage = rs.getInt("sage");
	  semail = rs.getString("semail");
	  sfees = rs.getFloat("sfees");
	  sdob = rs.getString("sdob");
System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+semail+"\t"+sfees+"\t"+sdob);
	
}
else {
	System.out.println("Student not exists");
}


}
}
