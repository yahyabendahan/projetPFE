package com.example.cdl1.Component.TableBD;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "IMPAYES_CDL")
public class IMPAYES_CDL {

    /*NATENG
TYPE
CPT
MONTANT_CREANCE
DATE_CREANCE
NO_DOSSIER
DATE_ECHEANCE
DATE_MISE_IMPAYE
DATE_REGLEMENT
MONTANT_AMORTISSEMENT
MONTANT_INTERET_NORMAL
TVA_INTERET
MONTANT_INTERET_RETARD
TVA_INTERET_RETARD
MONATANT_PENALITE_RETARD
TVA_PENALITE_RETARD
NUM_COMPTE_PAYEUR
REFFERENCE_VALEUR
REFERNCE_LIAISON
COMISSION
CODE_REJET
CODE_ETABLISST_BANCAIRE
CODE_GUICHET_BANCAIRE
DATE_REMISE
ENCOURS_EES_CONSO
ENCOURS_EES_COMM
ENCOURS_ESB
ENCOURS_ESI
SOLDE
ENCOURS_DECLASSE
ENCOURS_RISQUE
TYPE_CLIENT
NUM_TIERS
CODE_CATEGORIE
NUM_DOSSIER_COMPLET
NUMERO_LIGNE
NUMERO_TIRAGE*/


    @Column(name = "Age")
    private String Age;     //non
    @Id
    @Column(name = "NATENG")
    private String NATENG;
    @Column(name = "TYPE")
    private String TYPE;
    @Column(name = "CPT")
    private String CPT;
    @Column(name = "RAISON_SOCIAL")
    private String RAISON_SOCIAL;       //non
    @Column(name = "MONTANT_CREANCE")
    private float MONTANT_CREANCE;
    @Column(name = "DATE_CREANCE")
    private String DATE_CREANCE;
    @Column(name = "ID_CLIENT")
    private String ID_CLIENT;       //non
    @Column(name = "NO_DOSSIER")
    private String NO_DOSSIER;
    @Column(name = "DATE_ECHEANCE")
    private String DATE_ECHEANCE;
    @Column(name = "DATE_MISE_IMPAYE")
    private String DATE_MISE_IMPAYE;
    @Column(name = "DATE_REGLEMENT")
    private String DATE_REGLEMENT;
    @Column(name = "MONTANT_AMORTISSEMENT")
    private float MONTANT_AMORTISSEMENT;
    @Column(name = "MONTANT_INTERET_NORMAL")
    private float MONTANT_INTERET_NORMAL;
    @Column(name = "TVA_INTERET")
    private float TVA_INTERET;
    @Column(name = "MONTANT_INTERET_RETARD")
    private float MONTANT_INTERET_RETARD;
    @Column(name = "TVA_INTERET_RETARD")
    private float TVA_INTERET_RETARD;
    @Column(name = "MONATANT_PENALITE_RETARD")
    private float MONATANT_PENALITE_RETARD;
    @Column(name = "TVA_PENALITE_RETARD")
    private float TVA_PENALITE_RETARD;
    /* ++ ligne 1-17 dans Table IMPAYES */
    @Column(name = "NUM_COMPTE_PAYEUR")
    private String NUM_COMPTE_PAYEUR;
    @Column(name = "REFFERENCE_VALEUR")
    private String REFFERENCE_VALEUR;
    @Column(name = "REFERNCE_LIAISON")
    private String REFERNCE_LIAISON;
    @Column(name = "COMISSION")
    private float COMISSION;
    @Column(name = "CODE_REJET")
    private String CODE_REJET;
    @Column(name = "CODE_ETABLISST_BANCAIRE")
    private String CODE_ETABLISST_BANCAIRE;
    @Column(name = "CODE_GUICHET_BANCAIRE")
    private String CODE_GUICHET_BANCAIRE;
    @Column(name = "DATE_REMISE")
    private String DATE_REMISE;
    @Column(name = "ENCOURS_EES_CONSO")
    private float ENCOURS_EES_CONSO;
    @Column(name = "ENCOURS_EES_COMM")
    private float ENCOURS_EES_COMM;
    @Column(name = "ENCOURS_ESB")
    private float ENCOURS_ESB;
    @Column(name = "ENCOURS_ESI")
    private float ENCOURS_ESI;
    @Column(name = "SOLDE")
    private float SOLDE;
    @Column(name = "ENCOURS_DECLASSE")
    private float ENCOURS_DECLASSE;
    @Column(name = "ENCOURS_RISQUE")
    private float ENCOURS_RISQUE;
    @Column(name = "TYPE_CLIENT")
    private String TYPE_CLIENT;
    @Column(name = "NUM_TIERS")
    private String NUM_TIERS;
    /*ligne 34-37 dans Table IMPAYES ++*/
    @Column(name = "CODE_CATEGORIE")
    private String CODE_CATEGORIE;
    @Column(name = "NUM_DOSSIER_COMPLET")
    private String NUM_DOSSIER_COMPLET;
    @Column(name = "NUMERO_LIGNE")
    private String NUMERO_LIGNE;
    @Column(name = "NUMERO_TIRAGE")
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

