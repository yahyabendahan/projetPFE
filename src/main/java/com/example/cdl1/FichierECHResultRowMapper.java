package com.example.cdl1;


import com.example.cdl1.FichierCDL.FichierECH;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component

public class FichierECHResultRowMapper implements RowMapper<FichierECH> {
    @Override
    public FichierECH mapRow(ResultSet rs, int i) throws SQLException {
        FichierECH FichierECH = new FichierECH();
        //"l","NATENG","TYPE"
        FichierECH.setNATENG(rs.getString("NATENG"));
        FichierECH.setTYPE(rs.getString("TYPE"));
        return FichierECH;
    }
}
