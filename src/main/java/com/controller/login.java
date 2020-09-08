package com.controller;

import com.dao.AdminDao;
import com.dao.LoginDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        //request.getRequestDispatcher("link.html").include(request,response);

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean adminStatus = AdminDao.isAdmin(username,password);
        if(adminStatus){
            //create a session
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            // generate a new session
            HttpSession newSession = request.getSession();
            newSession.setAttribute("username", username);
            response.sendRedirect("./HTML/adminHome.jsp");
        }
        else {
            boolean status = LoginDao.authenticate(username, password);
            System.out.println(status);
            if (status) {
                //create a session
                HttpSession oldSession = request.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }
                // generate a new session
                HttpSession newSession = request.getSession();
                newSession.setAttribute("username", username);
                response.sendRedirect("./HTML/home.jsp");

            } else {
                PrintWriter out = response.getWriter();
                out.println("<script>window.alert(\"No Such Username\")</script>");
                RequestDispatcher rd = request.getRequestDispatcher("login.html");
                rd.include(request, response);
            }
        }
    }
}
