package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class CustomerRecordsScreenController implements Initializable {
    @FXML
    private Label addCustomerLabel;  
    @FXML
    private Label nameLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label address2Label;
    @FXML
    private Label cityLabel;
    @FXML
    private Label countryLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label activeLabel;
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField inv;
    @FXML
    private TextField priceCost;
    @FXML
    private TextField max;
    @FXML
    private TextField min;
    @FXML
    private TextField machineId;
    @FXML
    private TextField companyName;
    @FXML
    private Button save;
    @FXML
    private Button cancel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        InitializeWindow();
    }    
 
    @FXML 
    private void InitializeWindow() {
        addCustomerLabel.setText("Add Part");
        addCustomerLabel.setLayoutX(40);
        addCustomerLabel.setLayoutY(50);
        addCustomerLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 15; -fx-text-fill: blue");
        
        nameLabel.setText("Name");
        nameLabel.setLayoutX(40);
        nameLabel.setLayoutY(150);
        nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        name.setLayoutX(120);
        name.setLayoutY(150);
        
        addressLabel.setText("Inv");
        addressLabel.setLayoutX(40);
        addressLabel.setLayoutY(200);
        addressLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        address2Label.setText("Inv");
        address2Label.setLayoutX(40);
        address2Label.setLayoutY(200);
        address2Label.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        inv.setLayoutX(120);
        inv.setLayoutY(200);
        
        cityLabel.setText("Price/Cost");
        cityLabel.setLayoutX(40);
        cityLabel.setLayoutY(250);
        cityLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        priceCost.setLayoutX(120);
        priceCost.setLayoutY(250);

        countryLabel.setText("Min");
        countryLabel.setLayoutX(40);
        countryLabel.setLayoutY(300);
        countryLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        min.setLayoutX(120);
        min.setLayoutY(300);
        min.setPrefSize(50, 10);
        
        postalCodeLabel.setText("Max");
        postalCodeLabel.setLayoutX(185);
        postalCodeLabel.setLayoutY(300);
        postalCodeLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        max.setLayoutX(220);
        max.setLayoutY(300);
        max.setPrefSize(50, 10);
        
        phoneLabel.setText("Machine ID");
        phoneLabel.setLayoutX(40);
        phoneLabel.setLayoutY(350);
        phoneLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        phoneLabel.setVisible(false);
        
        machineId.setLayoutX(120);
        machineId.setLayoutY(350);
        machineId.setVisible(false);
        
        activeLabel.setText("Company Name");
        activeLabel.setLayoutX(40);
        activeLabel.setLayoutY(350);
        activeLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        activeLabel.setVisible(false);
        
        companyName.setLayoutX(120);
        companyName.setLayoutY(350);
        companyName.setVisible(false);
        
        save.setText("Save");
        save.setPrefSize(80, 30);
        save.setLayoutX(190);
        save.setLayoutY(400);
        
        cancel.setText("Cancel");
        cancel.setPrefSize(80, 30);
        cancel.setLayoutX(90);
        cancel.setLayoutY(400);
    }
    
    @FXML
    private void cancelClick(ActionEvent event) throws IOException{
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure you would like to cancel your changes?");
            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK)
                returnToMainScreen(event);
            else
                return;
    }
    
    private void returnToMainScreen(ActionEvent event) throws IOException{
        Parent mainWindow = FXMLLoader.load(getClass().getResource("/Views/MainScreen.fxml"));
        Scene scene = new Scene(mainWindow);
        Stage stage = new Stage();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Inventory Management System");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void saveClick(ActionEvent event) throws IOException{
        returnToMainScreen(event);
    }

}
