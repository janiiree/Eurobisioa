package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class KudUI1 implements Initializable {

    private Main main;

    @FXML
    private Button btnBozkatu;

    public void setMainApp(Main main) {
        this.main = main;
    }

    public void onClickBozkatu(ActionEvent actionEvent) {
        this.main.erakutsiUI2();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
