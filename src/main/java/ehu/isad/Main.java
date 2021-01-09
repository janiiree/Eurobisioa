package ehu.isad;

import ehu.isad.controller.ui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage stage;

    private KudUI1 kud1;
    private KudUI2 kud2;
    private KudUI3 kud3;
    private KudUI4 kud4;
    private KudUI5 kud5;

    private Scene scene1;
    private Scene scene2;
    private Scene scene3;
    private Scene scene4;
    private Scene scene5;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        pantailakKargatu();
        stage.setTitle("EUROBISIOA");
        stage.setScene(scene1);
        stage.show();
    }

    private void pantailakKargatu() throws IOException {
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/NagusiaUI.fxml"));
        Parent ui1 = loader1.load();
        scene1 = new Scene(ui1);
        kud1 = loader1.getController();
        kud1.setMainApp(this);

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/Herrialdeak.fxml"));
        Parent ui2 = loader2.load();
        scene2 = new Scene(ui2);
        kud2 = loader2.getController();
        kud2.setMainApp(this);

        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/Errorea.fxml"));
        Parent ui3 = loader3.load();
        scene3 = new Scene(ui3);
        kud3 = loader3.getController();
        kud3.setMainApp(this);

        FXMLLoader loader4 = new FXMLLoader(getClass().getResource("/Bozkaketak.fxml"));
        Parent ui4 = loader4.load();
        scene4 = new Scene(ui4);
        kud4 = loader4.getController();
        kud4.setMainApp(this);

        FXMLLoader loader5 = new FXMLLoader(getClass().getResource("/TOP3.fxml"));
        Parent ui5 = loader5.load();
        scene5 = new Scene(ui5);
        kud5 = loader5.getController();
        kud5.setMainApp(this);
    }
    public void erakutsiUI2() {
        stage.setScene(scene2);
        stage.show();
    }

    public void erakutsiUI3(String pHerrialde) {
        kud3.setLabel(pHerrialde);
        stage.setScene(scene3);
        stage.show();

    }

    public void erakutsiUI4(String pHerrialde) {
        kud4.setLblBozkatzaile(pHerrialde);
        kud4.setHerrialde(pHerrialde);
        stage.setScene(scene4);
        stage.show();
        }

    public void erakutsiUI5() {
        kud5.erakutsiTopHiru();
        stage.setScene(scene5);
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}