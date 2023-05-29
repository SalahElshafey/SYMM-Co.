package Form;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class SceneController {
    private RotateTransition rotateTransition;
    @FXML
    private ImageView image;
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
    private void handleMouseEntered1(MouseEvent event) {
        if (rotateTransition == null) {
            rotateTransition = new RotateTransition(Duration.seconds(0.5f), image);
            rotateTransition.setByAngle(360);
            rotateTransition.setAutoReverse(false);
        }
        rotateTransition.play();
    }
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("side_view.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage sideViewStage = new Stage();
            sideViewStage.initStyle(StageStyle.UNDECORATED);
            sideViewStage.setX(-10);
            sideViewStage.setY(0);
            sideViewStage.setScene(new Scene(root));
            root.setOnMouseExited(e -> sideViewStage.close());
            // Show the stage
            sideViewStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
