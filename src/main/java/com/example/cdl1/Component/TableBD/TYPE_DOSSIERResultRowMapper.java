package com.example.cdl1.Component.TableBD;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
// Mapper l'object FichierECH
public class TYPE_DOSSIERResultRowMapper implements RowMapper<TYPE_DOSSIER> {
    @Override
    public TYPE_DOSSIER mapRow(ResultSet rs, int i) throws SQLException {
        TYPE_DOSSIER TYPE_DOSSIER = new TYPE_DOSSIER();
        //"l","NATENG","TYPE"
        TYPE_DOSSIER.setCODE(rs.getString("CODE"));
        TYPE_DOSSIER.setLIBELLE_COURT(rs.getString("LIBELLE_COURT"));
        TYPE_DOSSIER.setLIBELLE_LONG(rs.getString("LIBELLE_LONG"));

        return TYPE_DOSSIER;
    }
}
