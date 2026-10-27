//Controller.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class Controller {
    @FXML
    private void addItems() {
        System.out.println("This button adds an item");
    }
    @FXML
    private void seeItems() {
        System.out.println("This button sees all items");
    }
    @FXML
    private void sellItems() {
        System.out.println("This button sells an item");
    }
    @FXML
    private void exit() {
        System.out.println("This button exits the program");
    }
}
