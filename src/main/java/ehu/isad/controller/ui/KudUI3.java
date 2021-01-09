package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class KudUI3 implements Initializable {

    private Main main;

    @FXML
    private Button btnOk;
    @FXML
    private Label lblTestua;

    public void setMainApp(Main main) {
        this.main = main;
    }

    public void setLabel(String herrialde) {
        lblTestua.setText(herrialde + "k jada banatu ditu bere puntuak");
    }

    public void onClickOk(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
