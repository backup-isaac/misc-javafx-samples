/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc3d;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
 
public class Misc3d extends Application {
 
    /**
     * Java main for when running without JavaFX launcher
     * @param args the command line arguments (use default- application will not launch if arguments are changed)
     */
    public static void main(String[] args) {
        launch(args);
    }

    public Parent createContent() throws Exception {
 
        // Box
        Sphere testBox = new Sphere(2.5);
        testBox.setMaterial(new PhongMaterial(Color.RED));
 
        // Create and position camera
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll (
                new Rotate(-20, Rotate.Y_AXIS),
                new Rotate(-20, Rotate.X_AXIS),
                new Translate(0, 0, -15));
 
        // Build the Scene Graph
        Group root = new Group();       
        root.getChildren().add(camera);
        root.getChildren().add(testBox);
        
        // Use a SubScene       
        SubScene subScene = new SubScene(root, 300,300);
        subScene.setFill(Color.ALICEBLUE);
        subScene.setCamera(camera);
        Group group = new Group();
        group.getChildren().add(subScene);
        return group;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        Scene scene = new Scene(createContent());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}