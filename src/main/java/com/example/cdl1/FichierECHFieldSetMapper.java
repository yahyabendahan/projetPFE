package com.example.cdl1;

import com.example.cdl1.FichierCDL.FichierECH;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class FichierECHFieldSetMapper implements FieldSetMapper<FichierECH> {
    public FichierECH mapFieldSet(FieldSet fieldSet) {
        FichierECH FichierECH = new FichierECH();

        FichierECH.setNATENG(fieldSet.readString(0));
        FichierECH.setTYPE(fieldSet.readString(1));
        FichierECH.setCPT(fieldSet.readString(2));
        FichierECH.setMONTANT_CREANCE(fieldSet.readFloat(3));
        FichierECH.setDATE_CREANCE(fieldSet.readString(4));
        FichierECH.setNO_DOSSIER(fieldSet.readString(5));
        FichierECH.setDATE_ECHEANCE(fieldSet.readString(6));
        FichierECH.setDATE_MISE_IMPAYE(fieldSet.readString(7));
        FichierECH.setDATE_REGLEMENT(fieldSet.readString(8));
        FichierECH.setMONTANT_AMORTISSEMENT(fieldSet.readFloat(9));
        FichierECH.setMONTANT_INTERET_NORMAL(fieldSet.readFloat(10));
        FichierECH.setTVA_INTERET(fieldSet.readFloat(11));
        FichierECH.setMONTANT_INTERET_RETARD(fieldSet.readFloat(12));
        FichierECH.setTVA_INTERET_RETARD(fieldSet.readFloat(13));
        FichierECH.setMONATANT_PENALITE_RETARD(fieldSet.readFloat(14));
        FichierECH.setTVA_PENALITE_RETARD(fieldSet.readFloat(15));
        FichierECH.setNUM_COMPTE_PAYEUR(fieldSet.readString(016));
        FichierECH.setCODE_CATEGORIE(fieldSet.readString(17));
        FichierECH.setNUM_DOSSIER_COMPLET(fieldSet.readString(18));
        FichierECH.setNUMERO_LIGNE(fieldSet.readString(19));
        FichierECH.setNUMERO_TIRAGE(fieldSet.readString(20));

        return FichierECH;
    }
}
