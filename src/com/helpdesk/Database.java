package com.helpdesk;

import java.sql.*;

public class Database
{


        public static Connection getConnection()
        {
            try
            {
                //step1 load the driver class
                Class.forName("oracle.jdbc.driver.OracleDriver");

                //step2 create  the connection object
                Connection con;
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

                //step3 create the statement object
                Statement stmt=con.createStatement();

                //step5 close the connection object
                   // con.close();

                return con;

            }catch(Exception e)
            {
                System.out.println(e);
                return null;
            }
        }


}

