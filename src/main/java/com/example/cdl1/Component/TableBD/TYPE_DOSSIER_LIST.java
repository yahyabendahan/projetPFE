package com.example.cdl1.Component.TableBD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class TYPE_DOSSIER_LIST {
    private final JdbcTemplate jdbcTemplate;


    private static List<String> VALID_VALUES = new ArrayList<>();

    @Autowired
    public TYPE_DOSSIER_LIST(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    public void init() {
        String sql = "SELECT LIBELLE_COURT from TYPE_DOSSIER";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows) {
            VALID_VALUES.add((String) row.get("LIBELLE_COURT"));
        }

    }
    @Bean
    public static List<String> getValidValues() {
        return VALID_VALUES;

    }
}
