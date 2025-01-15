package com.example.bouncing_dvd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.io.IOException;

public class HelloApplication extends Application {
    double xspeed=3; //horizontal speed
    double yspeed=3; //vertical speed

    @Override
    public void start(Stage stage) throws IOException {
        Pane root=new Pane();
        Scene scene=new Scene(root,800,600, Color.BLACK);
        ImageView dvd = new ImageView("dvdd.png");
        dvd.setFitWidth(200);
        dvd.setFitHeight(100);
        root.getChildren().add(dvd);

//      timeline class to create animations that run over time.
// keyframe determine what happens at a specific time
        Timeline timeline=new Timeline(new KeyFrame(Duration.millis(10),e ->{
            //Move the image
            dvd.setX(dvd.getX()+xspeed); //we set the new x by getting the previous x and adding the speed (3pxs here)
            dvd.setY(dvd.getY()+yspeed);

            //check the boundary
            if (dvd.getX()<=0 || dvd.getX()+dvd.getFitWidth() >= scene.getWidth()){
                xspeed=-xspeed;
            }
            if(dvd.getY()<=0 || dvd.getY()+dvd.getFitHeight() >= scene.getHeight()){
                yspeed=-yspeed;
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play(); //to play the animation
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}