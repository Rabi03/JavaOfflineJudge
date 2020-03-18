package sample;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


import java.net.URL;
import java.util.ResourceBundle;

public class problemController implements Initializable {
    @FXML
    private AnchorPane pane1;

    @FXML
    private AnchorPane pane2;

    @FXML
    private AnchorPane pane3;

    @FXML
    private AnchorPane pane4;
    public void translateanimation(double duration, Node node,double byX){
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(duration),node);
        translateTransition.setByX(byX);
        translateTransition.play();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        translateanimation(0.1,pane2,1266);
        translateanimation(0.1,pane3,1266);
        translateanimation(0.1,pane4,1266);
    }
    int c=0;
    public void prevAction(ActionEvent event) {
        if(c==1){
            translateanimation(0.1,pane2,1266);
            c--;
        }else if(c==2){
            translateanimation(0.1,pane3,1266);
            c--;
        }else if(c==3) {
            translateanimation(0.1, pane4, 1266);
            c--;
        }

    }

    public void nextAction(ActionEvent event) {
        if(c==0){
            translateanimation(0.1,pane2,-1266);
            c++;
        }else if(c==1){
            translateanimation(0.1,pane3,-1266);
            c++;
        }else if(c==2) {
            translateanimation(0.1, pane4, -1266);
            c++;
        }

    }
}
