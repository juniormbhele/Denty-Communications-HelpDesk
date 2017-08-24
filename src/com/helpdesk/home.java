package com.helpdesk;

/**
 * Created by Sphiwe.Mbhele on 2017/08/17.
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class home extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n=request.getParameter("username");
        out.print("Welcome "+n);
    }

}