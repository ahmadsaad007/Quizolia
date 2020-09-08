package com.controller;

import com.dao.RegisterDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        PrintWriter out = response.getWriter();

        if (username == null || password == null || name == null) {
            out.println("<h3>PLEASE ENTER ALL THE INFORMATION FOR USER</h3>");
            RequestDispatcher rd = request.getRequestDispatcher("/HTML/register.jsp");
            rd.include(request, response);
            return;
        }
        boolean successful = RegisterDao.register(username,password,name);
        if(!successful){
            out.println("USERNAME ALREADY OCCUPIED");
            request.getRequestDispatcher("/HTML/register.jsp").include(request, response);
        }
        else{
            out.println("Successfuly Registered. Please login");
            request.getRequestDispatcher("/login.html").include(request,response);
        }
    }
}
