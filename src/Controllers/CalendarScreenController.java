/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

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
  
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        header.setPrefSize(10, 10);
        header.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        header.setLayoutX(10);
        header.setLayoutY(10);
        header.setPadding(new Insets(5,5,5,5));
        
        location.setText("Location: " + "");//todo determine location
        location.setLayoutX(10);
        location.setLayoutY(10);
        location.setStyle("-fx-font-size: 10; -fx-text-fill: black");
        
        title.setText("Customer Scheduling");
        title.setLayoutX(175);
        title.setLayoutY(10);
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
        logoutButton.setLayoutX(500);
        logoutButton.setLayoutY(55);
    }
    
    @FXML
    private void customersButtonClick(){
        
    }

    @FXML
    private void appointmentsButtonClick(){
        
    }
    
    @FXML
    private void logoutButtonClick(){
        
    } 
}
