package Dashboards;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    public Connection c;
    public Statement s;

    public Conn(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///HospitalManagementSystem", "root" , "Rafi#9617");
            s = c.createStatement();

        }
        catch (Exception e){
            System.out.println("SQL error");
        }



    }
}
