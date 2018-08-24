package Controllers;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jared_allen
 */
public class LoginScreenFrenchController implements Initializable {

    @FXML
    private AnchorPane header;
    @FXML
    private Label location;
    @FXML
    private Label title;
    @FXML
    private AnchorPane body;
    @FXML
    private Label login;
    @FXML
    private Label username;
    @FXML
    private TextField usernameText;
    @FXML
    private Label password;
    @FXML
    private TextField passwordText;
    @FXML
    private Button loginButton;
    @FXML
    private Label languageLabel;
    @FXML
    private ComboBox<String> languages;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        header.setPrefSize(10, 10);
        header.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        header.setLayoutX(10);
        header.setLayoutY(10);
        header.setPadding(new Insets(5,5,5,5));
        
        location.setText("Emplacement: " + "");//todo determine location
        location.setLayoutX(10);
        location.setLayoutY(10);
        location.setStyle("-fx-font-size: 10; -fx-text-fill: black");
        
        title.setText("Programmation du client");
        title.setLayoutX(175);
        title.setLayoutY(10);
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-fill: midnightblue");
        title.setPadding(new Insets(10,114,10,10));
        
        body.setPrefSize(10, 10);
        body.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        body.setLayoutX(10);
        body.setLayoutY(110);
        body.setPadding(new Insets(5,5,5,5));
        
        login.setText("S'identifier:");
        login.setLayoutX(190);
        login.setLayoutY(30);
        login.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-fill: midnightblue");
        
        username.setText("Nom d'utilisateur:");
        username.setLayoutX(190);
        username.setLayoutY(90);
        username.setStyle("-fx-font-weight: bold; -fx-font-size: 12; -fx-text-fill: midnightblue");
        
        usernameText.setPrefSize(160, 30);
        usernameText.setLayoutX(255);
        usernameText.setLayoutY(85);
        
        password.setText(" Mot de passe:");
        password.setLayoutX(190);
        password.setLayoutY(150);
        password.setStyle("-fx-font-weight: bold; -fx-font-size: 12; -fx-text-fill: midnightblue");
        
        passwordText.setPrefSize(160, 30);
        passwordText.setLayoutX(255);
        passwordText.setLayoutY(145);
        
        loginButton.setText("S'identifier");
        loginButton.setPrefSize(100, 30);
        loginButton.setLayoutX(190);
        loginButton.setLayoutY(200);
        
        languageLabel.setText("La langue:");
        languageLabel.setLayoutX(435);
        languageLabel.setLayoutY(15);
        languageLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 12; -fx-text-fill: midnightblue");
        
        ObservableList<String> options = FXCollections.observableArrayList("English", "French");
        languages.setItems(options);
        languages.setPrefSize(100, 30);
        languages.setLayoutX(500);
        languages.setLayoutY(10);
    }
    
    @FXML
    private void loginButtonClick(ActionEvent event) throws IOException{
        Parent addProductWindow = FXMLLoader.load(getClass().getResource("/Views/CalendarScreen.fxml"));
        Scene scene = new Scene(addProductWindow);
        Stage stage = new Stage();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Modify Product");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
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
