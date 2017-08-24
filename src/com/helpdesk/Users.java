package com.helpdesk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Sphiwe.Mbhele on 2017/08/18.
 */
public class Users
{
    int CustomerID = 0;
    String username = null;
    String password = null;
    DateFormat creationDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String email = null;
    String serialNumber = null;


    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreationDate(DateFormat creationDate) {
        this.creationDate = creationDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }


    public  int getCustomerID()
    {
        return CustomerID;
    }

    public  String getPassword() {
        return password;
    }

    public  String getUsername() {
        return username;
    }

    public  DateFormat getCreationDate() {
        return creationDate;
    }

    public  String getEmail() {
        return email;
    }

    public  String getSerialNumber() {
        return serialNumber;
    }

    public Users()
    {
        super();
    }


    public static void register(String username,String password, String email,String serialNumber )
    {
        int x = 0;
        try {
            Connection con = Database.getConnection();

            if (con != null)
            {
                PreparedStatement ps = con.prepareStatement("INSERT INTO CUSTOMERS (LOGINNAME, PASSWORD, EMAIL, SERIALNO) VALUES (?, ?, ?,?)");
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, email);
                ps.setString(4, serialNumber);

                ResultSet rs = ps.executeQuery();
                x++;
                if (x > 0)
                {
                    System.out.println("Data Saved Successfully");
                }

                con.close();


            } else {
                System.out.println("Not connection for the database");
            }


        } catch (Exception ex)
        {
            System.out.println(ex.getStackTrace());
        }

    }
}
