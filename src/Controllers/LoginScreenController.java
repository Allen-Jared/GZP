package Controllers;

import DataModels.DatabaseConnection;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

public class LoginScreenController implements Initializable {
    private static String CurrentUser;
    public static String getCurrentUser() {
        return CurrentUser;
    }
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        header.setPrefSize(520, 10);
        header.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        header.setLayoutX(10);
        header.setLayoutY(10);
        header.setPadding(new Insets(5,5,5,5));
        
        Locale locale = Locale.getDefault();
        ResourceBundle resBun = ResourceBundle.getBundle("LanguageBundles", locale);
        location.setText(resBun.getString("location") + Locale.getDefault());//todo determine location
        location.setLayoutX(10);
        location.setLayoutY(10);
        location.setStyle("-fx-font-size: 10; -fx-text-fill: black");
        
        title.setText(resBun.getString("title"));
        title.setLayoutX(100);
        title.setLayoutY(10);
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-fill: midnightblue");
        title.setPadding(new Insets(10,10,10,10));
        
        body.setPrefSize(520, 10);
        body.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        body.setLayoutX(10);
        body.setLayoutY(110);
        body.setPadding(new Insets(5,5,5,5));
        
        login.setText(resBun.getString("login"));
        login.setLayoutX(110);
        login.setLayoutY(30);
        login.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-text-fill: midnightblue");
        
        username.setText(resBun.getString("username"));
        username.setLayoutX(110);
        username.setLayoutY(90);
        username.setStyle("-fx-font-weight: bold; -fx-font-size: 12; -fx-text-fill: midnightblue");
        
        usernameText.setPrefSize(160, 30);
        usernameText.setLayoutX(220);
        usernameText.setLayoutY(85);
        
        password.setText(resBun.getString("password"));
        password.setLayoutX(110);
        password.setLayoutY(150);
        password.setStyle("-fx-font-weight: bold; -fx-font-size: 12; -fx-text-fill: midnightblue");
        
        passwordText.setPrefSize(160, 30);
        passwordText.setLayoutX(220);
        passwordText.setLayoutY(145);
        
        loginButton.setText(resBun.getString("login"));
        loginButton.setPrefSize(100, 30);
        loginButton.setLayoutX(110);
        loginButton.setLayoutY(200);
    }
    
    @FXML
    private void loginButtonClick(ActionEvent event) throws IOException{
        ResourceBundle resBun = ResourceBundle.getBundle("LanguageBundles", Locale.getDefault());
        String username = usernameText.getText();
        String password = passwordText.getText();
        if(DatabaseConnection.VerifyUser(username, password)){
            CurrentUser = usernameText.getText();
            showCalendarScreen(event);
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText(resBun.getString("error"));
            alert.setHeaderText(null);
            alert.showAndWait();
        }

    }
    
    private void showCalendarScreen(ActionEvent event) throws IOException{
        Parent addProductWindow = FXMLLoader.load(getClass().getResource("/Views/CalendarScreen.fxml"));
        Scene scene = new Scene(addProductWindow);
        Stage stage = new Stage();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Calendar");
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}