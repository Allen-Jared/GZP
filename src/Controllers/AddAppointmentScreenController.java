
package Controllers;

import DataModels.AppointmentModel;
import DataModels.CustomerModel;
import DataModels.DatabaseConnection;
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

public class AddAppointmentScreenController implements Initializable {
     
    private String _appointmentToModify;
    
    @FXML
    private Pane appointmentsPane;
    @FXML
    private Label appointmentsLabel;
    @FXML
    private Button appointmentsSearchButton;
    @FXML
    private TextField appointmentsSearchTextField;
    @FXML
    private TableView<AppointmentModel> appointmentsTable;
    @FXML
    private TableColumn<AppointmentModel, Integer> appointmentTitle;
    @FXML
    private TableColumn<AppointmentModel, String> appointmentContact;
    @FXML
    private TableColumn<AppointmentModel, String> appointmentCustomer;
    @FXML
    private TableColumn<AppointmentModel, String> appointmentStartTime;
    @FXML
    private TableColumn<AppointmentModel, Integer> appointmentType;
    @FXML
    private Button returnToCalendarScreen;
    @FXML
    private Button addAppointment;
    @FXML
    private Button modifyAppointment;
    @FXML
    private Button deleteAppointment;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        appointmentsPane.setPrefSize(475, 325);
        appointmentsPane.setLayoutX(10);
        appointmentsPane.setLayoutY(10);
        appointmentsPane.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        
        appointmentsLabel.setText("Appointments");
        appointmentsLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 18; -fx-text-fill: midnightblue");
        appointmentsLabel.setLayoutX(40);
        appointmentsLabel.setLayoutY(20);
        
        appointmentsSearchButton.setText("Search");
        appointmentsSearchButton.setPrefSize(80, 30);
        appointmentsSearchButton.setLayoutX(190);
        appointmentsSearchButton.setLayoutY(20);
        
        appointmentsSearchTextField.setPrefSize(160, 30);
        appointmentsSearchTextField.setLayoutX(280);
        appointmentsSearchTextField.setLayoutY(20);
        
        appointmentsTable.setPrefSize(400, 200);
        appointmentsTable.setLayoutX(40);
        appointmentsTable.setLayoutY(65);
        appointmentsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
        appointmentTitle.setText("Title");
        
        appointmentContact.setText("User");
        
        appointmentCustomer.setText("Customer");
        
        appointmentStartTime.setText("Place/Time");
        
        appointmentType.setText("Type");
        
        appointmentTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        appointmentContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        appointmentCustomer.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        appointmentStartTime.setCellValueFactory(new PropertyValueFactory<>("location"));
        appointmentType.setCellValueFactory(new PropertyValueFactory<>("type"));
        LoadAppointmentTableData();
        
        returnToCalendarScreen.setText("Calendar");
        returnToCalendarScreen.setPrefSize(80, 30);
        returnToCalendarScreen.setLayoutX(60);
        returnToCalendarScreen.setLayoutY(280);
        
        addAppointment.setText("Add");
        addAppointment.setPrefSize(80, 30);
        addAppointment.setLayoutX(160);
        addAppointment.setLayoutY(280);

        modifyAppointment.setText("Modify");
        modifyAppointment.setPrefSize(80, 30);
        modifyAppointment.setLayoutX(260);
        modifyAppointment.setLayoutY(280);

        deleteAppointment.setText("Delete");
        deleteAppointment.setPrefSize(80, 30);
        deleteAppointment.setLayoutX(360);
        deleteAppointment.setLayoutY(280);
    }    
        
    @FXML
    private void LoadAppointmentTableData(){
        appointmentsTable.setItems(DatabaseConnection.getAllAppointments()); 
    }
    
    @FXML
    private void appointmentsSearchButtonClick() {
        loadSearchAppointmentData(appointmentsSearchTextField.getText());
    }
    
    @FXML
    private void loadSearchAppointmentData(String searchCriteria){
        appointmentsTable.setItems(DatabaseConnection.getAllMatchingAppointmentTitles(searchCriteria));
    }
    
    @FXML
    private void addAppointment(ActionEvent event) throws IOException {
        Parent addPartWindow = FXMLLoader.load(getClass().getResource("/Views/AppointmentsScreen.fxml"));
        Scene scene = new Scene(addPartWindow);
        Stage stage = new Stage();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Add Appointment");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void modifyAppointment(ActionEvent event) throws IOException {
//        CustomerModel customerToModify = CustomerModel.lookupPart(customersTable.getSelectionModel().getSelectedItem().getCustomerName());//this getCustomerName needs to be fixed
//        _customerToModify = customerToModify.getCustomerName(); //also needs to be fixed
        ShowModifyCustomerWindow(event);
    }
    
    @FXML
    private void ShowModifyCustomerWindow(ActionEvent event) throws IOException{
        Parent modifyPartWindow = FXMLLoader.load(getClass().getResource("/Views/AppointmentsScreen.fxml"));
        Scene scene = new Scene(modifyPartWindow);
        Stage stage = new Stage();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Modify Appointment");
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
    private void deleteAppointment() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure you would like to delete this appointment?");
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
