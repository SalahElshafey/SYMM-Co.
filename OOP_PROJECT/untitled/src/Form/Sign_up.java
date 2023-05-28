package Form;

import com.sun.applet2.preloader.event.ConfigEvent;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Sign_up implements Initializable {
    @FXML
    private Button button;
    @FXML
    private ImageView imageView;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ChoiceBox<String> myChoiceBox;
    @FXML
    private String[] user = {"Client","Seller"};
    @FXML
    private Circle circle;
    @FXML
    private Button closeButton;
    @FXML
    private void handleButtonClick(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            try {
                BufferedImage bufferedImage = ImageIO.read(selectedFile);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                circle.setFill(new ImagePattern(image));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void validateEmail(javafx.scene.input.KeyEvent event) {
        String enteredText = emailTextField.getText();
        if (!enteredText.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            emailTextField.setStyle("-fx-border-color: red;");
        } else {
            emailTextField.setStyle(null);
        }
    }
    @FXML
    private void validateName(javafx.scene.input.KeyEvent event) {
        String enteredText = nameTextField.getText();
        if (!enteredText.matches("[a-zA-Z]+")) {
            nameTextField.setStyle("-fx-border-color: red;");
        } else {
            nameTextField.setStyle(null);
        }
    }
    @FXML
    private void validateAddress() {
        String enteredAddress = addressTextField.getText();
    }
    @FXML
    private void validatePhoneNum() {
        phoneNumberTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\+?\\d{0,12}")) {
                phoneNumberTextField.setText(oldValue);
            }
        });
    }
    @FXML
    private void Pass() {
        String password = passwordField.getText();
    }
    @FXML
    private void Birth(){
        LocalDate selectedDate = datePicker.getValue();
    }
    @FXML
    public void initialize(URL arg0, ResourceBundle arg1){
        Image img = new Image("/Form/profile-placeholder.jpg");
        circle.setFill(new ImagePattern(img));
        myChoiceBox.getItems().addAll(user);
        String myUser = myChoiceBox.getValue();
    }
    @FXML
    private void closeForm(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
