package Controllers;

import DataModels.CityModel;
import DataModels.CustomerModel;
import DataModels.DatabaseConnection;
import DataModels.UserModel;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class AppointmentsScreenController implements Initializable {
    @FXML
    private Label addAppointmentLabel;  
    @FXML
    private Label customerLabel;
    @FXML
    private ChoiceBox customerChoiceBox;
    @FXML
    private Label titleLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label locationLabel;
    @FXML
    private Label contactLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Label urlLabel;
    @FXML
    private Label startTimeLabel;
    @FXML
    private Label endTimeLabel;
    @FXML
    private TextField titleText;
    @FXML
    private TextField descriptionText;
    @FXML
    private TextField locationText;
    @FXML
    private ChoiceBox contactChoiceBox;
    @FXML
    private TextField typeText;
    @FXML
    private TextField urlText;
    @FXML
    private ChoiceBox startTimeChoiceBox;
    @FXML
    private Label endTimeLabelValue;
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
        addAppointmentLabel.setText("Appointment");
        addAppointmentLabel.setLayoutX(40);
        addAppointmentLabel.setLayoutY(20);
        addAppointmentLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-fill: midnightblue");
        
        customerLabel.setText("Customer");
        customerLabel.setLayoutX(40);
        customerLabel.setLayoutY(70);
        customerLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        customerChoiceBox.setLayoutX(120);
        customerChoiceBox.setLayoutY(70);
        populateCustomerChoices();
        
        titleLabel.setText("Title");
        titleLabel.setLayoutX(40);
        titleLabel.setLayoutY(110);
        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        titleText.setLayoutX(120);
        titleText.setLayoutY(110);
        
        descriptionLabel.setText("Description");
        descriptionLabel.setLayoutX(40);
        descriptionLabel.setLayoutY(160);
        descriptionLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        descriptionText.setLayoutX(120);
        descriptionText.setLayoutY(160);
        
        locationLabel.setText("Location");
        locationLabel.setLayoutX(40);
        locationLabel.setLayoutY(210);
        locationLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");

        locationText.setLayoutX(120);
        locationText.setLayoutY(210);
        
        contactLabel.setText("Contact");
        contactLabel.setLayoutX(40);
        contactLabel.setLayoutY(260);
        contactLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        contactChoiceBox.setLayoutX(120);
        contactChoiceBox.setLayoutY(260);
        populateUserChoices();
        
        typeLabel.setText("Type");
        typeLabel.setLayoutX(40);
        typeLabel.setLayoutY(310);
        typeLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        typeText.setLayoutX(120);
        typeText.setLayoutY(310);
        
        urlLabel.setText("URL");
        urlLabel.setLayoutX(40);
        urlLabel.setLayoutY(360);
        urlLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        urlText.setLayoutX(120);
        urlText.setLayoutY(360);
        
        startTimeLabel.setText("Start Time");
        startTimeLabel.setLayoutX(40);
        startTimeLabel.setLayoutY(410);
        startTimeLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        startTimeChoiceBox.setLayoutX(120);
        startTimeChoiceBox.setLayoutY(410);
        ObservableList<String> times = FXCollections.observableArrayList();
        times.add("9:00 AM");
        times.add("10:00 AM");
        times.add("11:00 AM");
        times.add("12:00 PM");
        times.add("1:00 PM");
        times.add("2:00 PM");
        times.add("3:00 PM");
        times.add("4:00 PM");
        startTimeChoiceBox.setItems(times);
        
        endTimeLabel.setText("End Time");
        endTimeLabel.setLayoutX(40);
        endTimeLabel.setLayoutY(460);
        endTimeLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        endTimeLabelValue.setLayoutX(120);
        endTimeLabelValue.setLayoutY(460);
        
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
    private void populateCustomerChoices(){
        ObservableList<CustomerModel> customers = DatabaseConnection.getAllCustomers();
        ObservableList<String> customerNames = FXCollections.observableArrayList();
        customers.forEach((c) -> customerNames.add(c.getCustomerName()));
        customerChoiceBox.setItems(customerNames);
        customerChoiceBox.getSelectionModel().selectFirst();
    }
    
    @FXML
    private void populateUserChoices(){
        ObservableList<UserModel> users = DatabaseConnection.getAllUsers();
        ObservableList<String> userNames = FXCollections.observableArrayList();
        users.forEach((c) -> userNames.add(c.getUserName()));
        contactChoiceBox.setItems(userNames);
        contactChoiceBox.getSelectionModel().selectFirst();
    }
    
    @FXML
    private void chooseStartTime(){
        startTimeChoiceBox.getSelectionModel().getSelectedItem().toString();
    }
    
    @FXML
    private void cancelClick(ActionEvent event) throws IOException{
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure you would like to cancel your changes?");
            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK)
                returnToAppointmentsScreen(event);
            else
                return;
    }
    
    private void returnToAppointmentsScreen(ActionEvent event) throws IOException{
        Parent mainWindow = FXMLLoader.load(getClass().getResource("/Views/AddAppointmentScreen.fxml"));
        Scene scene = new Scene(mainWindow);
        Stage stage = new Stage();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Appointments");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void saveClick(ActionEvent event) throws IOException{
        returnToAppointmentsScreen(event);
    }   
    
    @FXML
    private void LoadCustomerTable(){
//        partsTable.setItems(FXCollections.observableArrayList(productParts)); 
    }
    
    @FXML
    private void LoadAssociatedCustomerTable(){
//        associatedPartsTable.setItems(FXCollections.observableArrayList(productAssociatedParts));
    }
    
