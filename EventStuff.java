/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventstuff;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *
 * @author IsaacWeintraub
 */
public class EventStuff extends Application {
    
    @Override
    @SuppressWarnings("deprecation")
    public void start(Stage primaryStage) {
        Circle circ = new Circle(100,Color.web("#008fff"));
        StackPane root = new StackPane();
        root.getChildren().add(circ);
        Text txt = new Text("Free Candy");
        txt.setFont(new Font("Arial",25));
        txt.setFill(Color.CRIMSON);
        root.getChildren().add(txt);
        Scene scene = new Scene(root, 300, 250);
        circ.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Paint p = circ.getFill();
                circ.setFill(txt.getFill());
                txt.setFill(p);
                if(Math.random() > 0.5)
                    Platform.exit();
            } 
        });
        txt.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Paint p = circ.getFill();
                circ.setFill(txt.getFill());
                txt.setFill(p);
                if(Math.random() > 0.5)
                    Platform.exit();
            } 
        });
        primaryStage.setTitle("NO T_A VirUS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
