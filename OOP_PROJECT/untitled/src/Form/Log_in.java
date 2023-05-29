package Form;

import javafx.animation.*;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.ActionEvent;


public class Log_in{
    @FXML
    private Label label;
    @FXML
    private ImageView image;

    private RotateTransition rotateTransition;
    @FXML
    private HostServices hostServices;
    @FXML
    private Button loginButton;
    @FXML
    private void handleMouseEntered1(MouseEvent event) {
        if (rotateTransition == null) {
            rotateTransition = new RotateTransition(Duration.seconds(0.5f), image);
            rotateTransition.setByAngle(360);
            rotateTransition.setAutoReverse(false);
        }
        rotateTransition.play();
    }
    @FXML
    private void startShake_button(MouseEvent mouseEvent) {
        Button button = (Button) mouseEvent.getSource(); // Get the text field that triggered the event

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(0), new KeyValue(button.translateXProperty(), 0)),
                new KeyFrame(Duration.millis(100), new KeyValue(button.translateXProperty(), -5)),
                new KeyFrame(Duration.millis(200), new KeyValue(button.translateXProperty(), 5)),
                new KeyFrame(Duration.millis(300), new KeyValue(button.translateXProperty(), -5)),
                new KeyFrame(Duration.millis(400), new KeyValue(button.translateXProperty(), 5)),
                new KeyFrame(Duration.millis(500), new KeyValue(button.translateXProperty(), 0))
        );
        timeline.play();
    }
    @FXML
    private void startShake_text(MouseEvent mouseEvent) {
        TextField textField = (TextField) mouseEvent.getSource(); // Get the text field that triggered the event

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(0), new KeyValue(textField.translateXProperty(), 0)),
                new KeyFrame(Duration.millis(100), new KeyValue(textField.translateXProperty(), -5)),
                new KeyFrame(Duration.millis(200), new KeyValue(textField.translateXProperty(), 5)),
                new KeyFrame(Duration.millis(300), new KeyValue(textField.translateXProperty(), -5)),
                new KeyFrame(Duration.millis(400), new KeyValue(textField.translateXProperty(), 5)),
                new KeyFrame(Duration.millis(500), new KeyValue(textField.translateXProperty(), 0))
        );
        timeline.play();
    }
    @FXML
    private void handleMouseEntered(MouseEvent event) {
        // Create a translate transition to move the label's characters vertically
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(200), label);
        translateTransition.setFromY(0);
        translateTransition.setToY(-20);
        translateTransition.setCycleCount(2);
        translateTransition.setAutoReverse(true);

        // Create a pause transition to pause the animation for a short duration
        PauseTransition pauseTransition = new PauseTransition(Duration.millis(200));

        // Combine the translate and pause transitions into a sequential transition
        Animation animation = new SequentialTransition(translateTransition, pauseTransition);

        // Play the animation
        animation.play();
    }

    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices;
    }

    @FXML
    private void handleLoginButtonAction(MouseEvent mouseEvent) {
        String loginUrl = "https://www.facebook.com/v13.0/dialog/oauth?client_id=<YOUR_APP_ID>&redirect_uri=<YOUR_REDIRECT_URL>&response_type=code";
        hostServices.showDocument(loginUrl);
    }

}
