/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DataModels.AppointmentModel;
import DataModels.DatabaseConnection;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jared_allen
 */
public class CalendarScreenController implements Initializable {
    @FXML
    private AnchorPane header;
    @FXML
    private Label location;
    @FXML
    private Label title;
    @FXML
    private Button customersButton;
    @FXML
    private Button appointmentsButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Pane calendarPane;
    @FXML
    private RadioButton weeklyView;
    @FXML
    private RadioButton monthlyView;  
    @FXML
    private TableView<AppointmentModel> calendarTable;
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
    private Label monthlyAppointmentsLabel;
    @FXML
    private Button monthlyAppointments;
    @FXML
    private Label consultantScheduelLabel;
    @FXML
    private Button consultantScheduel;
    @FXML
    private Label customerReportLabel;
    @FXML
    private Button customerReport;
  
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        header.setPrefSize(10, 10);
        header.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        header.setLayoutX(10);
        header.setLayoutY(10);
        header.setPadding(new Insets(5,5,5,5));
        
        title.setText("Customer Scheduling Calendar");
        title.setLayoutX(20);
        title.setLayoutY(8);
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-fill: midnightblue");
        
        customersButton.setText("Customers");
        customersButton.setPrefSize(100, 30);
        customersButton.setLayoutX(10);
        customersButton.setLayoutY(55);
        
        appointmentsButton.setText("Appointments");
        appointmentsButton.setPrefSize(100, 30);
        appointmentsButton.setLayoutX(120);
        appointmentsButton.setLayoutY(55);
        
        logoutButton.setText("Logout");
        logoutButton.setPrefSize(100, 30);
        logoutButton.setLayoutX(363);
        logoutButton.setLayoutY(55);
        
        calendarPane.setPrefSize(475, 350);
        calendarPane.setLayoutX(10);
        calendarPane.setLayoutY(120);
        calendarPane.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        
        weeklyView.setText("Weekly");
        weeklyView.setPrefSize(90, 10);
        weeklyView.setLayoutX(150);
        weeklyView.setLayoutY(25);
        
        monthlyView.setText("Monthly");
        monthlyView.setPrefSize(90, 10);
        monthlyView.setLayoutX(250);
        monthlyView.setLayoutY(25);
        
        ToggleGroup toggleGroup = new ToggleGroup();
        weeklyView.setToggleGroup(toggleGroup);
        monthlyView.setToggleGroup(toggleGroup);
        toggleGroup.selectToggle(weeklyView);
        
        calendarTable.setPrefSize(400, 200);
        calendarTable.setLayoutX(40);
        calendarTable.setLayoutY(65);
        calendarTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                
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
        loadWeeklyView();
        
        monthlyAppointmentsLabel.setText("Monthly Appointments");
        monthlyAppointmentsLabel.setLayoutX(20);
        monthlyAppointmentsLabel.setLayoutY(280);
        monthlyAppointmentsLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 12; -fx-text-fill: midnightblue");
        
        monthlyAppointments.setText("Report");
        monthlyAppointments.setPrefSize(80, 30);
        monthlyAppointments.setLayoutX(20);
        monthlyAppointments.setLayoutY(300);
        
        consultantScheduelLabel.setText("Consultant Schedules");
        consultantScheduelLabel.setLayoutX(200);
        consultantScheduelLabel.setLayoutY(280);
        consultantScheduelLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 12; -fx-text-fill: midnightblue");
        
        consultantScheduel.setText("Report");
        consultantScheduel.setPrefSize(80, 30);
        consultantScheduel.setLayoutX(200);
        consultantScheduel.setLayoutY(300);
        
        customerReportLabel.setText("All Customers");
        customerReportLabel.setLayoutX(350);
        customerReportLabel.setLayoutY(280);
        customerReportLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 12; -fx-text-fill: midnightblue");
        
        customerReport.setText("Report");
        customerReport.setPrefSize(80, 30);
        customerReport.setLayoutX(350);
        customerReport.setLayoutY(300);
    }
    
    @FXML
    private void customersButtonClick(ActionEvent event) throws IOException{
        Parent addProductWindow = FXMLLoader.load(getClass().getResource("/Views/CustomersScreen.fxml"));
        Scene scene = new Scene(addProductWindow);
        Stage stage = new Stage();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Customer Records");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void appointmentsButtonClick(ActionEvent event) throws IOException{
        Parent addProductWindow = FXMLLoader.load(getClass().getResource("/Views/AddAppointmentScreen.fxml"));
        Scene scene = new Scene(addProductWindow);
        Stage stage = new Stage();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Appointments");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void logoutButtonClick(ActionEvent event) throws IOException{
        ResourceBundle resBun = ResourceBundle.getBundle("LanguageBundles", Locale.getDefault());
        Parent addProductWindow = FXMLLoader.load(getClass().getResource("/Views/LoginScreen.fxml"));
        Scene scene = new Scene(addProductWindow);
        Stage stage = new Stage();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle(resBun.getString("title"));
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    } 
    
    @FXML
    private void weeklyViewClick(ActionEvent event) throws IOException{
        loadWeeklyView();
    } 
    
    @FXML
    private void loadWeeklyView(){
        ObservableList<AppointmentModel> appointments = DatabaseConnection.getWeeklyCalendarView();
        calendarTable.setItems(appointments);
    }
    
    @FXML
    private void monthlyViewClick(ActionEvent event) throws IOException{
        ObservableList<AppointmentModel> appointments = DatabaseConnection.getMonthlyCalendarView();
        calendarTable.setItems(appointments);
    } 
    
    @FXML
    private void monthlyAppointmentsClick(ActionEvent event) throws IOException{
    } 
    
    @FXML
    private void consultantScheduelClick(ActionEvent event) throws IOException{
    } 
    
    @FXML
    private void customerReportClick(ActionEvent event) throws IOException{
    } 
}
