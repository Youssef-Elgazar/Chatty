package main;
<<<<<<< Updated upstream
=======
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextField;
        import javafx.scene.layout.Pane;
        import javafx.stage.Stage;
        import javafx.event.ActionEvent;
        import main.dbconnect;

        import javax.swing.*;
        import java.io.IOException;
        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
>>>>>>> Stashed changes

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

<<<<<<< Updated upstream
  public void login(ActionEvent event) {
    System.out.println(usertxt.getText());
    System.out.println(pass.getText());

  }
=======
    public void cancelButtononAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    void login(ActionEvent event) throws IOException {
        dbconnect connect = new dbconnect();
        try {
            Connection con = connect.getconnection();

            String username = usertxt.getText().trim();
            String password = pass.getText().trim();

            if(username.isEmpty() || password.isEmpty()){
                errorMsg.setText("Please insert username and password");
            }
            else
            {

                PreparedStatement ps = con.prepareStatement("select * from useraccounts where username=?"
                        + " and password=?");

                ps.setString(1,usertxt.getText().trim() );
                ps.setString(2, pass.getText().trim());

                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    FXMLLoader fmxlLoader = new FXMLLoader(getClass().getResource("/views/ChatView.fxml"));
                    Parent window = (Pane) fmxlLoader.load();
                    con2 = fmxlLoader.<ChatController>getController();
                    Listener listener = new Listener(username, con2);
                    Thread x = new Thread(listener);
                    x.start();
                    this.scene = new Scene(window);
                }

                else {
                    errorMsg.setText("Invalid credentials. Please try again");
                }
            }
        }
        catch(Exception ex){
            System.out.println("error" + ex.toString());
        }
>>>>>>> Stashed changes

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
