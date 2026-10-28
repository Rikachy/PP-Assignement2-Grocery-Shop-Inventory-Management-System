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
            System.out.println("Quantity MUST be a number");
        }
        catch (InvalidItemException e){
            System.out.println(e.getMessage());
        }
        catch (SQLException e){
            System.out.println("Database ran into trouble: " + e.getMessage());
        }
    }

    @FXML
    private void close(){
        Stage addStage = (Stage) itemQuantityField.getScene().getWindow();
        addStage.close();
    }
}
