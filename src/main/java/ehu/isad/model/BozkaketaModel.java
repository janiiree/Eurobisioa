package ehu.isad.model;

import javafx.scene.image.Image;


public class BozkaketaModel {
    private String herrialdea;
    private String artista;
    private String abestia;
    private int puntuak;
    private Image bandera;

    public BozkaketaModel(String pHerrialdea, String pArtista, String pAbestia, String pImagepath) {
        this.herrialdea = pHerrialdea;
        this.artista = pArtista;
        this.abestia = pAbestia;
        this.puntuak = 0;
        this.bandera = new Image(pImagepath);
    }

    public String getHerrialdea() {
        return this.herrialdea;
    }

    public void setHerrialdea(String pHerrialdea) {
        this.herrialdea = pHerrialdea;
    }

    public String getArtista() {
        return this.artista;
    }

    public void setArtista(String pArtista) {
        this.artista = pArtista;
    }

    public String getAbestia() {
        return this.abestia;
    }

    public void setAbestia(String pAbestia) {
        this.abestia = pAbestia;
    }

    public int getPuntuak() {
        return this.puntuak;
    }

    public void setPuntuak(int pPuntuak) {
        this.puntuak = pPuntuak;
    }

    public Image getBandera() {
        return this.bandera;
    }

    public void setBandera(Image pBandera) {
        this.bandera = pBandera;
    }
}
