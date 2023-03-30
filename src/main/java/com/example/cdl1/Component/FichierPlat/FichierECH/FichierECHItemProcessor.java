package com.example.cdl1.Component.FichierPlat.FichierECH;

import com.example.cdl1.Component.FichierPlat.Rejet.RejetECH;
import com.example.cdl1.Component.TableBD.IMPAYES_CDL;
import com.example.cdl1.Component.TableBD.TYPE_DOSSIER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class FichierECHItemProcessor implements ItemProcessor<FichierECH, FichierECH> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(FichierECHItemProcessor.class);

    @Override
    public FichierECH process(FichierECH fichierECH) throws Exception {
        System.out.println("Hello.process.fichierECH");
        TYPE_DOSSIER type_dossier =new TYPE_DOSSIER();
        IMPAYES_CDL impayesCdl = new IMPAYES_CDL();
        RejetECH rejectech = new RejetECH() ;

        if (fichierECH.getNATENG()  == "ECH"){
            if (fichierECH.getTYPE() == type_dossier.getLIBELLE_COURT() ){
                System.out.println("\nValider.FichierECHItemProcessor\n");
                impayesCdl.setAge(fichierECH.getAge()) ;
                impayesCdl.setNATENG(fichierECH.getNATENG()) ;
                impayesCdl.setTYPE(fichierECH.getTYPE()) ;
                impayesCdl.setCPT(fichierECH.getCPT()) ;
                impayesCdl.setRAISON_SOCIAL(fichierECH.getRAISON_SOCIAL()) ;
                impayesCdl.setMONTANT_CREANCE(fichierECH.getMONTANT_CREANCE()) ;
                impayesCdl.setDATE_CREANCE(fichierECH.getDATE_CREANCE()) ;
                impayesCdl.setID_CLIENT(fichierECH.getID_CLIENT()) ;
                impayesCdl.setNO_DOSSIER(fichierECH.getNO_DOSSIER()) ;
                impayesCdl.setDATE_ECHEANCE(fichierECH.getDATE_ECHEANCE()) ;
                impayesCdl.setDATE_MISE_IMPAYE(fichierECH.getDATE_MISE_IMPAYE()) ;
                impayesCdl.setDATE_REGLEMENT(fichierECH.getDATE_REGLEMENT()) ;
                impayesCdl.setMONTANT_AMORTISSEMENT(fichierECH.getMONTANT_AMORTISSEMENT()) ;
                impayesCdl.setMONTANT_INTERET_NORMAL(fichierECH.getMONTANT_INTERET_NORMAL()) ;
                impayesCdl.setTVA_INTERET(fichierECH.getTVA_INTERET()) ;
                impayesCdl.setMONTANT_INTERET_RETARD(fichierECH.getMONTANT_INTERET_RETARD()) ;
                impayesCdl.setTVA_INTERET_RETARD(fichierECH.getTVA_INTERET_RETARD()) ;
                impayesCdl.setMONATANT_PENALITE_RETARD(fichierECH.getMONATANT_PENALITE_RETARD()) ;
                impayesCdl.setTVA_PENALITE_RETARD(fichierECH.getTVA_PENALITE_RETARD()) ;
                impayesCdl.setNUM_COMPTE_PAYEUR(fichierECH.getNUM_COMPTE_PAYEUR()) ;
                impayesCdl.setCODE_CATEGORIE(fichierECH.getCODE_CATEGORIE()) ;
                impayesCdl.setNUM_DOSSIER_COMPLET(fichierECH.getNUM_DOSSIER_COMPLET()) ;
                impayesCdl.setNUMERO_LIGNE(fichierECH.getNUMERO_LIGNE()) ;
                impayesCdl.setNUMERO_TIRAGE(fichierECH.getNUMERO_TIRAGE()) ;
            }
        }
        //--rejectECH
        else {
            System.out.println("\nNonValider.FichierECHItemProcessor\n");
            rejectech.setAge(fichierECH.getAge()) ;
            rejectech.setNATENG(fichierECH.getNATENG()) ;
            rejectech.setTYPE(fichierECH.getTYPE()) ;
            rejectech.setCPT(fichierECH.getCPT()) ;
            rejectech.setRAISON_SOCIAL(fichierECH.getRAISON_SOCIAL()) ;
            rejectech.setMONTANT_CREANCE(fichierECH.getMONTANT_CREANCE()) ;
            rejectech.setDATE_CREANCE(fichierECH.getDATE_CREANCE()) ;
            rejectech.setID_CLIENT(fichierECH.getID_CLIENT()) ;
            rejectech.setNO_DOSSIER(fichierECH.getNO_DOSSIER()) ;
            rejectech.setDATE_ECHEANCE(fichierECH.getDATE_ECHEANCE()) ;
            rejectech.setDATE_MISE_IMPAYE(fichierECH.getDATE_MISE_IMPAYE()) ;
            rejectech.setDATE_REGLEMENT(fichierECH.getDATE_REGLEMENT()) ;
            rejectech.setMONTANT_AMORTISSEMENT(fichierECH.getMONTANT_AMORTISSEMENT()) ;
            rejectech.setMONTANT_INTERET_NORMAL(fichierECH.getMONTANT_INTERET_NORMAL()) ;
            rejectech.setTVA_INTERET(fichierECH.getTVA_INTERET()) ;
            rejectech.setMONTANT_INTERET_RETARD(fichierECH.getMONTANT_INTERET_RETARD()) ;
            rejectech.setTVA_INTERET_RETARD(fichierECH.getTVA_INTERET_RETARD()) ;
            rejectech.setMONATANT_PENALITE_RETARD(fichierECH.getMONATANT_PENALITE_RETARD()) ;
            rejectech.setTVA_PENALITE_RETARD(fichierECH.getTVA_PENALITE_RETARD()) ;
            rejectech.setNUM_COMPTE_PAYEUR(fichierECH.getNUM_COMPTE_PAYEUR()) ;
            rejectech.setCODE_CATEGORIE(fichierECH.getCODE_CATEGORIE()) ;
            rejectech.setNUM_DOSSIER_COMPLET(fichierECH.getNUM_DOSSIER_COMPLET()) ;
            rejectech.setNUMERO_LIGNE(fichierECH.getNUMERO_LIGNE()) ;
            rejectech.setNUMERO_TIRAGE(fichierECH.getNUMERO_TIRAGE()) ;
        }
        LOGGER.info("printing '{}' to output file", fichierECH);

        return fichierECH;
    }
}

