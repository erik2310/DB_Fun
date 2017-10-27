import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connector {
    // Declare a connection
    private static Connection con = null;
    // JDBC driver
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    // the url = jdbc://host name:port#/db name
    private static String url = "jdbc:mysql://localhost:3306/";
    // user name
    private static String usr = "root";
    // password
    private static String password = "";

    public static Connection connect() {
        System.out.println("--Connecting to MySQL JDBC");
        // Locate MySQL JDBC Driver
        try {
            Class.forName(DRIVER);
        } // Catch exceptions if JDBC is not found
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("--JDBC driver is missing--");

        }
        System.out.println("--MySQL JDBC driver registered--");

        try { // Connect to MySQL DB = URL, userName, password
            con = DriverManager.getConnection(url, usr, password);
        } // Catch exceptions on connection error
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("--Did not connect try again--");
        }
        // if connection successful
        if (con != null) {
            System.out.println("--Connection successful--");
        } else {
            System.out.println("--Failed to connect--");
        }
        return con;
    }


}