package com.example.cdl1.Component.FichierPlat.FichierECH;

import com.example.cdl1.Component.TableBD.IMPAYES_CDL;
import jakarta.validation.constraints.NotNull;
import lombok.SneakyThrows;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import javax.sql.DataSource;

public class FichierECHItemWriter implements ItemWriter<IMPAYES_CDL> {


//Finally, LinesWriter will have the responsibility of writing ... to an output file:
    private Resource outputResource = new FileSystemResource("C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\FichierRejet\\RejetECH.CSV");


    //=>to BD
         @Bean
  public JdbcBatchItemWriter<IMPAYES_CDL> writerToBD() {
    JdbcBatchItemWriter<IMPAYES_CDL> itemWriter = new JdbcBatchItemWriter<>();
             DataSource dataSource = null;
             itemWriter.setDataSource(dataSource);
    itemWriter.setSql("INSERT INTO IMPAYES_CDL (NATENG, TYPE, CPT, MONTANT_CREANCE, DATE_CREANCE, NO_DOSSIER, DATE_ECHEANCE, DATE_MISE_IMPAYE, DATE_REGLEMENT, MONTANT_AMORTISSEMENT, MONTANT_INTERET_NORMAL, TVA_INTERET, MONTANT_INTERET_RETARD, TVA_INTERET_RETARD, MONATANT_PENALITE_RETARD, TVA_PENALITE_RETARD, NUM_COMPTE_PAYEUR, CODE_CATEGORIE, NUM_DOSSIER_COMPLET, NUMERO_LIGNE, NUMERO_TIRAGE)" +
            " VALUES (:NATENG,:TYPE,:CPT,:MONTANT_CREANCE,:DATE_CREANCE,:NO_DOSSIER,:DATE_ECHEANCE,:DATE_MISE_IMPAYE,:DATE_REGLEMENT,:MONTANT_AMORTISSEMENT,:MONTANT_INTERET_NORMAL,:TVA_INTERET,:MONTANT_INTERET_RETARD,:TVA_INTERET_RETARD,:MONATANT_PENALITE_RETARD,:TVA_PENALITE_RETARD,:NUM_COMPTE_PAYEUR,:CODE_CATEGORIE,:NUM_DOSSIER_COMPLET,:NUMERO_LIGNE,:NUMERO_TIRAGE)");
    itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
    itemWriter.afterPropertiesSet();
             System.out.println("\nValider.JdbcBatchItemWriter\n");
    return itemWriter;
  }

//=>to file

    @SneakyThrows
    @Bean
    public FlatFileItemWriter<IMPAYES_CDL> writerToFile() {
        System.out.println("\nValider.FlatFileItemWriter\n");
        FlatFileItemWriter<IMPAYES_CDL> writer = new FlatFileItemWriter<>();
        writer.setResource((WritableResource) outputResource);  //reject.txt
        writer.setAppendAllowed(true);    //All job repetitions should "append" to same output file
        writer.setLineAggregator(getDelimitedLineAggregator());
        writer.afterPropertiesSet();
        return writer;
    }
     private DelimitedLineAggregator<IMPAYES_CDL> getDelimitedLineAggregator() {
        BeanWrapperFieldExtractor<IMPAYES_CDL> beanWrapperFieldExtractor = new BeanWrapperFieldExtractor<>();
        beanWrapperFieldExtractor.setNames(new String[]{"Age", "NATENG", "TYPE","CPT","MONTANT_CREANCE","DATE_CREANCE",
                "NO_DOSSIER","DATE_ECHEANCE","DATE_MISE_IMPAYE","DATE_REGLEMENT","MONTANT_AMORTISSEMENT",
                "MONTANT_INTERET_NORMAL","TVA_INTERET","MONTANT_INTERET_RETARD","TVA_INTERET_RETARD",
                "MONATANT_PENALITE_RETARD","TVA_PENALITE_RETARD","NUM_COMPTE_PAYEUR","CODE_CATEGORIE",
                "NUM_DOSSIER_COMPLET","NUMERO_LIGNE","NUMERO_TIRAGE" });
        DelimitedLineAggregator<IMPAYES_CDL> aggregator = new DelimitedLineAggregator<>();
        aggregator.setDelimiter("|");
        aggregator.setFieldExtractor(beanWrapperFieldExtractor);
        return aggregator;
    }


    @Override
    public void write(@NotNull Chunk<? extends IMPAYES_CDL> chunk) throws Exception {

    }
}
