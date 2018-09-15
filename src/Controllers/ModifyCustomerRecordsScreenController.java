package Controllers;

import DataModels.AddressModel;
import DataModels.CityModel;
import DataModels.CountryModel;
import DataModels.CustomerModel;
import DataModels.DatabaseConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ModifyCustomerRecordsScreenController implements Initializable {
    CustomerModel customer = CustomersScreenController.getCustomerToModify();
    AddressModel address = DatabaseConnection.getAddressById(customer.getAddressId());
    CityModel city = DatabaseConnection.getCityById(address.getCityId());
    
    @FXML
    private Label customerId;  
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
    private Label customerIdValue;
    @FXML
    private TextField nameText;
    @FXML
    private TextField addressText;
    @FXML
    private TextField address2Text;
    @FXML
    private ChoiceBox cityChoiceBox;
    @FXML
    private Label countryLabelValue;
    @FXML
    private TextField postalCodeText;
    @FXML
    private TextField phoneText;
    @FXML
    private CheckBox activeCheckBox;
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
        addCustomerLabel.setText("Modify Customer");
        addCustomerLabel.setLayoutX(40);
        addCustomerLabel.setLayoutY(20);
        addCustomerLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-fill: midnightblue");
        
        customerId.setText("Customer Id");
        customerId.setLayoutX(40);
        customerId.setLayoutY(70);
        customerId.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        customerIdValue.setLayoutX(120);
        customerIdValue.setLayoutY(70);
        customerIdValue.setText(Integer.toString(customer.getCustomerId()));
        
        nameLabel.setText("Name");
        nameLabel.setLayoutX(40);
        nameLabel.setLayoutY(110);
        nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        nameText.setLayoutX(120);
        nameText.setLayoutY(110);
        nameText.setText(customer.getCustomerName());
        
        addressLabel.setText("Address");
        addressLabel.setLayoutX(40);
        addressLabel.setLayoutY(160);
        addressLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        addressText.setLayoutX(120);
        addressText.setLayoutY(160);
        addressText.setText(address.getAddress());
        
        address2Label.setText("Address 2");
        address2Label.setLayoutX(40);
        address2Label.setLayoutY(210);
        address2Label.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");

        address2Text.setLayoutX(120);
        address2Text.setLayoutY(210);
        address2Text.setText(address.getAddress2());
        
        cityLabel.setText("City");
        cityLabel.setLayoutX(40);
        cityLabel.setLayoutY(260);
        cityLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        cityChoiceBox.setLayoutX(120);
        cityChoiceBox.setLayoutY(260);
        populateCityChoices();
        cityChoiceBox.getSelectionModel().select(city.getCity());

        
        countryLabel.setText("Country");
        countryLabel.setLayoutX(40);
        countryLabel.setLayoutY(310);
        countryLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        countryLabelValue.setLayoutX(120);
        countryLabelValue.setLayoutY(310);
        countryLabelValue.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        postalCodeLabel.setText("Postal Code");
        postalCodeLabel.setLayoutX(40);
        postalCodeLabel.setLayoutY(360);
        postalCodeLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        postalCodeText.setLayoutX(120);
        postalCodeText.setLayoutY(360);
        postalCodeText.setText(address.getPostalCode());
        
        phoneLabel.setText("Phone");
        phoneLabel.setLayoutX(40);
        phoneLabel.setLayoutY(410);
        phoneLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        phoneText.setLayoutX(120);
        phoneText.setLayoutY(410);
        phoneText.setText(address.getPhone());
        
        activeLabel.setText("Active");
        activeLabel.setLayoutX(40);
        activeLabel.setLayoutY(460);
        activeLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        activeCheckBox.setLayoutX(120);
        activeCheckBox.setLayoutY(460);
        if(customer.getActive() == 1){
            activeCheckBox.setSelected(true);
        }
        
        save.setText("Save");
        save.setPrefSize(80, 30);
        save.setLayoutX(190);
        save.setLayoutY(510);
        
        cancel.setText("Cancel");
        cancel.setPrefSize(80, 30);
        cancel.setLayoutX(90);
        cancel.setLayoutY(510);
    }
    
    @FXML
    private void populateCityChoices(){
        ObservableList<CityModel> cities = DatabaseConnection.getAllCities();
        ObservableList<String> cityNames = FXCollections.observableArrayList();
        cities.forEach((c) -> cityNames.add(c.getCity()));
        cityChoiceBox.setItems(cityNames);
    }
    
    @FXML
    private void chooseCity(){
        ObservableList<CityModel> cities = DatabaseConnection.getAllCities();
        CityModel city  = cities.filtered((c) -> c.getCity().equals(cityChoiceBox.getSelectionModel().getSelectedItem().toString())).get(0);
        countryLabelValue.setText(DatabaseConnection.GetCountryById(city.getCountryId()).toString());

    }
    
    @FXML
    private void cancelClick(ActionEvent event) throws IOException{
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure you would like to cancel your changes?");
            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK)
                returnToCustomersScreen(event);
            else
                return;
    }
    
    private void returnToCustomersScreen(ActionEvent event) throws IOException{
        Parent mainWindow = FXMLLoader.load(getClass().getResource("/Views/CustomersScreen.fxml"));
        Scene scene = new Scene(mainWindow);
        Stage stage = new Stage();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Customer Records");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void saveClick(ActionEvent event) throws IOException{
        CustomerModel customerModel = new CustomerModel();
        AddressModel addressModel = new AddressModel();
        Date date = new Date();
        
        addressModel.setAddressId(address.getAddressId());
        addressModel.setAddress(addressText.getText());
        addressModel.setAddress2(address2Text.getText());
        addressModel.setCityId(DatabaseConnection.getCityIdByName(cityChoiceBox.getSelectionModel().getSelectedItem().toString()));
        addressModel.setPostalCode(postalCodeText.getText());
        addressModel.setPhone(phoneText.getText());
        addressModel.setCreateDate(new Timestamp(date.getTime()));
        addressModel.setCreatedBy(LoginScreenController.getCurrentUser());
        addressModel.setLastUpdate(new Timestamp(date.getTime()));
        addressModel.setLastUpdateBy(LoginScreenController.getCurrentUser());
        DatabaseConnection.updateAddress(addressModel);
        
        customerModel.setCustomerId(customer.getCustomerId());
        customerModel.setCustomerName(nameText.getText());
        customerModel.setAddressId(address.getAddressId());
        if(activeCheckBox.isSelected()){
            customerModel.setActive(1);
        }else{customerModel.setActive(0);}
        customerModel.setLastUpdate(new Timestamp(date.getTime()));
        customerModel.setLastUpdateBy(LoginScreenController.getCurrentUser());
        DatabaseConnection.updateCustomer(customerModel);
        
        returnToCustomersScreen(event);
    }

}
