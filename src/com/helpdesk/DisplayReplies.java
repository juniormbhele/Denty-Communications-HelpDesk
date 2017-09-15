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


public class DisplayReplies extends HttpServlet
{
    static TicketDto ticket = new TicketDto();

    public static List<Responses> displayReplies( HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, ServletException, IOException {
        List<Responses> res = new ArrayList<Responses>();
        String ticketId = request.getParameter("id");

        Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM TICKETS T LEFT JOIN TICKETSRESPONSES J ON T.TICKETSID = J.TICKETSID WHERE  T.TICKETSID =?");
        ps.setString(1, ticketId);
        ResultSet rs = ps.executeQuery();

        while(rs.next())
        {
            Responses replies = new Responses();


            replies.setTICKETSID(rs.getString("TICKETSID"));
            replies.setTRTITLE(rs.getString("TRTITLE"));
            replies.setTRDESCRIPTION(rs.getString("TRDESCRIPTION"));
            replies.setPOSTEDON(rs.getString("REPLIEDON"));
            replies.setPOSTEDBY(rs.getString("POSTEDBY"));
            ticket.setTICKETSID(rs.getString("TICKETSID"));
            ticket.setTICKETSDESCRIPTION(rs.getString("TICKETSDESCRIPTION"));
            ticket.setTICKETSTITLE(rs.getString("TICKETSTITLE"));
            ticket.setUSERNAME(rs.getString("USERNAME"));
            ticket.setSTATUS(rs.getString("STATUS"));
            ticket.setRESOLVEDON(rs.getString("RESOLVEDON"));
            ticket.setPOSTEDON(rs.getString("POSTEDON"));
            ticket.setASSIGNEDTO(rs.getString("ASSIGNEDTO"));


            res.add(replies);

        }

        return res;
    }

    public static void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        request.setAttribute("TicketNo", ticket.getTICKETSID());
        request.setAttribute("Title", ticket.getTICKETSTITLE());
        request.setAttribute("POSTEDBY", ticket.getUSERNAME());
        request.setAttribute("date", ticket.getPOSTEDON());
        request.setAttribute("body", ticket.getTICKETSDESCRIPTION());
        request.setAttribute("status", ticket.getSTATUS());


        request.setAttribute("ReplyList", res);
        request.getRequestDispatcher("/TicketReply.jsp").forward(request, response);


    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        display(request, response);

    }
}
