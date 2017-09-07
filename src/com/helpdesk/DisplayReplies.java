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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sphiwe.Mbhele on 2017/09/07.
 */
public class DisplayReplies extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Responses> res = null;

        try {
            res = displayReplies(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.setAttribute("ReplyList", res);
        request.getRequestDispatcher("/TicketReply.jsp").forward(request, response);


    }



    public static List<Responses> displayReplies( HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, ServletException, IOException {
        List<Responses> res = new ArrayList<Responses>();
        String ticketId = request.getParameter("id");

        Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM SYSTEM.TICKETSRESPONSES C INNER JOIN SYSTEM.TICKETS I on C.TICKETSID = I.TICKETSID WHERE C.TICKETSID=?");
        ps.setString(1, ticketId);
        ResultSet rs = ps.executeQuery();

        while(rs.next())
        {
            Responses replies = new Responses();


            replies.setTRID(rs.getString("TRID"));
            replies.setTICKETSID(rs.getString("TICKETSID"));
            replies.setTRTITLE(rs.getString("TRTITLE"));
            replies.setTRDESCRIPTION(rs.getString("TRDESCRIPTION"));
            replies.setPOSTEDON(rs.getString("POSTEDON"));
            replies.setPOSTEDBY(rs.getString("POSTEDBY"));

            res.add(replies);

        }

        return res;
    }


}
