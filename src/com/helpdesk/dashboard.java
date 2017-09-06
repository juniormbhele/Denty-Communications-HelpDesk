package com.helpdesk;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Sphiwe.Mbhele on 2017/09/05.
 */
public class dashboard extends HttpServlet
{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String CurrentUsername = login.Userlogin(username, password);

        request.setAttribute("userMessage", CurrentUsername);

        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);

    }
}
