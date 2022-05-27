package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class signupController {
  @FXML
  private Button Signup;

  public void signupOnAction(ActionEvent event) throws IOException {
    Parent view3 = FXMLLoader.load(getClass().getResource("signup.fxml"));
    Scene scene3 = new Scene(view3);
    Stage window = new Stage();
    window.setScene(scene3);
    window.show();
  }
}
