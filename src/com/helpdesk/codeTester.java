package com.helpdesk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Sphiwe.Mbhele on 2017/09/04.
 */
public class codeTester
{
    public static ArrayList displayUsers() throws IOException
    {
        String CUSTOMERID = null;
        String password = null;
        String REG_DATE = null;
        String EMAIL = null;
        String SERIALNO = null;
        String LOGINNAME = null;
        ArrayList users = new ArrayList();
        try {
            Connection con = Database.getConnection();

            if (con != null)
            {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM SYSTEM.CUSTOMERS" );
                ResultSet rs = ps.executeQuery();



                if (rs.next())
                {
                    while (rs.next())
                    {
                        ArrayList row = new ArrayList();
                        int columnCount = users.size();
                        for (int i = 1; i <= columnCount ; i++){
                            row.add(rs.getString(i));
                        }
                        users.add(row);
                    }


                }
                else
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

        return users;
    }

    public static void main(String[] args) throws IOException
    {
        ArrayList arr = displayUsers();

        for (int i=0;i<arr.size();i++)
        {
            for (int count=0;count<arr.size();count++)
            System.out.print(arr.get(i));
        }
    }
}
