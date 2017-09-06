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

        String TICKETSTITLE = null;
        String TICKETSDESCRIPTION = null;
        String postDate = null;
        String status = null;
        String resolvedDate = null;
        String supportPerson = null;
        String TICKETSID = null;
        String ASSIGNEDTO = null;


        String loginID = null;
        try {
            Connection con = Database.getConnection();

            if (con != null)
            {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM SYSTEM.USERS C INNER JOIN SYSTEM.TICKETS I on C.USERNAME = I.USERNAME WHERE C.USERNAME=?" );
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();

                if (rs.next())
                {
                    TICKETSDESCRIPTION = rs.getString("TICKETSDESCRIPTION");
                    TICKETSTITLE = rs.getString("TICKETSTITLE");
                    postDate = rs.getString("POSTEDON");
                    status = rs.getString("STATUS");
                    resolvedDate = rs.getString("RESOLVEDON");
                    ASSIGNEDTO = rs.getString("ASSIGNEDTO");


                    request.setAttribute("userMessage", username);
                    request.setAttribute("title", TICKETSTITLE);
                    request.setAttribute("customer", username);
                    request.setAttribute("date", postDate);
                    request.setAttribute("desc", TICKETSDESCRIPTION);
                    request.setAttribute("status", status);
                    request.setAttribute("ASSIGNEDTO", ASSIGNEDTO);


                    TICKETSID =rs.getString("TICKETSID");

                    displayReplies(TICKETSID, request, response);

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

    public static void displayReplies(String TRID, HttpServletRequest request,
                                      HttpServletResponse response) throws ServletException, IOException {

        String TRTITLE = null;
        String TRDESCRIPTION = null;
        String POSTEDON = null;
        String POSTEDBY = null;
        try {
            Connection con = Database.getConnection();

            if (con != null)
            {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM SYSTEM.TICKETSRESPONSES WHERE TRID LIKE ?" );
                ps.setString(1, TRID);
                ResultSet rs = ps.executeQuery();

                if (rs.next())
                {
                    TRTITLE = rs.getString("TRTITLE");
                    TRDESCRIPTION = rs.getString("TRDESCRIPTION");
                    POSTEDON = rs.getString("POSTEDON");
                    POSTEDBY = rs.getString("POSTEDBY");


                    request.setAttribute("Replytitle", TRTITLE);
                    request.setAttribute("Replydesc", TRDESCRIPTION);
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
