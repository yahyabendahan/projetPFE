package com.example.cdl1.Component.FichierPlat.FichierSBF;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

public class FichierSBFItemReader implements ItemReader<FichierSBF> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(FichierSBFItemReader.class);

    @Bean
    public FlatFileItemReader<FichierSBF> flatFileItemReader()  throws Exception {
        FlatFileItemReader<FichierSBF> itemReader = new FlatFileItemReader<>();
        System.out.println("\nValider.FlatFileItemReader<FichierSBF\n");
        itemReader.setResource(new ClassPathResource("CDL_SBF.CSV"));
        //itemReader.setResource(new FileSystemResource("C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\CDL_ECH.CSV"));
        itemReader.setName("CDL_SBF");
        LOGGER.info("itemReader setResource is set: {}", itemReader);
        DefaultLineMapper<FichierSBF> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter("|");
        lineTokenizer.setStrict(false);

        lineTokenizer.setNames("Age", "NATENG", "TYPE","CPT","RAISON_SOCIAL",
                "MONTANT_CREANCE","DATE_CREANCE", "ID_CLIENT","NO_DOSSIER",
                "REFFERENCE_VALEUR","CODE_ETABLISST_BANCAIRE","CODE_GUICHET_BANCAIRE",
                "Date_Remise","REFERNCE_LIAISON","CODE_REJET","COMISSION","Field16",
                "Field17");
        //lineTokenizer.setIncludedFields(new int[] { 0, 1, 2 });
        BeanWrapperFieldSetMapper<FichierSBF> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(FichierSBF.class);

        // lineMapper.setFieldSetMapper(new FichierSBFFieldSetMapper());    //lineMapper.setTargetType()
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        itemReader.setLineMapper(lineMapper);
        //itemReader.targetType(FichierSBF.class)
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
    public FichierSBF read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }
}

