package com.helpdesk;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Sphiwe.Mbhele on 2017/08/18.
 */
public class signUp extends HttpServlet
{

    String username = null;
    String password = null;
    String email = null;
    String serialNumber = null;


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String email = request.getParameter("username");
        String serialNumber = request.getParameter("password");

        //Users.register(username,password,email,serialNumber);

        request.setAttribute("errorMessage", "User successfully added");
        request.getRequestDispatcher("/index.jsp").forward(request, response);




    }


}
