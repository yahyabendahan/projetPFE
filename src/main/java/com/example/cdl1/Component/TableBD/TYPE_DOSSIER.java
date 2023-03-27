package com.example.cdl1.Component.TableBD;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class TYPE_DOSSIER {
    private String CODE ;
    private String LIBELLE_COURT;
    private String LIBELLE_LONG;

  /*  public TYPE_DOSSIER(String CODE, String LIBELLE_COURT, String LIBELLE_LONG) {
        this.CODE = CODE;
        this.LIBELLE_COURT = LIBELLE_COURT;
        this.LIBELLE_LONG = LIBELLE_LONG;
    } */

    // getters and setters



}
