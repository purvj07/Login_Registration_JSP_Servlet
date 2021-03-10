package com.fujitsu.loginAndRegister.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fujitsu.loginAndRegister.DAO.UserDao;
import com.fujitsu.loginAndRegister.model.copy.User;

@WebServlet("/UserController")
public class UserController extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

		try {

			UserDao dao = new UserDao();
			ResultSet rs =  dao.retrieveDetails();
			User user;
			ArrayList userslist = new ArrayList();

			
         
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
				userslist.add(user);
				System.out.println(userslist);
				//				userslist.add(rs.getInt(1));
				//				userslist.add(rs.getString(2));
				//				userslist.add(rs.getString(3));
				//				userslist.add(rs.getInt(4));
				//				userslist.add(rs.getString(5));


				
			}
			
			request.setAttribute("userslist",userslist );
			request.getRequestDispatcher("admin.jsp").forward(request, response);



			//			for (int i=0;i< userslist.size();i++)
			//				System.out.println(userslist.get(i));
		}
		catch (Exception e) {
			e.printStackTrace();
		}


	}




}
