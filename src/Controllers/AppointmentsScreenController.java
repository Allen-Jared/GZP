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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        InitializeWindow();
    }    
 
    @FXML 
    private void InitializeWindow() {
        addAppointmentLabel.setText("Add Appointment");
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
    }
    
    @FXML
    private void cancelClick(ActionEvent event) throws IOException{
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure you would like to cancel your changes?");
            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK)
                returnToCalendarScreen(event);
            else
                return;
    }
    
    private void returnToCalendarScreen(ActionEvent event) throws IOException{
        Parent mainWindow = FXMLLoader.load(getClass().getResource("/Views/CalendarScreen.fxml"));
        Scene scene = new Scene(mainWindow);
        Stage stage = new Stage();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Calendar");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void saveClick(ActionEvent event) throws IOException{
        returnToCalendarScreen(event);
    }   
    
}
