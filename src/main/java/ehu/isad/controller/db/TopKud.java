package ehu.isad.controller.db;

import ehu.isad.model.TopModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopKud {
    
    private static final TopKud instance = new TopKud();
    public static TopKud getInstance() {
        return instance;
    }
    
    private TopKud() {
        
    }

    public List<TopModel> onenakLortu() {
        String query = "SELECT o.herrialdea, o.puntuak, h.bandera FROM Ordezkaritza o, Herrialde h WHERE o.urtea=strftime('%Y', datetime('now')) AND o.herrialdea=h.izena ORDER BY o.puntuak DESC LIMIT 3";
        DBKudeatzailea dbKudeatzailea = DBKudeatzailea.getInstance();
        ResultSet rs = dbKudeatzailea.execSQL(query);
        List<TopModel> emaitza = new ArrayList<>();

        try {
            while (rs.next()) {
                String herrialdea = rs.getString("herrialdea");
                int puntuak = rs.getInt("puntuak");
                String bandera = rs.getString("bandera");
                TopModel top = new TopModel(herrialdea, puntuak, "banderak/" + bandera + ".png");
                emaitza.add(top);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return emaitza;
    }
}
