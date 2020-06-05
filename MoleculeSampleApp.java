/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moleculesampleapp;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

/**
 * @author IsaacWeintraub
 */
public class MoleculeSampleApp extends Application {
    final Group root = new Group();
    final Xform axisGroup = new Xform();
    final Xform moleculeGroup = new Xform();
    final Xform world = new Xform();
    final PerspectiveCamera camera = new PerspectiveCamera(true);
    final Xform cameraXform = new Xform();
    final Xform cameraXform2 = new Xform();
    final Xform cameraXform3 = new Xform();
    private static final double CID = -450;
    private static final double CIX = 70;
    private static final double CIY = 320;
    private static final double CNC = 0.1;
    private static final double CFC = 10_000;
    private static final double AXIS = 250;
    @Override
    @SuppressWarnings("empty-statement")
    public void start(Stage primaryStage) {
        buildCamera();
        buildAxes();
        Scene scene = new Scene(root,1024,768,true);
        scene.setFill(Color.GREY);
        primaryStage.setTitle("Molecule Sample Application");
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.setCamera(camera);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    private void buildCamera() {
        root.getChildren().add(cameraXform);
        cameraXform.getChildren().add(cameraXform2);
        cameraXform2.getChildren().add(cameraXform3);
        cameraXform3.getChildren().add(camera);
        cameraXform3.setRotateZ(180);
        camera.setNearClip(CNC);
        camera.setFarClip(CFC);
        camera.setTranslateZ(CID);
        cameraXform.ry.setAngle(CIY);
        cameraXform.rx.setAngle(CIX);
    }
    private void buildAxes() {
        final PhongMaterial REDMATERIAL = new PhongMaterial();
        REDMATERIAL.setDiffuseColor(Color.DARKRED);
        REDMATERIAL.setSpecularColor(Color.RED);
        final PhongMaterial GREENMATERIAL = new PhongMaterial();
        GREENMATERIAL.setDiffuseColor(Color.DARKGREEN);
        GREENMATERIAL.setSpecularColor(Color.GREEN);
        final PhongMaterial BLUEMATERIAL = new PhongMaterial();
        BLUEMATERIAL.setDiffuseColor(Color.DARKBLUE);
        BLUEMATERIAL.setSpecularColor(Color.BLUE);
        final Box xAxis = new Box(AXIS,1,1);
        final Box yAxis = new Box(1,AXIS,1);
        final Box zAxis = new Box(1,1,AXIS);
        xAxis.setMaterial(REDMATERIAL);
        yAxis.setMaterial(GREENMATERIAL);
        zAxis.setMaterial(BLUEMATERIAL);
        axisGroup.getChildren().addAll(xAxis,yAxis,zAxis);
        axisGroup.setVisible(true);
        world.getChildren().addAll(axisGroup);
    }
}