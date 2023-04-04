package com.example.cdl1.Component.FichierPlat.FichierECH;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@EntityScan
public class FichierECH {
    //24 colonne
    private String Age;     //non
    private String NATENG;
    private String	TYPE;
	private String CPT;
    private String RAISON_SOCIAL;       //non
    private float MONTANT_CREANCE;
    private String	DATE_CREANCE;
    private String ID_CLIENT;       //non
    private String	NO_DOSSIER;
    private String	DATE_ECHEANCE;
	private String DATE_MISE_IMPAYE;
	private String DATE_REGLEMENT;
	private float MONTANT_AMORTISSEMENT;
	private float MONTANT_INTERET_NORMAL;
    private float TVA_INTERET;
    private float MONTANT_INTERET_RETARD;
    private float TVA_INTERET_RETARD;
    private float MONATANT_PENALITE_RETARD;
    private float TVA_PENALITE_RETARD	;
 /* ++ ligne 1-17 dans Table IMPAYES */   private String NUM_COMPTE_PAYEUR;
 /*ligne 34-37 dans Table IMPAYES ++*/  private String CODE_CATEGORIE;
    private String NUM_DOSSIER_COMPLET;
    private String NUMERO_LIGNE;
    private String NUMERO_TIRAGE;

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

    public String getDATE_REGLEMENT() {
        return DATE_REGLEMENT;
    }

    public void setDATE_REGLEMENT(String DATE_REGLEMENT) {
        this.DATE_REGLEMENT = DATE_REGLEMENT;
    }

    public float getMONTANT_AMORTISSEMENT() {
        return MONTANT_AMORTISSEMENT;
    }

    public void setMONTANT_AMORTISSEMENT(float MONTANT_AMORTISSEMENT) {
        this.MONTANT_AMORTISSEMENT = MONTANT_AMORTISSEMENT;
    }

    public float getMONTANT_INTERET_NORMAL() {
        return MONTANT_INTERET_NORMAL;
    }

    public void setMONTANT_INTERET_NORMAL(float MONTANT_INTERET_NORMAL) {
        this.MONTANT_INTERET_NORMAL = MONTANT_INTERET_NORMAL;
    }

    public float getTVA_INTERET() {
        return TVA_INTERET;
    }

    public void setTVA_INTERET(float TVA_INTERET) {
        this.TVA_INTERET = TVA_INTERET;
    }

    public float getMONTANT_INTERET_RETARD() {
        return MONTANT_INTERET_RETARD;
    }

    public void setMONTANT_INTERET_RETARD(float MONTANT_INTERET_RETARD) {
        this.MONTANT_INTERET_RETARD = MONTANT_INTERET_RETARD;
    }

    public float getTVA_INTERET_RETARD() {
        return TVA_INTERET_RETARD;
    }

    public void setTVA_INTERET_RETARD(float TVA_INTERET_RETARD) {
        this.TVA_INTERET_RETARD = TVA_INTERET_RETARD;
    }

    public float getMONATANT_PENALITE_RETARD() {
        return MONATANT_PENALITE_RETARD;
    }

    public void setMONATANT_PENALITE_RETARD(float MONATANT_PENALITE_RETARD) {
        this.MONATANT_PENALITE_RETARD = MONATANT_PENALITE_RETARD;
    }

    public float getTVA_PENALITE_RETARD() {
        return TVA_PENALITE_RETARD;
    }

    public void setTVA_PENALITE_RETARD(float TVA_PENALITE_RETARD) {
        this.TVA_PENALITE_RETARD = TVA_PENALITE_RETARD;
    }

    public String getNUM_COMPTE_PAYEUR() {
        return NUM_COMPTE_PAYEUR;
    }

    public void setNUM_COMPTE_PAYEUR(String NUM_COMPTE_PAYEUR) {
        this.NUM_COMPTE_PAYEUR = NUM_COMPTE_PAYEUR;
    }

    public String getCODE_CATEGORIE() {
        return CODE_CATEGORIE;
    }

    public void setCODE_CATEGORIE(String CODE_CATEGORIE) {
        this.CODE_CATEGORIE = CODE_CATEGORIE;
    }

    public String getNUM_DOSSIER_COMPLET() {
        return NUM_DOSSIER_COMPLET;
    }

    public void setNUM_DOSSIER_COMPLET(String NUM_DOSSIER_COMPLET) {
        this.NUM_DOSSIER_COMPLET = NUM_DOSSIER_COMPLET;
    }

    public String getNUMERO_LIGNE() {
        return NUMERO_LIGNE;
    }

    public void setNUMERO_LIGNE(String NUMERO_LIGNE) {
        this.NUMERO_LIGNE = NUMERO_LIGNE;
    }

    public String getNUMERO_TIRAGE() {
        return NUMERO_TIRAGE;
    }

    public void setNUMERO_TIRAGE(String NUMERO_TIRAGE) {
        this.NUMERO_TIRAGE = NUMERO_TIRAGE;
    }
}
