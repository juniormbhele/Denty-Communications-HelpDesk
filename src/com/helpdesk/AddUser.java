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

/**
 * Created by Sphiwe.Mbhele on 2017/09/08.
 */
public class AddUser extends HttpServlet
{
    UserDto user = new UserDto();
    private String status;


    private String timeStamp;


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        setTime();



        user.setUsername((String) request.getParameter("username"));
        user.setPassword((String) request.getParameter("password"));
        user.setCompany((String) request.getParameter("company"));
        user.setFirstName((String) request.getParameter("firstName"));
        user.setLastName((String) request.getParameter("lastName"));
        user.setEmail((String) request.getParameter("email"));
        user.setAddress((String) request.getParameter("address"));
        user.setCity((String) request.getParameter("city"));
        user.setCountry((String) request.getParameter("country"));
        user.setPortalCode((String) request.getParameter("postalCode"));
        user.setAbout((String) request.getParameter("about"));
        user.setRole((String) request.getParameter("role"));
        user.setReg_date(timeStamp);


        try
        {
            addUser(request, response);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.setAttribute("status", status);

        request.getRequestDispatcher("/AddUser.jsp").forward(request, response);


    }

    public void addUser(HttpServletRequest request, HttpServletResponse response) throws SQLException
    {

        try
        {
            Connection con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO SYSTEM.USERS (USERNAME, FIRSTNAME, LASTNAME, EMAIL, COMPANY, ADDRESS, CITY, COUNTRY, PORTALCODE, ABOUT, PASSWORD, REG_DATE, ROLE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getCompany());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getCity());
            ps.setString(8, user.getCountry());
            ps.setString(9, user.getPortalCode());
            ps.setString(10, user.getAbout());
            ps.setString(11, user.getPassword());
            ps.setString(12, user.getReg_date());
            ps.setString(13, user.getRole());
            ps.executeUpdate();
            ps.close();
            con.close();
            status = "User Added successfully";


        }
        catch (SQLException ex)
        {
            status = "Error while adding a user";
            ex.printStackTrace();
        }


    }

    public void setTime()
    {

        timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

    }


}
