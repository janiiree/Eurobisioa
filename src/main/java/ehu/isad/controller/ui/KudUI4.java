package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.BozkatuKud;
import ehu.isad.controller.db.OrdezkapenKud;
import ehu.isad.controller.db.ParteHartuKud;
import ehu.isad.model.BozkaketaModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class KudUI4 implements Initializable {

    private Main main;

    private String herrialde;

    @FXML
    private Label lblBozkatzaile;
    @FXML
    private Button btnGorde;

    @FXML
    private TableView<BozkaketaModel> taulaBotoak;

    @FXML
    private TableColumn<BozkaketaModel, String> herrialdeCol;
    @FXML
    private TableColumn<BozkaketaModel, String> artistaCol;
    @FXML
    private TableColumn<BozkaketaModel, String> abestiCol;
    @FXML
    private TableColumn<BozkaketaModel, Integer> puntuCol;

    @FXML
    private TableColumn<BozkaketaModel, Image> banderaCol;

    public void setMainApp(Main main) {
        this.main = main;
    }

    public void setHerrialde(String pHerrialde) {
        this.herrialde = pHerrialde;
    }

    public void setLblBozkatzaile(String herrialde) {
        this.lblBozkatzaile.setText(herrialde + "k horrela banatu nahi ditu bere puntuak");
    }

    @FXML
    public void onClickGorde(ActionEvent actionEvent) {
            int i = 0;
            int puntuak = 0;
            while (i < taulaBotoak.getItems().size() && puntuak < 5) {
                puntuak = puntuak + taulaBotoak.getItems().get(i).getPuntuak();
                i++;
            }
            if (puntuak == 5) {
                this.datuBaseanSartu();
                this.main.erakutsiUI5();
            }
    }

    private void datuBaseanSartu() {

        for (int i=0;i<taulaBotoak.getItems().size();i++){
            if (taulaBotoak.getItems().get(i).getPuntuak() != 0) {
                int p = taulaBotoak.getItems().get(i).getPuntuak();
                String hBozk = taulaBotoak.getItems().get(i).getHerrialdea();
                BozkatuKud.getInstance().puntuakSartu(p, this.herrialde, hBozk);
                ParteHartuKud.getInstance().bozkaketakEguneratu(p, hBozk);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taulaBotoak.setEditable(true);

        List<BozkaketaModel> ordezkapenak = OrdezkapenKud.getInstance().ordezkapenakLortu();
        ObservableList<BozkaketaModel> bozkaketaModel = FXCollections.observableArrayList(ordezkapenak);
        taulaBotoak.setItems(bozkaketaModel);

        herrialdeCol.setCellValueFactory(new PropertyValueFactory<>("herrialdea"));
        artistaCol.setCellValueFactory(new PropertyValueFactory<>("artista"));
        abestiCol.setCellValueFactory(new PropertyValueFactory<>("abestia"));
        puntuCol.setCellValueFactory(new PropertyValueFactory<>("puntuak"));
        banderaCol.setCellValueFactory(new PropertyValueFactory<>("bandera"));

        puntuCol.setOnEditCommit(t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setPuntuak(t.getNewValue()));

        banderaCol.setCellFactory(param -> new TableCell<>() {
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

        //Herrialde batek bere burua ez hautatzeko
        Callback<TableColumn<BozkaketaModel, Integer>, TableCell<BozkaketaModel, Integer>> defaultTextFieldCellFactory = TextFieldTableCell.forTableColumn(new IntegerStringConverter());
        puntuCol.setCellFactory(col -> {
            TableCell<BozkaketaModel, Integer> cell = defaultTextFieldCellFactory.call(col);

            cell.setOnMouseClicked(e -> {
                if (!cell.isEmpty()) {
                    cell.setEditable(!cell.getTableView().getSelectionModel().getSelectedItem().getHerrialdea().equals(this.herrialde));
                }
            });
            return cell;
        });


    }
}