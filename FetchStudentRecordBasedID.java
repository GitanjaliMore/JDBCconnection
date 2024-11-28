package jdbc;


import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchStudentRecordBasedID {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/info";
        String un = "root";
        String pass = "GITU@30";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int sid, sage;
        float sfees;
        String semail, sname, sdob;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student id:");
        sid = sc.nextInt();

        // Load the driver
        Class.forName(driver);

        // Make the connection
        conn = DriverManager.getConnection(url, un, pass);

        // Create PreparedStatement
        String query = "select * from student where sid = ?";
        pst = conn.prepareStatement(query);

        // Set the parameter
        pst.setInt(1, sid);

        // Execute the query
        rs = pst.executeQuery();

        //System.out.println("SID\tSNAME\tSAGE\tSEMAIL\tSFEES\tSDOB");
System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s","SID","SNAME","SAGE","SEMAIL","SFEES","SDOB");
System.out.println();
        if (rs.next()) {
            sid = rs.getInt("sid"); 
            sname = rs.getString("sname");
            sage = rs.getInt("sage");
            semail = rs.getString("semail");
            sfees = rs.getFloat("sfees");
            sdob = rs.getString("sdob");
            //System.out.println(sid + "\t" + sname + "\t" + sage + "\t" + semail + "\t" + sfees + "\t" + sdob);
        System.out.printf("%-20d%-20s%-20d%-20s%-20f%-20s\n",sid,sname,sage,semail,sfees,sdob);
        //System.out.println();
        
        } else {
            System.out.println("Student not exists");
        }

        
        conn.close();
    }
}

