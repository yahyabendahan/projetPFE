package com.example.cdl1.Component.FichierPlat.FichierSBF;

import com.example.cdl1.Component.FichierPlat.Rejet.CDL_SBF_FAILS;
import com.example.cdl1.Component.TableBD.IMPAYES_CDL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.util.Objects;

public class FichierSBFItemProcessor implements ItemProcessor<FichierSBF, IMPAYES_CDL> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(FichierSBFItemProcessor.class);
    //@Bean
    @Override @Nullable
    public IMPAYES_CDL process(@NonNull FichierSBF fichierSBF) throws Exception {



        System.out.println("Hello.process.ItemProcessor<fichierSBF, IMPAYES_CDL>");

        IMPAYES_CDL impayesCdl = new IMPAYES_CDL();
        CDL_SBF_FAILS rejectsbf = new CDL_SBF_FAILS();

        if (Objects.equals(fichierSBF.getNATENG(), "ECH")){ //fichierSBF.getNATENG()  == "ECH"

                impayesCdl.setNATENG(fichierSBF.getNATENG()) ;
                impayesCdl.setTYPE(fichierSBF.getTYPE()) ;
                impayesCdl.setCPT(fichierSBF.getCPT()) ;
                impayesCdl.setMONTANT_CREANCE(fichierSBF.getMONTANT_CREANCE()) ;
                impayesCdl.setDATE_CREANCE(fichierSBF.getDATE_CREANCE()) ;
                impayesCdl.setNO_DOSSIER(fichierSBF.getNO_DOSSIER()) ;
                impayesCdl.setREFFERENCE_VALEUR(fichierSBF.getREFFERENCE_VALEUR());
                impayesCdl.setCODE_ETABLISST_BANCAIRE(fichierSBF.getCODE_ETABLISST_BANCAIRE());
                impayesCdl.setCODE_GUICHET_BANCAIRE(fichierSBF.getCODE_GUICHET_BANCAIRE());
                impayesCdl.setDATE_REMISE(fichierSBF.getDate_Remise());
                impayesCdl.setREFERNCE_LIAISON(fichierSBF.getREFERNCE_LIAISON());
                impayesCdl.setCODE_REJET(fichierSBF.getCODE_REJET());
                impayesCdl.setCOMISSION(fichierSBF.getCOMISSION());


                LOGGER.info("Created ImpayesCDLModel: {}", impayesCdl);

            System.out.println("VERIFIER fichierSBF.getNATENG()  == SBF {}");
        }
        //--rejectsbf
        else {
            System.out.println("\nNonValider.(rejectsbf)\n");
            rejectsbf.setNATENG(fichierSBF.getNATENG()) ;
            rejectsbf.setTYPE(fichierSBF.getTYPE()) ;
            rejectsbf.setCPT(fichierSBF.getCPT()) ;
            rejectsbf.setMONTANT_CREANCE(fichierSBF.getMONTANT_CREANCE()) ;
            rejectsbf.setDATE_CREANCE(fichierSBF.getDATE_CREANCE()) ;
            rejectsbf.setNO_DOSSIER(fichierSBF.getNO_DOSSIER()) ;
            rejectsbf.setREFFERENCE_VALEUR(fichierSBF.getREFFERENCE_VALEUR());
            rejectsbf.setCODE_ETABLISST_BANCAIRE(fichierSBF.getCODE_ETABLISST_BANCAIRE());
            rejectsbf.setCODE_GUICHET_BANCAIRE(fichierSBF.getCODE_GUICHET_BANCAIRE());
            rejectsbf.setDate_Remise(fichierSBF.getDate_Remise());
            rejectsbf.setREFERNCE_LIAISON(fichierSBF.getREFERNCE_LIAISON());
            rejectsbf.setCODE_REJET(fichierSBF.getCODE_REJET());
            rejectsbf.setCOMISSION(fichierSBF.getCOMISSION());
            LOGGER.info("Created rejectsbfModel: {}", rejectsbf);
        }
        LOGGER.info("printing '{}' to output file(fichierSBF)", fichierSBF);

        return impayesCdl;
    }
}

