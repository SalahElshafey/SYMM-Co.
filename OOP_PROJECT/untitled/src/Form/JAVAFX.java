package Form;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class JAVAFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        //1920 x 1000
        try {
            Parent loader = FXMLLoader.load(getClass().getResource("FORM.fxml"));

            Scene scene = new Scene(loader);
            stage.setScene(scene);
            stage.setTitle("Home Page");
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
