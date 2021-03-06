import java.sql.*;


public class DB_Statements {

    // Declare a Statement
    private static Statement stmt = null;

    // Declare a connection
    private static Connection con = DB_Connector.connect();

    // Declare a result set
    private static ResultSet rs = null;

    // Declare a prepared statement
    private static PreparedStatement pst = null;

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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();
        }
    }

    // Method to insert data
    public void insertData(String tableName) {
        // SQL query
        String query = "insert into " + tableName + "(" +
                "myName, address) " +
                "values ('Douglas', 'My address'), " +
                "('Bob', 'His address'), " +
                "('John', 'Their address')";
        try {
            // Connect
            stmt = con.createStatement();
            // Execute query
            stmt.executeUpdate(query);
            System.out.println("\n--Data inserted into table " + tableName + "--");
        } catch (SQLException ex) {
            // Handle exception
            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();
        }
    }

    //Method to read data from table
    public void selectFromTable(String tableName) {
        //SQL query
        String query = "select * from " + tableName;

        try {
            // Connection
            stmt = con.createStatement();
            // Execute
            rs = stmt.executeQuery(query);
            System.out.println("\nid\t\tmyName\t\taddress\n_________________________________");

            // Get data
            while (rs.next()) {
                int id = rs.getInt(1);  // Returns ID(column 1)
                String MyName = rs.getString("MyName"); // Returns MyName (column 2)
                String address = rs.getString("address"); // Returns address (column 3)
                System.out.println(id + "\t\t" + MyName + "\t\t" + address);
            }
        } catch (SQLException ex) {
            System.out.println("\n--Query didn't execute--");
            ex.printStackTrace();
            }

    }

    //Checking user credentials
    public Boolean checkLogin(String username, String password) {
        boolean check = false;      // Boolean til at checke om username/password er rigtige. False som default.

        String query = "select * from thisdatabase.user where username = (?) and password = (?)";
        try {
            // stat = con.createStatement();
            pst = con.prepareStatement(query);
            // rs = stat.executeQuery(query);

            while (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();
        }
        return check;
    }
}
