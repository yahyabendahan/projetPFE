package com.example.cdl1.Component.FichierPlat.FichierSBF;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import javax.sql.DataSource;

public class FichierSBFItemWriter implements ItemWriter<IMPAYES_CDL> {


    @Value("classpath:FichierRejet\\CDL_SBF_FAILS.CSV")
    Resource OutputFile;

    //=>to BD
    @Bean
    public JdbcBatchItemWriter<IMPAYES_CDL> writerToBD(DataSource dataSource) {
        JdbcBatchItemWriter<IMPAYES_CDL> itemWriter = new JdbcBatchItemWriter<>();
        itemWriter.setDataSource(dataSource);

        //  itemWriter.setDataSource(dataSource());
        itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        itemWriter.setSql("INSERT INTO IMPAYES_CDL (Age,NATENG,TYPE,CPT,RAISON_SOCIAL,MONTANT_CREANCE,DATE_CREANCE,ID_CLIENT,NO_DOSSIER,REFFERENCE_VALEUR,CODE_ETABLISST_BANCAIRE,CODE_GUICHET_BANCAIRE,Date_Remise,REFERNCE_LIAISON,CODE_REJET,COMISSION,Field16,Field17)" +
                " VALUES (:Age,:NATENG,:TYPE,:CPT,:RAISON_SOCIAL,:MONTANT_CREANCE,:DATE_CREANCE,:ID_CLIENT,:NO_DOSSIER,:REFFERENCE_VALEUR,:CODE_ETABLISST_BANCAIRE,:CODE_GUICHET_BANCAIRE,:Date_Remise,REFERNCE_LIAISON,:CODE_REJET,:COMISSION,:Field16,:Field17)");
        itemWriter.setDataSource(dataSource);
        itemWriter.afterPropertiesSet();
        System.out.println("\nValider.JdbcFichierSBFItemWriter\n");
        return itemWriter;
    }
    //=>to file

    @SneakyThrows
    @Bean
    public FlatFileItemWriter<IMPAYES_CDL> writerToFile() {
        System.out.println("\nValider.FlatFileFichierSBFItemWriter\n");
        FlatFileItemWriter<IMPAYES_CDL> writer = new FlatFileItemWriter<>();
        writer.setResource((WritableResource) OutputFile);  //reject.txt
        writer.setAppendAllowed(true);    //All job repetitions should "append" to same output file
        writer.setLineAggregator(getDelimitedLineAggregator());
        writer.afterPropertiesSet();
        return writer;
    }
    private DelimitedLineAggregator<IMPAYES_CDL> getDelimitedLineAggregator() {
        BeanWrapperFieldExtractor<IMPAYES_CDL> beanWrapperFieldExtractor = new BeanWrapperFieldExtractor<>();
        beanWrapperFieldExtractor.setNames(new String[]{"Age", "NATENG", "TYPE","CPT","RAISON_SOCIAL",
                "MONTANT_CREANCE","DATE_CREANCE", "ID_CLIENT","NO_DOSSIER",
                "REFFERENCE_VALEUR","CODE_ETABLISST_BANCAIRE","CODE_GUICHET_BANCAIRE",
                "Date_Remise","REFERNCE_LIAISON","CODE_REJET","COMISSION","Field16",
                "Field17"});
        DelimitedLineAggregator<IMPAYES_CDL> aggregator = new DelimitedLineAggregator<>();
        aggregator.setDelimiter("|");
        aggregator.setFieldExtractor(beanWrapperFieldExtractor);
        return aggregator;
    }


    @Override
    public void write(Chunk<? extends IMPAYES_CDL> chunk) throws Exception {}
}
