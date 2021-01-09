package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.BozkatuKud;
import ehu.isad.controller.db.ParteHartuKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class KudUI2 implements Initializable {

    private Main main;

    @FXML
    private ComboBox<String> comboHerrialdeak;

    @FXML
    private Button btnOk;

    public void setMainApp(Main main) {
        this.main = main;
    }

    public void onClickOk(ActionEvent actionEvent) {
        String bandera = BozkatuKud.getInstance().bozkatuDu(comboHerrialdeak.getValue());
        if (!bandera.equals("")) {
            this.main.erakutsiUI3(bandera);
        } else {
            this.main.erakutsiUI4(comboHerrialdeak.getValue());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> herrialdeList = ParteHartuKud.getInstance().lortuHerrialdeak();
        ObservableList<String> herrialdeak = FXCollections.observableArrayList(herrialdeList);

        comboHerrialdeak.setItems(herrialdeak);
        comboHerrialdeak.setEditable(false);
        comboHerrialdeak.getSelectionModel().selectFirst();
    }
}
