import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddItemsController {
    @FXML
    private TextField itemNameField;
    @FXML
    private TextField itemQuantityField;

    @FXML
    private void save() throws SQLException {
        String itemName = itemNameField.getText();
        int itemQuantity = Integer.parseInt(itemQuantityField.getText());

        Database.addItems(itemName, itemQuantity);

    }

    @FXML
    private void close(){
        Stage addStage = (Stage) itemQuantityField.getScene().getWindow();
        addStage.close();
    }
}
