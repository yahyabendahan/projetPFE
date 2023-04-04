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
    //24 colonne
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
    @Column(name = "NUM_COMPTE_PAYEUR")
    /* ++ ligne 1-17 dans Table IMPAYES */   private String NUM_COMPTE_PAYEUR;
    @Column(name = "CODE_CATEGORIE")
    /*ligne 34-37 dans Table IMPAYES ++*/  private String CODE_CATEGORIE;
    @Column(name = "NUM_DOSSIER_COMPLET")
    private String NUM_DOSSIER_COMPLET;
    @Column(name = "NUMERO_LIGNE")
    private String NUMERO_LIGNE;
    @Column(name = "NUMERO_TIRAGE")
    private String NUMERO_TIRAGE;

    public String setAge(String age) {
        return Age = age;
    }

    public String setNATENG(String NATENG) {
        return this.NATENG = NATENG;
    }

    public String setTYPE(String TYPE) {
        return this.TYPE = TYPE;
    }

    public String setCPT(String CPT) {
        return this.CPT = CPT;
    }

    public String setRAISON_SOCIAL(String RAISON_SOCIAL) {
        return this.RAISON_SOCIAL = RAISON_SOCIAL;
    }

    public float setMONTANT_CREANCE(float MONTANT_CREANCE) {
        return this.MONTANT_CREANCE = MONTANT_CREANCE;
    }

    public String setDATE_CREANCE(String DATE_CREANCE) {
        return this.DATE_CREANCE = DATE_CREANCE;
    }

    public String setID_CLIENT(String ID_CLIENT) {
        return this.ID_CLIENT = ID_CLIENT;
    }

    public String setNO_DOSSIER(String NO_DOSSIER) {
        return this.NO_DOSSIER = NO_DOSSIER;
    }

    public String setDATE_ECHEANCE(String DATE_ECHEANCE) {
        return this.DATE_ECHEANCE = DATE_ECHEANCE;
    }

    public String setDATE_MISE_IMPAYE(String DATE_MISE_IMPAYE) {
        return this.DATE_MISE_IMPAYE = DATE_MISE_IMPAYE;
    }

    public String setDATE_REGLEMENT(String DATE_REGLEMENT) {
        return this.DATE_REGLEMENT = DATE_REGLEMENT;
    }

    public float setMONTANT_AMORTISSEMENT(float MONTANT_AMORTISSEMENT) {return this.MONTANT_AMORTISSEMENT = MONTANT_AMORTISSEMENT;
    }

    public float setMONTANT_INTERET_NORMAL(float MONTANT_INTERET_NORMAL) {return this.MONTANT_INTERET_NORMAL = MONTANT_INTERET_NORMAL;
    }

    public float setTVA_INTERET(float TVA_INTERET) {
        return this.TVA_INTERET = TVA_INTERET;
    }

    public float setMONTANT_INTERET_RETARD(float MONTANT_INTERET_RETARD) {return this.MONTANT_INTERET_RETARD = MONTANT_INTERET_RETARD;
    }

    public float setTVA_INTERET_RETARD(float TVA_INTERET_RETARD) {return this.TVA_INTERET_RETARD = TVA_INTERET_RETARD;
    }

    public float setMONATANT_PENALITE_RETARD(float MONATANT_PENALITE_RETARD) {return this.MONATANT_PENALITE_RETARD = MONATANT_PENALITE_RETARD;
    }

    public float setTVA_PENALITE_RETARD(float TVA_PENALITE_RETARD) {return this.TVA_PENALITE_RETARD = TVA_PENALITE_RETARD;
    }

    public String setNUM_COMPTE_PAYEUR(String NUM_COMPTE_PAYEUR) {
        return this.NUM_COMPTE_PAYEUR = NUM_COMPTE_PAYEUR;
    }

    public String setCODE_CATEGORIE(String CODE_CATEGORIE) {
        return this.CODE_CATEGORIE = CODE_CATEGORIE;
    }

    public String setNUM_DOSSIER_COMPLET(String NUM_DOSSIER_COMPLET) {return this.NUM_DOSSIER_COMPLET = NUM_DOSSIER_COMPLET;
    }
    public String setNUMERO_LIGNE(String NUMERO_LIGNE) {
        return this.NUMERO_LIGNE = NUMERO_LIGNE;
    }

    public String setNUMERO_TIRAGE(String NUMERO_TIRAGE) {
        return this.NUMERO_TIRAGE = NUMERO_TIRAGE;
    }

}