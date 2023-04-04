package com.example.cdl1.Component.TableBD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository

public interface TypeDossierRepository extends JpaRepository<TYPE_DOSSIER, String> {
    @Query("SELECT t.LIBELLE_COURT FROM TYPE_DOSSIER t")
    ArrayList<String> findAllLibelleCourt();

}
