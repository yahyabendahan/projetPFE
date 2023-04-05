package com.example.cdl1.Component.FichierPlat.FichierMCN;


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
public class FichierMCN {

    private String Age;  //non
    private String NATENG;
    private String TYPE;
    private String CPT;
    private String RAISON_SOCIAL;  //non
    private float MONTANT_CREANCE;
    private String DATE_CREANCE;
    private String ID_CLIENT;  //non
    private String NO_DOSSIER;

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

    public String getDATE_ECHEANCE() {
        return DATE_ECHEANCE;
    }

    public void setDATE_ECHEANCE(String DATE_ECHEANCE) {
        this.DATE_ECHEANCE = DATE_ECHEANCE;
    }

    public String getDATE_MISE_IMPAYE() {
        return DATE_MISE_IMPAYE;
    }

    public void setDATE_MISE_IMPAYE(String DATE_MISE_IMPAYE) {
        this.DATE_MISE_IMPAYE = DATE_MISE_IMPAYE;
    }

    public String getFIELD13() {
        return FIELD13;
    }

    public void setFIELD13(String FIELD13) {
        this.FIELD13 = FIELD13;
    }

    public String getFIELD14() {
        return FIELD14;
    }

    public void setFIELD14(String FIELD14) {
        this.FIELD14 = FIELD14;
    }

    public String getFIELD15() {
        return FIELD15;
    }

    public void setFIELD15(String FIELD15) {
        this.FIELD15 = FIELD15;
    }

    public String getFIELD16() {
        return FIELD16;
    }

    public void setFIELD16(String FIELD16) {
        this.FIELD16 = FIELD16;
    }

    public String getFIELD17() {
        return FIELD17;
    }

    public void setFIELD17(String FIELD17) {
        this.FIELD17 = FIELD17;
    }

    private String REFFERENCE_VALEUR;
    private String DATE_ECHEANCE;
    private String DATE_MISE_IMPAYE;
    private String FIELD13;
    private String FIELD14;
    private String FIELD15;
    private String FIELD16;
    private String FIELD17;

}
