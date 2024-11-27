package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchRecord {
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
   String s= "select * from Student";
  // sid | Sname     | sage | semail              | sfees | sdob     

	////Step 4: Execute query( insert, select , update, delete)
		  ResultSet rs = null;
		  rs=stmt.executeQuery(s);
		  int sid,sage;
		  float sfees;
		  String semail,sname,sdob;
		  
		  System.out.println("SID\tSNAME\tSAGE\tSEMAIL\tSFEES\tSDOB");
		  while(rs.next()) {
			  sid = rs.getInt("sid"); //rs.getInt(1);
			  sname = rs.getString("sname");
			  sage = rs.getInt("sage");
			  semail = rs.getString("semail");
			  sfees = rs.getFloat("sfees");
			  sdob = rs.getString("sdob");
		System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+semail+"\t"+sfees+"\t"+sdob);
			  
		  }
		  conn.close();
		  
		  

	}
}
