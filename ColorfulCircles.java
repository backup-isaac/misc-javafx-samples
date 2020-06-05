/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorfulcircles;

import static java.lang.Math.random;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;

/**
 *
 * @author IsaacWeintraub
 */
public class ColorfulCircles extends javafx.application.Application {
    
    @Override
    @SuppressWarnings("deprecation")
    public void start(javafx.stage.Stage primaryStage) {
        javafx.scene.Group root = new Group();
        javafx.scene.Scene scene = new Scene(root,ColorfulCircles.getScreenWidth(),ColorfulCircles.getScreenHeight(),javafx.scene.paint.Color.BLACK);
        primaryStage.setScene(scene);
        javafx.scene.Group circles = new Group();
        for(int i = 0; i < 21; i++) {
            javafx.scene.shape.Rectangle circle = new javafx.scene.shape.Rectangle(150,150, javafx.scene.paint.Color.web("white",0.1));
            circle.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            circle.setStroke(javafx.scene.paint.Color.web("white",0.21));
            circle.setStrokeWidth(4);
            circles.getChildren().add(circle);
            circles.setEffect(new javafx.scene.effect.BoxBlur(10,10,3));
        }
        javafx.scene.shape.Rectangle colors = new javafx.scene.shape.Rectangle(scene.getWidth(), scene.getHeight(), 
            new javafx.scene.paint.LinearGradient(0f, 0f, 1f, 0f, true, javafx.scene.paint.CycleMethod.NO_CYCLE, new javafx.scene.paint.Stop[]{
                new javafx.scene.paint.Stop(0, new javafx.scene.paint.Color(1.0,0,0,1.0)), 
                new javafx.scene.paint.Stop(0.0833, new javafx.scene.paint.Color(1.0,0.5,0,1.0)),
                new javafx.scene.paint.Stop(0.1667, new javafx.scene.paint.Color(1.0,1,0,1.0)),
                new javafx.scene.paint.Stop(0.25, new javafx.scene.paint.Color(0.5,1,0,1.0)),
                new javafx.scene.paint.Stop(0.3333, new javafx.scene.paint.Color(0,1,0,1.0)), 
                new javafx.scene.paint.Stop(0.4167, new javafx.scene.paint.Color(0,1,0.5,1.0)),
                new javafx.scene.paint.Stop(0.5, new javafx.scene.paint.Color(0,1,1,1.0)),
                new javafx.scene.paint.Stop(0.5833, new javafx.scene.paint.Color(0,0.5,1,1.0)),
                new javafx.scene.paint.Stop(0.6667, new javafx.scene.paint.Color(0,0,1,1.0)), 
                new javafx.scene.paint.Stop(0.75, new javafx.scene.paint.Color(0.5,0,1,1.0)),
                new javafx.scene.paint.Stop(0.8333, new javafx.scene.paint.Color(1.0,0,1,1.0)),
                new javafx.scene.paint.Stop(0.9167, new javafx.scene.paint.Color(1.0,0,0.5,1.0)),
                new javafx.scene.paint.Stop(1, new javafx.scene.paint.Color(1.0,0,0,1.0))
            }));
        colors.widthProperty().bind(scene.widthProperty());
        colors.heightProperty().bind(scene.heightProperty());
        javafx.scene.Group blendModeGroup = new Group(
            new Group(
                new javafx.scene.shape.Rectangle(scene.getWidth(), scene.getHeight(),javafx.scene.paint.Color.BLACK), 
            circles), 
        colors);
        colors.setBlendMode(javafx.scene.effect.BlendMode.OVERLAY);
        root.getChildren().add(blendModeGroup);
        javafx.animation.Timeline timeline = new Timeline();
        for (javafx.scene.Node circle: circles.getChildren()) {
            timeline.getKeyFrames().addAll(
                new javafx.animation.KeyFrame(javafx.util.Duration.ZERO, 
                    new javafx.animation.KeyValue(circle.translateXProperty(), random() * 1_280),
                    new javafx.animation.KeyValue(circle.translateYProperty(), random() * 800)),
                new javafx.animation.KeyFrame(new javafx.util.Duration(40_000),
                    new javafx.animation.KeyValue(circle.translateXProperty(), random() * 1_280),
                    new javafx.animation.KeyValue(circle.translateYProperty(), random() * 800)),
                new javafx.animation.KeyFrame(new javafx.util.Duration(80_000),
                    new javafx.animation.KeyValue(circle.translateXProperty(), random() * 1_280),
                    new javafx.animation.KeyValue(circle.translateYProperty(), random() * 800)),
                new javafx.animation.KeyFrame(new javafx.util.Duration(120_000),
                    new javafx.animation.KeyValue(circle.translateXProperty(), random() * 1_280),
                    new javafx.animation.KeyValue(circle.translateYProperty(), random() * 800)),
                new javafx.animation.KeyFrame(new javafx.util.Duration(160_000),
                    new javafx.animation.KeyValue(circle.translateXProperty(), random() * 1_280),
                    new javafx.animation.KeyValue(circle.translateYProperty(), random() * 800)),
                new javafx.animation.KeyFrame(new javafx.util.Duration(200_000),
                    new javafx.animation.KeyValue(circle.translateXProperty(), random() * 1_280),
                    new javafx.animation.KeyValue(circle.translateYProperty(), random() * 800)),
                new javafx.animation.KeyFrame(new javafx.util.Duration(240_000),
                    new javafx.animation.KeyValue(circle.translateXProperty(), random() * 1_280),
                    new javafx.animation.KeyValue(circle.translateYProperty(), random() * 800)),
                new javafx.animation.KeyFrame(new javafx.util.Duration(280_000),
                    new javafx.animation.KeyValue(circle.translateXProperty(), random() * 1_280),
                    new javafx.animation.KeyValue(circle.translateYProperty(), random() * 800)));
        }
        timeline.play();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments (use default otherwise the application cannot be launched)
     */
    public static void main(java.lang.String[] args) {
        launch(args);
        java.lang.System.exit(0);
    }
    public static double getScreenWidth() {
        return java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    }
    public static double getScreenHeight() {
        return java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    }
}
