
package Controllers;

import DataModels.CustomerModel;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CustomersScreenController implements Initializable {
    
    private String _customerToModify;
    
    @FXML
    private Pane customersPane;
    @FXML
    private Label customersLabel;
    @FXML
    private Button customerSearchButton;
    @FXML
    private TextField customerSearchTextField;
    @FXML
    private TableView<CustomerModel> customersTable;
    @FXML
    private TableColumn<CustomerModel, Integer> customerId;
    @FXML
    private TableColumn<CustomerModel, String> customerName;
    @FXML
    private TableColumn<CustomerModel, String> customerPhoneNumber;
    @FXML
    private TableColumn<CustomerModel, String> customerAddress;
    @FXML
    private Button returnToCalendarScreen;
    @FXML
    private Button addCustomer;
    @FXML
    private Button modifyCustomer;
    @FXML
    private Button deleteCustomer;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        customersPane.setPrefSize(475, 325);
        customersPane.setLayoutX(10);
        customersPane.setLayoutY(10);
        customersPane.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        
        customersLabel.setText("Customers");
        customersLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 18; -fx-text-fill: midnightblue");
        customersLabel.setLayoutX(40);
        customersLabel.setLayoutY(20);
        
        customerSearchButton.setText("Search");
        customerSearchButton.setPrefSize(80, 30);
        customerSearchButton.setLayoutX(190);
        customerSearchButton.setLayoutY(20);
        
        customerSearchTextField.setPrefSize(160, 30);
        customerSearchTextField.setLayoutX(280);
        customerSearchTextField.setLayoutY(20);
        
        customersTable.setPrefSize(400, 200);
        customersTable.setLayoutX(40);
        customersTable.setLayoutY(65);
        customersTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        customerId.setText("ID");
        
        customerName.setText("Name");
        
        customerPhoneNumber.setText("Phone");
        
        customerAddress.setText("Address");
        
        customerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customerPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("customerPhoneNumber"));
        customerAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        LoadCustomerTableData();
        
        returnToCalendarScreen.setText("Calendar");
        returnToCalendarScreen.setPrefSize(80, 30);
        returnToCalendarScreen.setLayoutX(60);
        returnToCalendarScreen.setLayoutY(280);
        
        addCustomer.setText("Add");
        addCustomer.setPrefSize(80, 30);
        addCustomer.setLayoutX(160);
        addCustomer.setLayoutY(280);

        modifyCustomer.setText("Modify");
        modifyCustomer.setPrefSize(80, 30);
        modifyCustomer.setLayoutX(260);
        modifyCustomer.setLayoutY(280);

        deleteCustomer.setText("Delete");
        deleteCustomer.setPrefSize(80, 30);
        deleteCustomer.setLayoutX(360);
        deleteCustomer.setLayoutY(280);
    }    
        
    @FXML
    private void LoadCustomerTableData(){
//        customersTable.setItems(CustomerModel.GetAllCustomers()); 
    }
    
    @FXML
    private void customerSearchButtonClick() {
//        loadSearchPartData(customerSearchTextField.getText());
    }
    
    @FXML
    private void loadSearchCustomerData(String searchCriteria){
//        customersTable.setItems(CustomerModel.getAllMatchingCustomerNames(searchCriteria));
    }
    
    @FXML
    private void addCustomer(ActionEvent event) throws IOException {
        Parent addPartWindow = FXMLLoader.load(getClass().getResource("/Views/CustomerRecordsScreen.fxml"));
        Scene scene = new Scene(addPartWindow);
        Stage stage = new Stage();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Add Customer");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void modifyCustomer(ActionEvent event) throws IOException {
//        CustomerModel customerToModify = CustomerModel.lookupPart(customersTable.getSelectionModel().getSelectedItem().getCustomerName());//this getCustomerName needs to be fixed
//        _customerToModify = customerToModify.getCustomerName(); //also needs to be fixed
        ShowModifyCustomerWindow(event);
    }
    
    @FXML
    private void ShowModifyCustomerWindow(ActionEvent event) throws IOException{
        Parent modifyPartWindow = FXMLLoader.load(getClass().getResource("/Views/CustomerRecordsScreen.fxml"));
        Scene scene = new Scene(modifyPartWindow);
        Stage stage = new Stage();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Modify Customer");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void returnToCalendarScreen(ActionEvent event) throws IOException{
        Parent modifyPartWindow = FXMLLoader.load(getClass().getResource("/Views/CalendarScreen.fxml"));
        Scene scene = new Scene(modifyPartWindow);
        Stage stage = new Stage();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Calendar");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void deleteCustomer() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure you would like to delete this customer?");
            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
//                Part partToDelete = Inventory.lookupPart(partsTable.getSelectionModel().getSelectedItem().getPartID());
//                Inventory.DeletePart(partToDelete.getPartID());
//                LoadPartsTableData();
            }
            else
                return;
    }
}
