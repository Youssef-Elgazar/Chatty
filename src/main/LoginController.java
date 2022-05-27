package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

  @FXML
  private TextField usertxt;

  @FXML
  private TextField pass;

  @FXML
  private Button cancelButton;

  @FXML
  private Button login;


  public void cancelButtononAction(ActionEvent event) {
    Stage stage = (Stage) cancelButton.getScene().getWindow();
    stage.close();
  }

  public void login(ActionEvent event) {
    System.out.println(usertxt.getText());
    System.out.println(pass.getText());

  }

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
