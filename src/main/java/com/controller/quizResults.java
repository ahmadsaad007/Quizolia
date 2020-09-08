package com.controller;

import com.dao.ResultsDao;
import com.domain.QuizSubmissions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class quizResults extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("username")==null){
            out.print("<div style='margin-top: 50px; color: crimson;'>Please login first</div>");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        String username = (String) session.getAttribute("username");
        List<QuizSubmissions> list = ResultsDao.getResults(username);
        session.setAttribute("results",list);
        request.getRequestDispatcher("/HTML/results.jsp").include(request,response);
    }
}
