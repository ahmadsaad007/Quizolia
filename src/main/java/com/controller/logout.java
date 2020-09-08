package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class logout extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        System.out.println("Trying to log out");
        HttpSession session = req.getSession(false);

        if(req.getParameter("Yes")!= null) {
            if (session != null) {
                session.invalidate();
                out.print("<div style='margin-top: 50px; color: crimson;'>You are now logged out!</div>");
                req.getRequestDispatcher("login.html").include(req, resp);
            }else {
                out.print("<div style='margin-top: 50px; color: crimson;'>Please login first</div>");
                req.getRequestDispatcher("login.html").include(req, resp);
            }
        }
        else{
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }
}