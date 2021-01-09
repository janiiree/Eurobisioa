package ehu.isad.controller.db;

import ehu.isad.model.BozkaketaModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdezkapenKud {

    public static final OrdezkapenKud instance = new OrdezkapenKud();

    public static OrdezkapenKud getInstance() {
        return instance;
    }

    private OrdezkapenKud() {
    }

    public List<BozkaketaModel> ordezkapenakLortu() {
        String query = "select Ordezkaritza.*, Herrialde.bandera from Ordezkaritza inner join Herrialde where herrialdea=izena";
        DBKudeatzailea dbKudeatzailea = DBKudeatzailea.getInstance();
        ResultSet rs = dbKudeatzailea.execSQL(query);
        List<BozkaketaModel> emaitza = new ArrayList<>();
        try {
            while (rs.next()) {
                String herrialdea = rs.getString("herrialdea");
                String artista = rs.getString("artista");
                String abestia = rs.getString("abestia");
                String bandera = rs.getString("bandera");
                BozkaketaModel bozkaketaModel = new BozkaketaModel(herrialdea, artista, abestia, "banderak/" + bandera + ".png");
                emaitza.add(bozkaketaModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emaitza;
    }
}
