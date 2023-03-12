package ui;

import java.sql.*;
/**
 * "Java Database Connectivity with MySQL"
 * CREDIT: https://www.javatpoint.com/example-to-connect-to-the-mysql-database
 * **/
public class MysqlCon{
    public static void main(String args[]){
        String url = "jdbc:mysql://localhost:3306/trackmate";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    url,"root","mfl@mySQL03");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from users");

            while(rs.next()) {
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            }

            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
