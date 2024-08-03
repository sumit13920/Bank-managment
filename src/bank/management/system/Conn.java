package bank.management.system;

import java.sql.*;
public class Conn {

    Connection c;
    Statement s;
    public Conn(){
        try {
            // class.forName(com.mysql.cj.jdbc.Driver);
             c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Sumit@123");
             s = c.createStatement();

            } catch (Exception e){
            System.out.println(e);
        }

    }

}
