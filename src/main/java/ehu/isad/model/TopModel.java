package ehu.isad.model;

import javafx.scene.image.Image;

public class TopModel {

    private String herrialdea;
    private int puntuak;
    private Image bandera;

    public TopModel(String pHerrialdea, int pPuntuak, String imagepath) {
        this.herrialdea = pHerrialdea;
        this.puntuak = pPuntuak;
        this.bandera = new Image(imagepath);
    }

    public String getHerrialdea() {
        return this.herrialdea;
    }

    public void setHerrialdea(String herrialdea) {
        this.herrialdea = herrialdea;
    }

    public int getPuntuak() {
        return this.puntuak;
    }

    public void setPuntuak(int puntuak) {
        this.puntuak = puntuak;
    }

    public Image getBandera() {
        return this.bandera;
    }

    public void setBandera(Image image) {
        this.bandera = image;
    }
}