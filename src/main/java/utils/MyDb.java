package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDb {
    private String Url = "jdbc:mysql://localhost:3306/workshop";
    private String user = "root";
    private String password = "";
    private Connection con;
    private static MyDb mydb;

    private MyDb() {
        try {
            this.con = DriverManager.getConnection(Url, user, password);
            System.out.println("connection established ");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getCon() {
        return con;
    }


    public static MyDb getMydb() {
        if (mydb == null) {

            mydb = new MyDb();
        }
        return mydb;
    }


}
