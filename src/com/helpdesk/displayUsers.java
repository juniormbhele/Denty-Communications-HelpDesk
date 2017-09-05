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
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

/**
 * Created by Sphiwe.Mbhele on 2017/09/04.
 */
public class displayUsers extends HttpServlet
{




    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ArrayList users = new ArrayList();
        users=displayUsers(request,response);

        request.setAttribute("usersList", users);
        request.getRequestDispatcher("/helpdeskUsers.jsp").forward(request, response);


    }


    public static ArrayList displayUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String CUSTOMERID = null;
        String password = null;
        String REG_DATE = null;
        String EMAIL = null;
        String SERIALNO = null;
        String LOGINNAME = null;
        ArrayList users = new ArrayList();
        try {
            Connection con = Database.getConnection();

            if (con != null)
            {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM SYSTEM.CUSTOMERS" );
                ResultSet rs = ps.executeQuery();

                ResultSetMetaData md = rs.getMetaData();
                int columnCount = md.getColumnCount();



                if (rs.next())
                {
                    ArrayList row = new ArrayList();


                    while (rs.next())
                    {

                        for (int i = 0; i <= columnCount ; i++)
                        {
                            row.add(rs.getString("CUSTOMERID"));
                            row.add(rs.getString("LOGINNAME"));
                            row.add(rs.getString("REG_DATE"));
                            row.add(rs.getString("EMAIL"));
                            row.add(rs.getString("SERIALNO"));

                        }
                        users.add(row);
                    }


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

        return users;
    }

}
