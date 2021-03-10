package com.fujitsu.loginAndRegister.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fujitsu.loginAndRegister.model.copy.User;

public class UserRegistrationDao {
	
	
	public boolean registerUser(User user)  {
		System.out.println("Start of Running RegistrationDAO :: registerUser ");
		
		String url = "jdbc:mysql://localhost:3306/registrationdetails";
		String db_userName = "root";
		String db_password = "root";
		
		Connection con;
		PreparedStatement pstmt;
		
		String sql = "insert into details values(?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,db_userName,db_password);
		    pstmt = con.prepareStatement(sql);
		    
		    pstmt.setInt(1, user.getId());
		    pstmt.setString(2, user.getUserName());
		    pstmt.setString(3, user.getPassword());
		    pstmt.setInt(4, user.getPhone());
		    pstmt.setString(5, user.getAddress());
		    
		    int result = pstmt.executeUpdate();
		    
		    if(result > 0)
		    	return true;
		   
		    return false;
		    	
		} 
		
		catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("End of Running RegistrationDAO :: registerUser ");
		return false;
	
		//abc.save(user);
	}

}
