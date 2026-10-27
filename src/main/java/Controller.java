//Controller.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
public class Controller {
    @FXML
    private void showinfo() {
        String url = "jdbc:sqlite:C:\\Users\\farzadm\\Downloads\\DB1.db";
        String query = "SELECT age FROM emp";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("Employee List:");
            while (rs.next()) {// Matches the column name in the SELECT query
                String employeeAge = rs.getString("age");
                System.out.println(employeeAge);
            }
        } catch (SQLException e) {
            System.err.println("Database query error: " + e.getMessage());
        }
    }
}
