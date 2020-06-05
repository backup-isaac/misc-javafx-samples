/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField; 
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        Scene scene = new Scene(grid,300,275);
        primaryStage.setScene(scene);
        Text title = new Text("Welcome");
        title.setId("welcome");
        grid.add(title,0,0,2,1);
        Label userName = new Label("User name:");
        grid.add(userName,0,1);
        TextField utf = new TextField();
        grid.add(utf,1,1);
        Label pass = new Label("Password:");
        grid.add(pass,0,2);
        PasswordField pbox = new PasswordField();
        grid.add(pbox,1,2);
        Button btn = new Button("Sign in");
        HBox hbtn = new HBox(10);
        hbtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbtn.getChildren().add(btn);
        grid.add(hbtn,1,4);
        final Text target = new Text();
        grid.add(target,1,6);
        target.setId("target");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                target.setText("Sign in button pressèd");
            }
        });
        scene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}