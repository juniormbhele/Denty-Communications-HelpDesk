package com.helpdesk;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by Sphiwe.Mbhele on 2017/09/09.
 */
public class AddingReplies extends HttpServlet
{
    static TicketDto ticket = new TicketDto();
    Responses res = new Responses();
    private String status;


    private String timeStamp;


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {


        res.setTICKETSID(request.getParameter("TicketNo"));
        res.setTRTITLE("RE:" + request.getParameter("title"));
        res.setPOSTEDBY(login.username);
        res.setTRDESCRIPTION(request.getParameter("reply"));



        try
        {
            addReply(request, response);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.setAttribute("replyStatus", status);

        DisplayReplies.display(request, response);


    }

    public void addReply(HttpServletRequest request, HttpServletResponse response) throws SQLException, NumberFormatException
    {
        Random ran = new Random();
        int trid = ran.nextInt(25) + 5;


        try
        {
            Connection con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO SYSTEM.TICKETSRESPONSES(TRID,TICKETSID,TRTITLE,TRDESCRIPTION, POSTEDBY) VALUES(?,?,?,?,?)");
            ps.setInt(1, trid);
            ps.setString(2, res.getTICKETSID());
            ps.setString(3, res.getTRTITLE());
            ps.setString(4, res.getTRDESCRIPTION());
            ps.setString(5, res.getPOSTEDBY());
            ps.executeUpdate();
            ps.close();
            con.close();
            status = "Reply Added successfully";


        }
        catch (SQLException ex)
        {
            status = "Error while adding a Reply";
            ex.printStackTrace();
        }


    }

    public void setTime()
    {

        timeStamp = new SimpleDateFormat().format(Calendar.getInstance().getTime());

    }




}