//    @FXML
//    private void saveClick(ActionEvent event) throws IOException{
//        Product product = new Product();
//        product.setProductId(Integer.parseInt(id.getText()));
//        product.setName(name.getText());
//        product.setInStock(Integer.parseInt(inv.getText()));
//        product.setPrice(Double.parseDouble(priceCost.getText()));
//        product.setMin(Integer.parseInt(min.getText()));
//        product.setMax(Integer.parseInt(max.getText()));
//        
//        if (Integer.parseInt(min.getText()) > Integer.parseInt(max.getText())){
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setHeaderText(null);
//            alert.setContentText("Min value cannot be greater than Max value.");
//            alert.showAndWait();
//            return;            
//        }
//        
//        for(int i = 0; i < associatedPartsTable.getItems().size(); i++){
//            product.AddAssociatedPart(associatedPartsTable.getItems().get(i));
//        }
//        Inventory.AddProduct(product);
//        productAssociatedParts.removeAll(productAssociatedParts);
//        productParts.removeAll(productParts);
//        returnToMainScreen(event);
//    }
    
//    @FXML
//    private void cancelClick(ActionEvent event) throws IOException {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setContentText("Are you sure you would like to cancel your changes?");
//            alert.setHeaderText(null);
//            Optional<ButtonType> result = alert.showAndWait();
//            if(result.get() == ButtonType.OK)
//                returnToMainScreen(event);
//            else
//                return;
//        
//        productAssociatedParts.removeAll(productAssociatedParts);
//        productParts.removeAll(productParts);
//        returnToMainScreen(event);
//    }
    
    @FXML
    private void returnToAppointmentScreen(ActionEvent event) throws IOException{
        Parent mainWindow = FXMLLoader.load(getClass().getResource("/Views/AddAppointmentScreen.fxml"));
        Scene scene = new Scene(mainWindow);
        Stage stage = new Stage();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Appointments");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void customerSearchButtonClick() {
//        loadSearchPartData(partsSearchTextField.getText());
    }
    
    @FXML
    private void loadSearchCustomerData(String searchCriteria){
//        partsTable.setItems(Inventory.getAllMatchingPartNames(searchCriteria));
    }
    
    @FXML
    private void addCustomerClick() {
//        Part part = Inventory.lookupPart(partsTable.getSelectionModel().getSelectedItem().getPartID());
//        productAssociatedParts.add(part);
//        productParts.remove(part);
//        LoadPartsTable();
//        LoadAssociatedPartsTable();
    }
    
    @FXML
    private void deleteCustomerClick() {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setContentText("Are you sure you would like to unassociate this part from this product?");
//            alert.setHeaderText(null);
//            Optional<ButtonType> result = alert.showAndWait();
//            if(result.get() == ButtonType.OK){
//                Part part = Inventory.lookupPart(associatedPartsTable.getSelectionModel().getSelectedItem().getPartID());
//                productParts.add(part);
//                productAssociatedParts.remove(part);
//                LoadPartsTable();
//                LoadAssociatedPartsTable();
//            }
//            else
//                return;
    }
}
