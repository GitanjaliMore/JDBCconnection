package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchRecordEmployee {

		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			        //Step 1: Load the driver
					//step 2: Make the connection
					//step 3: create a Statement
					//Step 4: Execute query( insert, select , update, delete)
					//step 5: close the connection
					
			//Step 1: Load the driver

	   String driver ="com.mysql.cj.jdbc.Driver";
	   Class.forName(driver);
	   
	 //step 2: Make the connection
	   String url="jdbc:mysql://localhost:3306/info";
	   String un="root";
	   String pass="GITU@30";
	   Connection conn=null;
	   conn = DriverManager.getConnection(url,un,pass);
	   
	 //step 3: create a Statement
	   
	   Statement stmt = null;
	   stmt = conn.createStatement();
	   String s= "select * from employee";
	  //  empid | empname   | empdob     | empmail             | empphone   | empsalary | deptid | 

		////Step 4: Execute query( insert, select , update, delete)
			  ResultSet rs = null;
			  rs=stmt.executeQuery(s);
			  int empid,deptid;
			  float empsalary;
			  String empname,empdob,empmail,empphone;
			  
			  System.out.println("SID\tEMPNAME\tEMPDOB\tEMPMAIL\tEMPPHONE\tEMPSALARY\tDEPTID");
			  while(rs.next()) {
				  empid = rs.getInt("empid"); //rs.getInt(1);
				  empname = rs.getString("empname");
				  empdob = rs.getString("empdob");
				  empmail = rs.getString("empmail");
				  empphone = rs.getString("empphone");
				  empsalary = rs.getFloat("empsalary");
				  deptid = rs.getInt("deptid");
			System.out.println(empid+"\t"+empname +"\t"+empdob+"\t"+empmail+"\t"+empphone+"\t"+empsalary+"\t"+deptid);
				  
			  }
			  conn.close();
			  
			  

		}
	}

