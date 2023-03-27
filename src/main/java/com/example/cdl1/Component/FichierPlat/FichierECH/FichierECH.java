package com.example.cdl1.Component.FichierPlat.FichierECH;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString

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

}
