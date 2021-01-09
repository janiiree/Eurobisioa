package ehu.isad.controller.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParteHartuKud {
    private static final ParteHartuKud instance = new ParteHartuKud();

    public static ParteHartuKud getInstance() {
        return instance;
    }

    private ParteHartuKud() {
    }

    public List<String> lortuHerrialdeak() {
        String query = "SELECT izena FROM ParteHartzea WHERE etorrikoDa='Bai' AND urtea=strftime('%Y', datetime('now'))";
        DBKudeatzailea dbKudeatzailea = DBKudeatzailea.getInstance();
        ResultSet rs = dbKudeatzailea.execSQL(query);

        List<String> emaitza = new ArrayList<>();
        try {
            while (rs.next()) {
                String izena = rs.getString("izena");
                emaitza.add(izena);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emaitza;
    }

    public void bozkaketakEguneratu(int puntuak, String herrialdea) {
        String query = "UPDATE Ordezkaritza SET puntuak=puntuak+" + puntuak + " WHERE herrialdea='" + herrialdea + "'";
        DBKudeatzailea dbKudeatzailea = DBKudeatzailea.getInstance();
        dbKudeatzailea.execSQL(query);

    }
}