    public String getREFFERENCE_VALEUR() {
        return REFFERENCE_VALEUR;
    }

    public void setREFFERENCE_VALEUR(String REFFERENCE_VALEUR) {
        this.REFFERENCE_VALEUR = REFFERENCE_VALEUR;
    }

    public String getREFERNCE_LIAISON() {
        return REFERNCE_LIAISON;
    }

    public void setREFERNCE_LIAISON(String REFERNCE_LIAISON) {
        this.REFERNCE_LIAISON = REFERNCE_LIAISON;
    }

    public float getCOMISSION() {
        return COMISSION;
    }

    public void setCOMISSION(float COMISSION) {
        this.COMISSION = COMISSION;
    }

    public String getCODE_REJET() {
        return CODE_REJET;
    }

    public void setCODE_REJET(String CODE_REJET) {
        this.CODE_REJET = CODE_REJET;
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

    public String getDATE_REMISE() {
        return DATE_REMISE;
    }

    public void setDATE_REMISE(String DATE_REMISE) {
        this.DATE_REMISE = DATE_REMISE;
    }

    public float getENCOURS_EES_CONSO() {
        return ENCOURS_EES_CONSO;
    }

    public void setENCOURS_EES_CONSO(float ENCOURS_EES_CONSO) {
        this.ENCOURS_EES_CONSO = ENCOURS_EES_CONSO;
    }

    public float getENCOURS_EES_COMM() {
        return ENCOURS_EES_COMM;
    }

    public void setENCOURS_EES_COMM(float ENCOURS_EES_COMM) {
        this.ENCOURS_EES_COMM = ENCOURS_EES_COMM;
    }

    public float getENCOURS_ESB() {
        return ENCOURS_ESB;
    }

    public void setENCOURS_ESB(float ENCOURS_ESB) {
        this.ENCOURS_ESB = ENCOURS_ESB;
    }

    public float getENCOURS_ESI() {
        return ENCOURS_ESI;
    }

    public void setENCOURS_ESI(float ENCOURS_ESI) {
        this.ENCOURS_ESI = ENCOURS_ESI;
    }

    public float getSOLDE() {
        return SOLDE;
    }

    public void setSOLDE(float SOLDE) {
        this.SOLDE = SOLDE;
    }

    public float getENCOURS_DECLASSE() {
        return ENCOURS_DECLASSE;
    }

    public void setENCOURS_DECLASSE(float ENCOURS_DECLASSE) {
        this.ENCOURS_DECLASSE = ENCOURS_DECLASSE;
    }

    public float getENCOURS_RISQUE() {
        return ENCOURS_RISQUE;
    }

    public void setENCOURS_RISQUE(float ENCOURS_RISQUE) {
        this.ENCOURS_RISQUE = ENCOURS_RISQUE;
    }

    public String getTYPE_CLIENT() {
        return TYPE_CLIENT;
    }

    public void setTYPE_CLIENT(String TYPE_CLIENT) {
        this.TYPE_CLIENT = TYPE_CLIENT;
    }

    public String getNUM_TIERS() {
        return NUM_TIERS;
    }

    public void setNUM_TIERS(String NUM_TIERS) {
        this.NUM_TIERS = NUM_TIERS;
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