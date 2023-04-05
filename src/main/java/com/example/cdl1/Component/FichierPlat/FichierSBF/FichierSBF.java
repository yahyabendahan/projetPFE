package com.example.cdl1.Component.FichierPlat.FichierSBF;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityScan
public class FichierSBF {

    private String Age;  //non
    private String NATENG;
    private String TYPE;
    private String CPT;
    private String RAISON_SOCIAL;  //non
    private float MONTANT_CREANCE;
    private String DATE_CREANCE;
    private String ID_CLIENT;  //non
    private String NO_DOSSIER;
    private String REFFERENCE_VALEUR;

    private String CODE_ETABLISST_BANCAIRE;
    private String CODE_GUICHET_BANCAIRE;
    private String Date_Remise;
    private String REFERNCE_LIAISON;
    private String CODE_REJET;
    private float COMISSION;
    private String Field17; //non
    private String Field18; //non

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getNATENG() {
        return NATENG;
    }

    public void setNATENG(String NATENG) {
        this.NATENG = NATENG;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getCPT() {
        return CPT;
    }

    public void setCPT(String CPT) {
        this.CPT = CPT;
    }

    public String getRAISON_SOCIAL() {
        return RAISON_SOCIAL;
    }

    public void setRAISON_SOCIAL(String RAISON_SOCIAL) {
        this.RAISON_SOCIAL = RAISON_SOCIAL;
    }

    public float getMONTANT_CREANCE() {
        return MONTANT_CREANCE;
    }

    public void setMONTANT_CREANCE(float MONTANT_CREANCE) {
        this.MONTANT_CREANCE = MONTANT_CREANCE;
    }

    public String getDATE_CREANCE() {
        return DATE_CREANCE;
    }

    public void setDATE_CREANCE(String DATE_CREANCE) {
        this.DATE_CREANCE = DATE_CREANCE;
    }

    public String getID_CLIENT() {
        return ID_CLIENT;
    }

    public void setID_CLIENT(String ID_CLIENT) {
        this.ID_CLIENT = ID_CLIENT;
    }

    public String getNO_DOSSIER() {
        return NO_DOSSIER;
    }

    public void setNO_DOSSIER(String NO_DOSSIER) {
        this.NO_DOSSIER = NO_DOSSIER;
    }

    public String getREFFERENCE_VALEUR() {
        return REFFERENCE_VALEUR;
    }

    public void setREFFERENCE_VALEUR(String REFFERENCE_VALEUR) {
        this.REFFERENCE_VALEUR = REFFERENCE_VALEUR;
    }

    public String getCODE_ETABLISST_BANCAIRE() {
        return CODE_ETABLISST_BANCAIRE;
    }

    public void setCODE_ETABLISST_BANCAIRE(String CODE_ETABLISST_BANCAIRE) {
        this.CODE_ETABLISST_BANCAIRE = CODE_ETABLISST_BANCAIRE;
    }

    public String getCODE_GUICHET_BANCAIRE() {
        return CODE_GUICHET_BANCAIRE;
    }

    public void setCODE_GUICHET_BANCAIRE(String CODE_GUICHET_BANCAIRE) {
        this.CODE_GUICHET_BANCAIRE = CODE_GUICHET_BANCAIRE;
    }

    public String getDate_Remise() {
        return Date_Remise;
    }

    public void setDate_Remise(String date_Remise) {
        Date_Remise = date_Remise;
    }

    public String getREFERNCE_LIAISON() {
        return REFERNCE_LIAISON;
    }

    public void setREFERNCE_LIAISON(String REFERNCE_LIAISON) {
        this.REFERNCE_LIAISON = REFERNCE_LIAISON;
    }

    public String getCODE_REJET() {
        return CODE_REJET;
    }

    public void setCODE_REJET(String CODE_REJET) {
        this.CODE_REJET = CODE_REJET;
    }

    public float getCOMISSION() {
        return COMISSION;
    }

    public void setCOMISSION(float COMISSION) {
        this.COMISSION = COMISSION;
    }

    public String getField17() {
        return Field17;
    }

    public void setField17(String field17) {
        Field17 = field17;
    }

    public String getField18() {
        return Field18;
    }

    public void setField18(String field18) {
        Field18 = field18;
    }
}
