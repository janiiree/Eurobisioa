package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.TopKud;
import ehu.isad.model.TopModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.List;

import java.net.URL;
import java.util.ResourceBundle;

public class KudUI5 implements Initializable {

    private Main main;

    @FXML
    private Button btnOk;

    @FXML
    private TableView<TopModel> taulaTop;
    @FXML
    private TableColumn<TopModel, Image> banderaCol;
    @FXML
    private TableColumn<TopModel, String> herrialdeCol;
    @FXML
    private TableColumn<TopModel, Integer> puntuakCol;
    

    public void setMainApp(Main main) {
        this.main = main;
    }

    public void onClickOk(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void erakutsiTopHiru() {
        taulaTop.setEditable(false);

        List<TopModel> onenak = TopKud.getInstance().onenakLortu();
        ObservableList<TopModel> top3model = FXCollections.observableArrayList(onenak);
        taulaTop.setItems(top3model);

        herrialdeCol.setCellValueFactory(new PropertyValueFactory<>("herrialdea"));
        puntuakCol.setCellValueFactory(new PropertyValueFactory<>("puntuak"));
        banderaCol.setCellValueFactory(new PropertyValueFactory<>("bandera"));

        banderaCol.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty) {
                    final ImageView imageView = new ImageView();
                    imageView.setImage(image);
                    setGraphic(imageView);
                    setAlignment(Pos.CENTER);
                } else {
                    setGraphic(null);
                    setText(null);
                }
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
