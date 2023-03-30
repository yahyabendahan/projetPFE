package com.example.cdl1.Component.FichierPlat.FichierECH;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class FichierECHFieldSetMapper implements FieldSetMapper<FichierECH> {
    public FichierECH mapFieldSet(FieldSet fieldSet) {
        FichierECH FichierECH = new FichierECH();
        System.out.println("\nValider.FichierECHFieldSetMapper\n");

        FichierECH.setAge(fieldSet.readString(0));//------
        FichierECH.setNATENG(fieldSet.readString(1));
        FichierECH.setTYPE(fieldSet.readString(2));
        FichierECH.setCPT(fieldSet.readString(3));
        FichierECH.setRAISON_SOCIAL(fieldSet.readString(4)); //---
        FichierECH.setMONTANT_CREANCE(fieldSet.readFloat(5));
        FichierECH.setDATE_CREANCE(fieldSet.readString(6));
        FichierECH.setID_CLIENT(fieldSet.readString(7));//-----
        FichierECH.setNO_DOSSIER(fieldSet.readString(8));
        FichierECH.setDATE_ECHEANCE(fieldSet.readString(9));
        FichierECH.setDATE_MISE_IMPAYE(fieldSet.readString(10));
        FichierECH.setDATE_REGLEMENT(fieldSet.readString(11));
        FichierECH.setMONTANT_AMORTISSEMENT(fieldSet.readFloat(12));
        FichierECH.setMONTANT_INTERET_NORMAL(fieldSet.readFloat(13));
        FichierECH.setTVA_INTERET(fieldSet.readFloat(14));
        FichierECH.setMONTANT_INTERET_RETARD(fieldSet.readFloat(15));
        FichierECH.setTVA_INTERET_RETARD(fieldSet.readFloat(16));
        FichierECH.setMONATANT_PENALITE_RETARD(fieldSet.readFloat(17));
        FichierECH.setTVA_PENALITE_RETARD(fieldSet.readFloat(18));
        FichierECH.setNUM_COMPTE_PAYEUR(fieldSet.readString(19));
        FichierECH.setCODE_CATEGORIE(fieldSet.readString(20));
        FichierECH.setNUM_DOSSIER_COMPLET(fieldSet.readString(21));
        FichierECH.setNUMERO_LIGNE(fieldSet.readString(22));
        FichierECH.setNUMERO_TIRAGE(fieldSet.readString(23));

        return FichierECH;
    }
}
