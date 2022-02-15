package Jdbc_Package;

import java.util.*;
import java.sql.*;

public class Student {
	
	Connection con;
	Statement vstmt,dstmt;
	PreparedStatement ipst,upst;
	ResultSet rs;
	Scanner sc=new Scanner(System.in);

	
	
	
	public void Insert() throws ClassNotFoundException  {
		try {
			int id;
			String tname,tdob,tdoj;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?useSSL=false","root","");
			
			System.out.println("Enter student_no: ");
			id=sc.nextInt();
			
			System.out.println("Enter student_name: ");
			tname=sc.next();
			
			System.out.println("Enter student_dob (yyyy-MM-dd): ");
			tdob=sc.next();
			
			System.out.println("Enter student_doj(yyyy-MM-dd): ");
			tdoj=sc.next();
			
			java.sql.Date ob1=java.sql.Date.valueOf(tdob);
			java.sql.Date ob2=java.sql.Date.valueOf(tdoj);
			
			ipst=con.prepareStatement("insert into student values(?,?,?,?)");
			ipst.setInt(1, id);
			ipst.setString(2, tname);
			ipst.setDate(3, ob1);
			ipst.setDate(4, ob2);
			int x = ipst.executeUpdate();
			if(x!=0) {
				System.out.println("Record is inserted.");
			}
			
			
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	public void Update() throws ClassNotFoundException
	{
		try {
			int id;
			String tname,tdob,tdoj;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?useSSL=false","root","");
			
			System.out.println("Enter student_no : ");
			id=sc.nextInt();
			
			System.out.println("Enter student_name: ");
			tname=sc.next();
			
			System.out.println("Enter student_dob (yyyy-MM-dd): ");
			tdob=sc.next();
			
			System.out.println("Enter student_doj(yyyy-MM-dd):");
			tdoj=sc.next();
			
			java.sql.Date ob1=java.sql.Date.valueOf(tdob);
			java.sql.Date ob2=java.sql.Date.valueOf(tdoj);
			
			upst=con.prepareStatement("update student set student_name=?,student_dob=? ,student_doj=? where student_no=?");
			
			upst.setString(1, tname);
			upst.setDate(2, ob1);
			upst.setDate(3, ob2);
			upst.setInt(4, id);
			int x = upst.executeUpdate();
			
			if(x!=0) {
				System.out.println("Record is updated.");
			}
			
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	public void Delete() throws ClassNotFoundException
	{
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?useSSL=false","root","");
			
				dstmt=con.createStatement();	
				
				System.out.println("Enter student_no: ");
				int id=sc.nextInt();
				int x=dstmt.executeUpdate("delete from student where student_no ="+id);
				if(x!=0) {
					System.out.println("Record Deleted.");
				}
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	}	
	
	public void View() throws ClassNotFoundException
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?useSSL=false","root","");
			
			vstmt=con.createStatement();
			rs=vstmt.executeQuery("select * from student;");
			System.out.println("Student Details : ");
			System.out.print("Student_No"+"\t"+"Student_Name"+"\t"+"Student_dob"+"\t"+"Student_doj"+"\n");
			while(rs.next())
			{
				
				System.out.print("	"+rs.getInt("student_no")+"\t"+rs.getString("student_name")+"\t"+rs.getDate("student_dob")+"\t"+rs.getDate("student_doj")+"\n");
			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
}
