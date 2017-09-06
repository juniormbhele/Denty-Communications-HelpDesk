package com.helpdesk;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sphiwe.Mbhele on 2017/09/04.
 */
public class displayUsers extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<UserDto> users = null;
        try {
            users = addUsers(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("usersList", users);
        request.getRequestDispatcher("/helpdeskUsers.jsp").forward(request, response);


    }



    public List<UserDto> addUsers(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException
    {
        List<UserDto> users = new ArrayList<UserDto>();

        Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM SYSTEM.USERS");
        ResultSet rs = ps.executeQuery();
        rs.beforeFirst();
        while(rs.next())
        {
            UserDto user = new UserDto();

            user.setUsername(rs.getString("USERNAME"));
            user.setFirstName(rs.getString("FIRSTNAME"));
            user.setLastName(rs.getString("LASTNAME"));
            user.setEmail(rs.getString("EMAIL"));
            user.setCompany(rs.getString("COMPANY"));
            user.setAddress(rs.getString("ADDRESS"));
            user.setCity(rs.getString("CITY"));
            user.setCountry(rs.getString("COUNTRY"));
            user.setPortalCode(rs.getString("PORTALCODE"));
            user.setAbout(rs.getString("ABOUT"));
            user.setRole(rs.getString("ROLE"));
            user.setReg_date(rs.getString("REG_DATE"));

            users.add(user);

        }
        return users;

    }

}
