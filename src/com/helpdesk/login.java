package com.helpdesk;

/**
 * Created by Sphiwe.Mbhele on 2017/08/17.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//@WebServlet(name="login", urlPatterns={"/login"} )
public class login extends HttpServlet
{
    public static String username;
    public static String password;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

         username = request.getParameter("username");
         password = request.getParameter("password");

       String CurrentUsername = Userlogin(username, password);



        if (username != null)
        {
            if (CurrentUsername != null)
            {
                if(CurrentUsername.equals(username))
                {


                    home.displayIssues(username,request,response);

                    request.getRequestDispatcher("/tickets.jsp").forward(request, response);


                    System.out.println(CurrentUsername+""+username);
                }
                else
                {
                    request.setAttribute("errorMessage", "Invalid username or password");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }
            else
            {
                request.setAttribute("errorMessage", "Username from the database is empty");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }
        else
        {
            request.setAttribute("errorMessage", "Username from the screen is empty");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }




    }

    public static String Userlogin(String username, String password)
    {
        String loginID = null;
        try {
            Connection con = Database.getConnection();

            if (con != null)
            {
                PreparedStatement ps = con.prepareStatement("select * from SYSTEM.CUSTOMERS where LOGINNAME like ? AND PASSWORD like ?");
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();

                if (rs.next())
                {
                    loginID = rs.getString("LOGINNAME");

                } else
                {
                    System.out.println("Results set is empty");
                }

                rs.close();
                con.close();


            } else {
                System.out.println("Not connection for the database");
            }


        } catch (Exception ex)
        {
            return null;
        }
        return loginID;
    }


}
