package com.helpdesk;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Sphiwe.Mbhele on 2017/08/18.
 */
public class Users extends HttpServlet
{
    static String username= null;
        String password= null;
    static String company= null;
    static String firstName= null;
    static String lastName= null;
        static String email= null;
    static String address= null;
    static String city= null;
    static String country= null;
    static String portalCode= null;
    static String About= null;
    static String reg_date= null;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        userProfile(login.username,request,response);
        request.getRequestDispatcher("/userProfile.jsp").forward(request, response);

    }





    public static void userProfile(String USERN, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            Connection con = Database.getConnection();

            if (con != null)
            {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM SYSTEM.USERS WHERE USERNAME=?" );
                ps.setString(1, USERN);
                ResultSet rs = ps.executeQuery();


                if (rs.next())
                {

                    username= rs.getString("USERNAME");
                    firstName= rs.getString("FIRSTNAME");
                    lastName=  rs.getString("LASTNAME");
                    email=  rs.getString("EMAIL");
                    company=   rs.getString("COMPANY");
                    address=   rs.getString("ADDRESS");
                    city=   rs.getString("CITY");
                    country= rs.getString("COUNTRY");
                    portalCode=  rs.getString("PORTALCODE");
                    About= rs.getString("ABOUT");
                    reg_date=   rs.getString("REG_DATE");


                    request.setAttribute("userMessage", username);
                    request.setAttribute("USERNAME", username);
                    request.setAttribute("FIRSTNAME", firstName);
                    request.setAttribute("LASTNAME", lastName);
                    request.setAttribute("EMAIL", email);
                    request.setAttribute("COMPANY", company);
                    request.setAttribute("ADDRESS", address);
                    request.setAttribute("CITY", city);
                    request.setAttribute("COUNTRY", country);
                    request.setAttribute("PORTALCODE", portalCode);
                    request.setAttribute("ABOUT", About);



                }
                else
                {
                    System.out.println("Results set is empty");
                }

                rs.close();
                con.close();


            } else {
                System.out.println("Not connection for the database");
            }


        }
        catch (Exception ex)
        {
            System.out.println(ex);

        }

    }


}
