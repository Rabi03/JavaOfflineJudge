package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class screenController implements Initializable {
    @FXML
    public ProgressBar progressbar;
    @FXML
    public ProgressIndicator pi;


    class bg_Thread implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<100;i++){
                progressbar.setProgress(i/50.0);
                pi.setProgress(i/50.0);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        progressbar.setProgress(0.0);
        pi.setProgress(0.0);
        Thread th=new Thread(new bg_Thread());
        th.start();
    }
}
