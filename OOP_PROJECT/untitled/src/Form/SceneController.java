package Form;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FORM.fxml"));
        Stage stage = new Stage();
        stage.setTitle("HomePage");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void switchToScene2(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Sign_up.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Sign up");
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void switchToScene3(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Log_in.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Log in");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
