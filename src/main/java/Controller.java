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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

//Control Panel
public class Controller {


    public Button addButton; // added so I can close the scene

    @FXML
    private void addItems() throws IOException {
        openWindow("/addItems.fxml", "Add Items", 450, 400);
    }
    @FXML
    private void seeItems() throws IOException {
        openWindow("/seeItems.fxml", "See Items", 450, 400);
    }
    @FXML
    private void sellItems() throws IOException {
        openWindow("/SellItems.fxml", "Sell Items", 450, 400);
    }
    @FXML
    private void exit() {
        Stage addStage = (Stage)addButton.getScene().getWindow();
        addStage.close();
    }

    private void openWindow(String fxml, String title, int width, int height) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
        Scene scene = new Scene(loader.load(), width, height);

        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
