
package gzp;

import DataModels.DatabaseConnection;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GZP extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/LoginScreen.fxml"));
        ResourceBundle resBun = ResourceBundle.getBundle("LanguageBundles", Locale.getDefault());
        
        Scene scene = new Scene(root);
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setTitle(resBun.getString("title"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.FRANCE);
        DatabaseConnection.SetupConnection();
        launch(args);
    }
    
}
