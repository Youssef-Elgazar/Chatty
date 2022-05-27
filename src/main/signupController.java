package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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


    PreparedStatement ps,ps1;

    @FXML
    private Button closeBtn;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField usernameTxt;

    @FXML
    private PasswordField passwordTxt;




    @FXML
    private Button createBtn;

    @FXML
    private Label errorMessage;


    @FXML
    void register(ActionEvent event) throws IOException {
        dbconnect connect = new dbconnect();

        try{

            Connection con = connect.getconnection();

            String username = usernameTxt.getText().trim();
            String password = passwordTxt.getText().trim();
            String name = nameTxt.getText().trim();

            if(username.isEmpty() || password.isEmpty() || name.isEmpty()){
                errorMessage.setText("Please complete all the fills");
            }
            else {
                if (password.length()<6){
                    errorMessage.setText("Password is too weak, please choose atleast 6 characters");
                }

                else {

                    String sql = "select * from useraccounts where username = ?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, username);

                    ResultSet rs = ps.executeQuery();
                    if(rs.next()){
                        errorMessage.setText("Username already taken, please try another username");
                    }

                    else{

                        String sql2 = "insert into useraccounts (username, password, name) values(?,?,?)";
                        ps = con.prepareStatement(sql2);

                        ps.setString(1, usernameTxt.getText().trim());
                        ps.setString(2, passwordTxt.getText().trim());
                        ps.setString(3, nameTxt.getText().trim());
                        ps.execute();

                        errorMessage.setText("Account successfully registered");

                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("error" + e);
        }
    }


}











//    @FXML
//    private TextField usertxt;
//
//    @FXML
//    private TextField name;
//
//    @FXML
//    private TextField pass;
//
//
//
//
//
//    public void signupOnAction(ActionEvent event) throws IOException {
//        Parent view3 = FXMLLoader.load(getClass().getResource("signup.fxml"));
//        Scene scene3 = new Scene(view3);
//        Stage window = new Stage();
//        window.setScene(scene3);
//        window.show();
//    }
//    @FXML
//private Button cancelButton;
//    public void cancelButtononAction(ActionEvent event){
//        Stage stage = (Stage) cancelButton.getScene().getWindow();
//        stage.close();
//    }
//
//
// @FXML
//    private Button Sign;
//    void register(ActionEvent event) throws IOException {
//        dbconnect connect = new dbconnect();
//
//        try{
//
//            Connection con = connect.getconnection();
//            String Personname = name.getText().trim();
//            String Username = usertxt.getText().trim();
//            String UserPassword = pass.getText().trim();
//
//
//            if( Personname.isEmpty()||Username.isEmpty() || UserPassword.isEmpty() ){
//                //    errorMessage.setText("Please complete all the fills");
//            }
//            else {
//                if (UserPassword.length()<6){
//                    //     errorMessage.setText("Password is too weak, please choose atleast 6 characters");
//                }
//
//                else {
//
//                    String sql = "select * from userinfo where Username = ?";
//                    PreparedStatement ps = con.prepareStatement(sql);
//                    ps.setString(1, Username);
//
//                    ResultSet rs = ps.executeQuery();
//                    if(rs.next()){
//                        //  errorMessage.setText("Username already taken, please try another username");
//                    }
//
//                    else{
//
//                        String sql2 = "insert into userinfo (Personname,Username,UserPassword ) values(?,?,?)";
//                        ps = con.prepareStatement(sql2);
//                        ps.setString(3, name.getText().trim());
//                        ps.setString(1, usertxt.getText().trim());
//                        ps.setString(2, pass.getText().trim());
//                        ps.execute();
//
//                        // errorMessage.setText("Account successfully registered");
//
//                    }
//                }
//            }
//        }
//        catch(Exception e)
//        {
//            System.out.println("error" + e);
//        }
//
//    }
//}
