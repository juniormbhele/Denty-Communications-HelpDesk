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
 * Created by Sphiwe.Mbhele on 2017/09/04.
 */
public class tickets extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        displayIssues(login.username, request,response);
        request.getRequestDispatcher("/tickets.jsp").forward(request, response);

    }

    public static void displayIssues(String username, HttpServletRequest request,
                                     HttpServletResponse response) throws ServletException, IOException {

        String title = null;
        String description = null;
        String postDate = null;
        String status = null;
        String resolvedDate = null;
        String supportPerson = null;
        String issuesID = null;


        String loginID = null;
        try {
            Connection con = Database.getConnection();

            if (con != null)
            {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM SYSTEM.CUSTOMERS C INNER JOIN SYSTEM.ISSUES I on C.CUSTOMERID = I.CUSTOMERID WHERE C.LOGINNAME=?" );
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();

                if (rs.next())
                {
                    description = rs.getString("ISSUEDESCRIPTION");
                    title = rs.getString("ISSUETITLE");
                    postDate = rs.getString("POSTEDON");
                    status = rs.getString("STATUS");
                    resolvedDate = rs.getString("RESOLVEDON");


                    request.setAttribute("userMessage", username);
                    request.setAttribute("title", title);
                    request.setAttribute("customer", username);
                    request.setAttribute("date", postDate);
                    request.setAttribute("desc", description);
                    request.setAttribute("status", status);

                    issuesID =rs.getString("ISSUEID");

                    home.displayReplies(issuesID, request, response);

                } else
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

    public static void displayReplies(String issuesID, HttpServletRequest request,
                                      HttpServletResponse response) throws ServletException, IOException {

        String IRTITLE = null;
        String IRDESCRIPTION = null;
        String POSTEDON = null;
        String POSTEDBY = null;
        try {
            Connection con = Database.getConnection();

            if (con != null)
            {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM SYSTEM.ISSUERESPONSES WHERE ISSUEID LIKE ?" );
                ps.setString(1, issuesID);
                ResultSet rs = ps.executeQuery();

                if (rs.next())
                {
                    IRTITLE = rs.getString("IRTITLE");
                    IRDESCRIPTION = rs.getString("IRDESCRIPTION");
                    POSTEDON = rs.getString("POSTEDON");
                    POSTEDBY = rs.getString("POSTEDBY");


                    request.setAttribute("Replytitle", IRTITLE);
                    request.setAttribute("Replydesc", IRDESCRIPTION);
                    request.setAttribute("Rplydate", POSTEDON);
                    request.setAttribute("PostedBy", POSTEDBY);

                } else
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
