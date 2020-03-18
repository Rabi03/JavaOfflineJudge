package sample;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
    Stage stage;
    private Object task;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stage=primaryStage;
        firstScreen();
    }
    public void firstScreen(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FirstScreen.fxml"));
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            scene.getStylesheets().addAll(getClass().getResource("style.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
            FadeTransition fade=new FadeTransition(Duration.seconds(1),pane);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.setCycleCount(1);
            FadeTransition fade1=new FadeTransition(Duration.seconds(8.5),pane);
            fade1.setFromValue(1);
            fade1.setToValue(0);
            fade1.setCycleCount(1);
            fade.play();
            fade.setOnFinished(event -> {
                fade1.play();
            });
            fade1.setOnFinished(event -> {
                mainWindow();
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void mainWindow(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            scene.getStylesheets().addAll(getClass().getResource("style.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void problemWindow(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("problem.fxml"));
            AnchorPane pane = loader.load();
            Stage stage2=new Stage();
            Scene scene = new Scene(pane);
            scene.getStylesheets().addAll(getClass().getResource("style.css").toExternalForm());
            stage2.setScene(scene);
            stage2.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
