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
            throws ServletException, IOException
    {

        try {
            addUsers(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



    public void addUsers(HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, ServletException, IOException {
        List<UserDto> users = new ArrayList<UserDto>();

        Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM SYSTEM.USERS ORDER BY USERNAME");
        ResultSet rs = ps.executeQuery();

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
            user.setPassword(rs.getString("PASSWORD"));
            user.setReg_date(rs.getString("REG_DATE"));
            user.setRole(rs.getString("ROLE"));

            users.add(user);

        }

        for (int i =0;i<2;i++)
        {
            System.out.println(users.get(i).getAbout());
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.setAttribute("usersList", users);
        request.getRequestDispatcher("/helpdeskUsers.jsp").forward(request, response);

    }

}
