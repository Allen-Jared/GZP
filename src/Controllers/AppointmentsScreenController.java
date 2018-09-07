package Controllers;

import DataModels.CustomerModel;
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
    private TextField contactText;
    @FXML
    private TextField typeText;
    @FXML
    private TextField urlText;
    @FXML
    private TextField startTimeText;
    @FXML
    private TextField endTimeText;
    @FXML
    private Button save;
    @FXML
    private Button cancel;
    
    @FXML
    private AnchorPane addCustomerPane;
    @FXML
    private Button customerSearchButton;
    @FXML
    private TextField customerSearchTextField;
    @FXML
    private TableView<CustomerModel> customerTable;
    @FXML
    private TableColumn<CustomerModel, Integer> customerId;
    @FXML
    private TableColumn<CustomerModel, String> customerName;
    @FXML
    private TableColumn<CustomerModel, String> customerPhoneNumber;
    @FXML
    private TableColumn<CustomerModel, String> customerAddress;
    @FXML
    private Button addcustomer;
    @FXML
    private AnchorPane removeCustomerPane;
    @FXML
    private TableView<CustomerModel> associatedCustomerTable;
    @FXML
    private TableColumn<CustomerModel, Integer> rCustomerId;
    @FXML
    private TableColumn<CustomerModel, String> rCustomerName;
    @FXML
    private TableColumn<CustomerModel, Integer> rCustomerPhoneNumber;
    @FXML
    private TableColumn<CustomerModel, Double> rCustomerAddress;
    @FXML
    private Button deleteCustomer;
    
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
        
        contactText.setLayoutX(120);
        contactText.setLayoutY(260);

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
        
        startTimeText.setLayoutX(120);
        startTimeText.setLayoutY(410);
        
        endTimeLabel.setText("End Time");
        endTimeLabel.setLayoutX(40);
        endTimeLabel.setLayoutY(460);
        endTimeLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        endTimeText.setLayoutX(120);
        endTimeText.setLayoutY(460);
        
        save.setText("Save");
        save.setPrefSize(80, 30);
        save.setLayoutX(190);
        save.setLayoutY(510);
        
        cancel.setText("Cancel");
        cancel.setPrefSize(80, 30);
        cancel.setLayoutX(90);
        cancel.setLayoutY(510);
        
        addCustomerPane.setPrefSize(275, 125);
        addCustomerPane.setLayoutX(275);
        addCustomerPane.setLayoutY(0);
        
        customerSearchButton.setText("Search");
        customerSearchButton.setPrefSize(80, 30);
        customerSearchButton.setLayoutX(190);
        customerSearchButton.setLayoutY(20);
        
        customerSearchTextField.setPrefSize(160, 30);
        customerSearchTextField.setLayoutX(280);
        customerSearchTextField.setLayoutY(20);

        
        customerTable.setPrefSize(400, 200);
        customerTable.setLayoutX(40);
        customerTable.setLayoutY(65);
        customerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        customerId.setText("ID");
        
        customerName.setText("Name");
        
        customerPhoneNumber.setText("Phone");
        
        customerAddress.setText("Address");
        
        customerId.setCellValueFactory(new PropertyValueFactory<>("partID"));
        customerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("inStock"));
        customerAddress.setCellValueFactory(new PropertyValueFactory<>("price"));
                
        addcustomer.setText("Add");
        addcustomer.setPrefSize(80, 30);
        addcustomer.setLayoutX(350);
        addcustomer.setLayoutY(275);
        
        removeCustomerPane.setPrefSize(275, 125);
        removeCustomerPane.setLayoutX(275);
        removeCustomerPane.setLayoutY(300);
        
        associatedCustomerTable.setPrefSize(400, 200);
        associatedCustomerTable.setLayoutX(40);
        associatedCustomerTable.setLayoutY(65);
        associatedCustomerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        rCustomerId.setText("ID");
        
        rCustomerName.setText("Name");
        
        rCustomerPhoneNumber.setText("Phone");
        
        rCustomerAddress.setText("Address");
        
        rCustomerId.setCellValueFactory(new PropertyValueFactory<>("partID"));
        rCustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        rCustomerPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("inStock"));
        rCustomerAddress.setCellValueFactory(new PropertyValueFactory<>("price"));
        SetInitialCustomerTableLoad();
        
        deleteCustomer.setText("Delete");
        deleteCustomer.setPrefSize(80, 30);
        deleteCustomer.setLayoutX(350);
        deleteCustomer.setLayoutY(275);
    }
    
    @FXML
    private void SetInitialCustomerTableLoad(){
        customerTable.setItems(getInitialCustomerTableData());
    }
    
    @FXML
    public static ObservableList<CustomerModel> getInitialCustomerTableData(){
//        for(int i = 0; i < Inventory.getAllParts().size(); i++){
//            productParts.add(Inventory.getAllParts().get(i));
//        }
        return FXCollections.observableArrayList();
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
