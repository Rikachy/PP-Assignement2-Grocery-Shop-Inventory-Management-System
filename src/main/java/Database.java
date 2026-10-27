import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet; //stored result
import java.sql.SQLException; //if errors occur
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Database {
    static String url = "jdbc:sqlite:grocery.db";

    public static Connection connection;

    static {  //static block is executed automatically
        try {
            connection = DriverManager.getConnection(url);
            createTable();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //ID is unique and increments by 1 automatically, ItemName/Quantity is not NULL
    public static void createTable() throws SQLException {
        String sql= "CREATE TABLE IF NOT EXISTS Grocery (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ItemName TEXT NOT NULL," +
                "Quantity INTEGER NOT NULL)";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public static void addItems(String itemName, int quantity) throws SQLException {
        String sql="INSERT INTO Grocery (ItemName, Quantity) VALUES (?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, itemName);
            preparedStatement.setInt(2, quantity);
            preparedStatement.execute();
        }
    }
}



