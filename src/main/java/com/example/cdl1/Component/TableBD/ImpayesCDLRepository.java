package com.example.cdl1.Component.TableBD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImpayesCDLRepository extends JpaRepository<IMPAYES_CDL, Long> {
}
