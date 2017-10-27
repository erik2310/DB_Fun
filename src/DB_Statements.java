import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Statements {

    // Declare a Statement
    private static Statement stmt = null;

    // Declare a connection
    private static Connection con = DB_Connector.connect();

    // Method to create a new Database
    public void createNewDB(String DB_Name) {
        // SQL Statement
        String query = "create database if not exists " + DB_Name;

        try {
            // Connection
            stmt = con.createStatement();
            // Execute statement
            stmt.executeUpdate(query);
            System.out.println("\n--Database " + DB_Name + " created--");
        }
        catch (SQLException ex) {
            // Handle SQL exceptions
            System.out.println("\n--Statement did not execute--");
            ex.printStackTrace();
        }
    }

    // Method to use a database
    public void useDB(String DB_Name) {
        // Statement
        String query = "use " + DB_Name;
        try {
            // Connection
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("\n--Using " + DB_Name + "--");
        } catch (SQLException ex) {
            // Handle SQL exceptions
            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();
        }
    }

        public void createTable(String tableName) {
            //SQL statement
        String query = "create table if not exists " + tableName + "(" +
                "id int not null auto_increment, " +
                "myName varchar(28), " +
                "address varchar(28), " +
                "primary key (id)" +
                ")";
        try {
            // Connection
            stmt = con.createStatement();
            // Execute query
            stmt.executeUpdate(query);
            System.out.println("\n--Table " + tableName + " created--");
        }   catch (SQLException ex) {
            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();
        }
    }


}
