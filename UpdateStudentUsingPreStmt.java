package jdbc;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateStudentUsingPreStmt {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        String driver ="com.mysql.cj.jdbc.Driver";
        Class.forName(driver);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Id");
        int sid = sc.nextInt();
        
        
        
        String url ="jdbc:mysql://localhost:3306/info";
        String un ="root";
        String pass="GITU@30";
        Connection conn = null;
        conn = DriverManager.getConnection(url,un,pass);
        
        String s ="Select * from student where sid=?";
        PreparedStatement ps = conn.prepareStatement(s);
        ps.setInt(1, sid);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
                String upd = "Update student set sname=?, semail=? where sid=?";
                PreparedStatement ps2 = conn.prepareStatement(upd);
                System.out.println("Enter Name");
                String sname = sc.next();
                System.out.println("Enter Email");
                String semail = sc.next();
                
                ps2.setString(1,sname);
                ps2.setString(2, semail);
                ps2.setInt(3, sid);
                
                
                int ret = ps2.executeUpdate();
                if(ret>0) {
                        System.out.println("Record updated successfully");
                }
                else {
                        System.out.println("Error");
                }
                
                
        }
        else {
                System.out.println("Id not exist");
        }
        conn.close();
        
} }
