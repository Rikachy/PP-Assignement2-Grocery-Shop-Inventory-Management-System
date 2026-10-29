import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import java.sql.SQLException;

public class AddItemsController {
    @FXML
    private TextField itemNameField;
    @FXML
    private TextField itemQuantityField;

    @FXML
    private void save()  {

        try {
            String itemName = itemNameField.getText().trim();
            int itemQuantity = Integer.parseInt(itemQuantityField.getText().trim());

            if(itemName.isEmpty()) {
                throw new InvalidItemException("The name can't be empty");
            }
            if(itemQuantity < 0) {
                throw new InvalidItemException("Quantity can't be less than 0");
            }
            Database.addItems(itemName, itemQuantity);

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.WARNING, "Invalid quantity", "The item quantity has to be a valid number");
        }
        catch (InvalidItemException e){
            showAlert(Alert.AlertType.WARNING,"Invalid quantity", "The quantity has to be 0 or higher");
        }
        catch (SQLException e){
            showAlert(Alert.AlertType.ERROR, "Database Error", "Something went horribly wrong in the database :(");
        }
    }

    public void showAlert(Alert.AlertType type, String title, String message){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void close(){
        Stage addStage = (Stage) itemQuantityField.getScene().getWindow();
        addStage.close();
    }
}
