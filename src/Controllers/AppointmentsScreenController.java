package Controllers;

import DataModels.AddressModel;
import DataModels.AppointmentModel;
import DataModels.CityModel;
import DataModels.CustomerModel;
import DataModels.DatabaseConnection;
import DataModels.UserModel;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
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
    private Label dateLabel;
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
    private ChoiceBox dateChoiceBox;
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
        
        dateLabel.setText("Date");
        dateLabel.setLayoutX(40);
        dateLabel.setLayoutY(410);
        dateLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        dateChoiceBox.setLayoutX(120);
        dateChoiceBox.setLayoutY(410);
        ObservableList<String> dates = FXCollections.observableArrayList();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss.S"); 
        LocalDateTime ldt = LocalDateTime.now();  
        for(int i = 0; i < 30; i++){
            if(ldt.plusDays(i).getDayOfWeek().toString().equals("MONDAY")){
                dates.add(ldt.plusDays(i).format(df).substring(0, 10));
            }
            if(ldt.plusDays(i).getDayOfWeek().toString().equals("TUESDAY")){
                dates.add(ldt.plusDays(i).format(df).substring(0, 10));
            }
            if(ldt.plusDays(i).getDayOfWeek().toString().equals("WEDNESDAY")){
                dates.add(ldt.plusDays(i).format(df).substring(0, 10));
            }
            if(ldt.plusDays(i).getDayOfWeek().toString().equals("THURSDAY")){
                dates.add(ldt.plusDays(i).format(df).substring(0, 10));
            }
            if(ldt.plusDays(i).getDayOfWeek().toString().equals("FRIDAY")){
                dates.add(ldt.plusDays(i).format(df).substring(0, 10));
            }
        }
        dateChoiceBox.setItems(dates);
        dateChoiceBox.getSelectionModel().selectFirst();
        
        startTimeLabel.setText("Start Time");
        startTimeLabel.setLayoutX(40);
        startTimeLabel.setLayoutY(460);
        startTimeLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        startTimeChoiceBox.setLayoutX(120);
        startTimeChoiceBox.setLayoutY(460);
        ObservableList<String> times = FXCollections.observableArrayList();
        times.add("09:00:00.0");
        times.add("10:00:00.0");
        times.add("11:00:00.0");
        times.add("12:00:00.0");
        times.add("13:00:00.0");
        times.add("14:00:00.0");
        times.add("15:00:00.0");
        times.add("16:00:00.0");
        startTimeChoiceBox.setItems(times);
        startTimeChoiceBox.getSelectionModel().selectFirst();
        
        endTimeLabel.setText("End Time");
        endTimeLabel.setLayoutX(40);
        endTimeLabel.setLayoutY(510);
        endTimeLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 10; -fx-text-fill: black");
        
        endTimeLabelValue.setLayoutX(120);
        endTimeLabelValue.setLayoutY(510);
        
        save.setText("Save");
        save.setPrefSize(80, 30);
        save.setLayoutX(190);
        save.setLayoutY(560);
        
        cancel.setText("Cancel");
        cancel.setPrefSize(80, 30);
        cancel.setLayoutX(90);
        cancel.setLayoutY(560);
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
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss.S");
        String date = dateChoiceBox.getSelectionModel().getSelectedItem().toString();
        String time = startTimeChoiceBox.getSelectionModel().getSelectedItem().toString();
        LocalDateTime ldt = LocalDateTime.parse(String.join(" ", date, time), df);
        endTimeLabelValue.setText(ldt.plusHours(1).format(df));
    }
    
    
    @FXML
    private void cancelClick(ActionEvent event) throws IOException{
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure you would like to cancel your changes?");
            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK)
                returnToAppointmentScreen(event);
            else
                return;
    }
    
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
    private void saveClick(ActionEvent event) throws IOException{
        AppointmentModel appointment = new AppointmentModel();
        Date date = new Date();
        String startDate = dateChoiceBox.getSelectionModel().getSelectedItem().toString();
        String startTime = startTimeChoiceBox.getSelectionModel().getSelectedItem().toString();
        
        appointment.setCustomerId(DatabaseConnection.getCustomerIdByCustomerName(customerChoiceBox.getSelectionModel().getSelectedItem().toString()));
        appointment.setUserId(DatabaseConnection.getUserIdByUsername(contactChoiceBox.getSelectionModel().getSelectedItem().toString()));
        appointment.setTitle(titleText.getText());
        appointment.setDescription(descriptionText.getText());
        appointment.setLocation(locationText.getText());
        appointment.setContact(contactChoiceBox.getSelectionModel().getSelectedItem().toString());
        appointment.setType(typeText.getText());
        appointment.setUrl(urlText.getText());
        appointment.setStart(DateHelper.convertLocalDateToUtcTimestamp(String.join(" ", startDate, startTime)));
        appointment.setEnd(DateHelper.convertLocalDateToUtcTimestamp(endTimeLabelValue.getText()));
        appointment.setCreateDate(DateHelper.convertLocalDateToUtcTimestamp(DateHelper.convertDateToCorrectFormatString(LocalDateTime.now())));
        appointment.setCreatedBy(LoginScreenController.getCurrentUser());
        appointment.setLastUpdate(DateHelper.convertLocalDateToUtcTimestamp(DateHelper.convertDateToCorrectFormatString(LocalDateTime.now())));
        appointment.setLastUpdateBy(LoginScreenController.getCurrentUser());
        DatabaseConnection.insertNewAppointment(appointment);
        returnToAppointmentScreen(event);
    }
}
