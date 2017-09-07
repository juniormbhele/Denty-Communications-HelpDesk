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
 * Created by Sphiwe.Mbhele on 2017/09/06.
 */
public class TicketReplyDisplay extends HttpServlet
{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<TicketDto> tickets = null;
        List<Responses> res = null;
        String ticketId = (String) request.getParameter("tickets.TICKETSID");


        try {
            tickets = displayTickets(request, response);
            res = DisplayReplies.displayReplies(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.setAttribute("ReplyList", res);
        request.setAttribute("TicketsList", tickets);
        request.getRequestDispatcher("/AdminTickets.jsp").forward(request, response);


    }



    public List<TicketDto> displayTickets(HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, ServletException, IOException {
        List<TicketDto> tickets = new ArrayList<TicketDto>();

        Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM SYSTEM.TICKETS ");
        ResultSet rs = ps.executeQuery();

        while(rs.next())
        {
            TicketDto ticket = new TicketDto();


            ticket.setTICKETSID(rs.getString("TICKETSID"));
            ticket.setTICKETSDESCRIPTION(rs.getString("TICKETSDESCRIPTION"));
            ticket.setTICKETSTITLE(rs.getString("TICKETSTITLE"));
            ticket.setUSERNAME(rs.getString("USERNAME"));
            ticket.setSTATUS(rs.getString("STATUS"));
            ticket.setRESOLVEDON(rs.getString("RESOLVEDON"));
            ticket.setPOSTEDON(rs.getString("POSTEDON"));
            ticket.setASSIGNEDTO(rs.getString("ASSIGNEDTO"));

            tickets.add(ticket);

        }

        return tickets;
    }

}
