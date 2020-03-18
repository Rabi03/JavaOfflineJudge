package sample;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;


import javax.print.attribute.Attribute;
import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.io.IOException;

public class Model extends RecursiveTreeObject<Model> {
    StringProperty problemcol,filecol,languagecol,statuscol;
    Text t;
    public Model(String problemcol, String filecol, String languagecol, String statuscol){
        this.problemcol= new SimpleStringProperty(problemcol);
        this.filecol=new SimpleStringProperty(filecol);
        this.languagecol=new SimpleStringProperty(languagecol);
        this.statuscol= new SimpleStringProperty(statuscol);
    }

    public String getProblemcol() {
        return problemcol.get();
    }

    public StringProperty problemcolProperty() {
        return problemcol;
    }

    public void setProblemcol(String problemcol) {
        this.problemcol.set(problemcol);
    }

    public String getFilecol() {
        return filecol.get();
    }

    public StringProperty filecolProperty() {
        return filecol;
    }

    public void setFilecol(String filecol) {
        this.filecol.set(filecol);
    }

    public String getLanguagecol() {
        return languagecol.get();
    }

    public StringProperty languagecolProperty() {
        return languagecol;
    }

    public void setLanguagecol(String languagecol) {
        this.languagecol.set(languagecol);
    }

    public String getStatuscol() {
        return statuscol.get();
    }

    public StringProperty statuscolProperty() {
        return statuscol;
    }

    public void setStatuscol(String statuscol) {
        this.statuscol.set(statuscol);
    }
}
