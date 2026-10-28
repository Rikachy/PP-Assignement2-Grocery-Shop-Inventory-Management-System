//Controller.java
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

//Control Panel
public class Controller {



    @FXML
    private void addItems() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/addItems.fxml"));
        Scene scene = new Scene(loader.load(), 450, 300);

        Stage stage = new Stage();
        stage.setTitle("Adding Items");
        stage.setScene(scene);
        stage.show();
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
