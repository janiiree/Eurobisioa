package ehu.isad.controller.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BozkatuKud {
    private static final BozkatuKud instance = new BozkatuKud();
    public static BozkatuKud getInstance() {
        return instance;
    }

    private BozkatuKud() {
    }

    public String bozkatuDu(String herrialde) {
        String query = "SELECT h.bandera FROM Herrialde h, Bozkaketa b WHERE b.bozkatuDu='" + herrialde + "' AND h.izena=b.bozkatuDu AND b.urtea=strftime('%Y', datetime('now'))";
        DBKudeatzailea dbKudeatzailea = DBKudeatzailea.getInstance();
        ResultSet rs = dbKudeatzailea.execSQL(query);
        String emaitza = "";
        try {
            if (rs.next()) {
                emaitza = rs.getString("bandera");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return emaitza;
    }

    public void puntuakSartu(int puntuak, String herrialde, String hBozkatua) {
        String query = "INSERT INTO Bozkaketa (bozkatuaIzanDa, bozkatuDu, urtea, puntuak) VALUES('" + hBozkatua + "', '" + herrialde +  "', strftime('%Y', datetime('now')), " + puntuak + ")";
        DBKudeatzailea dbKudeatzailea = DBKudeatzailea.getInstance();
        dbKudeatzailea.execSQL(query);
    }
}
