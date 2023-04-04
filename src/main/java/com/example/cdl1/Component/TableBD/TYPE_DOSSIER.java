package com.example.cdl1.Component.TableBD;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "TYPE_DOSSIER")

public class TYPE_DOSSIER {


    @Id
    @Column(name = "CODE")
    private String CODE;

    @Column(name = "LIBELLE_COURT")
    private String LIBELLE_COURT;

    @Column(name = "LIBELLE_LONG")
    private String LIBELLE_LONG;



    public String getCODE() {
        return CODE;
    }
    public void setCODE(String cODE) {
        CODE = cODE;
    }
    public String getLIBELLE_COURT() {
        return LIBELLE_COURT;
    }
    public void setLIBELLE_COURT(String lIBELLE_COURT) {
        LIBELLE_COURT = lIBELLE_COURT;
    }
    public String getLIBELLE_LONG() {
        return LIBELLE_LONG;
    }
    public void setLIBELLE_LONG(String lIBELLE_LONG) {
        LIBELLE_LONG = lIBELLE_LONG;
    }

}
