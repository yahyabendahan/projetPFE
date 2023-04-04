package com.example.cdl1.Component.FichierPlat.FichierECH;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

public class FichierECHItemReader implements ItemReader<FichierECH> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(FichierECHItemReader.class);

    @Bean
    public FlatFileItemReader<FichierECH> flatFileItemReader()  throws Exception {
        FlatFileItemReader<FichierECH> itemReader = new FlatFileItemReader<>();
        System.out.println("\nValider.FlatFileItemReader0\n");
        itemReader.setResource(new ClassPathResource("CDL_ECH.CSV"));
        //itemReader.setResource(new FileSystemResource("C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\CDL_ECH.CSV"));
        itemReader.setName("ECH-Reader");
        LOGGER.info("itemReader setResource is set: {}", itemReader);
        DefaultLineMapper<FichierECH> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter("|");
        lineTokenizer.setStrict(false);

        lineTokenizer.setNames("Age", "NATENG", "TYPE","CPT","MONTANT_CREANCE","DATE_CREANCE",
                "NO_DOSSIER","DATE_ECHEANCE","DATE_MISE_IMPAYE","DATE_REGLEMENT","MONTANT_AMORTISSEMENT",
                "MONTANT_INTERET_NORMAL","TVA_INTERET","MONTANT_INTERET_RETARD","TVA_INTERET_RETARD",
                "MONATANT_PENALITE_RETARD","TVA_PENALITE_RETARD","NUM_COMPTE_PAYEUR","CODE_CATEGORIE",
                "NUM_DOSSIER_COMPLET","NUMERO_LIGNE","NUMERO_TIRAGE");
        //lineTokenizer.setIncludedFields(new int[] { 0, 1, 2 });
        BeanWrapperFieldSetMapper<FichierECH> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(FichierECH.class);

        // lineMapper.setFieldSetMapper(new FichierECHFieldSetMapper());    //lineMapper.setTargetType()
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        itemReader.setLineMapper(lineMapper);
        //itemReader.targetType(FichierECH.class)
        LOGGER.info("lineTokenizer is set: {}", lineTokenizer);
        LOGGER.info("fieldSetMapper is set: {}", fieldSetMapper);
        LOGGER.info("lineMapper is set: {}", lineMapper);
        LOGGER.info("itemReader is set: {}", itemReader);
        itemReader.afterPropertiesSet();
        // ExecutionContext executionContext = new ExecutionContext();
        // itemReader.open(executionContext);
        // itemReader.read();
        return itemReader;
    }

    @Override
    public FichierECH read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }
}
