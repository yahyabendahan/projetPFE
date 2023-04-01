package com.example.cdl1.Component.FichierPlat.FichierECH;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;

public class FichierECHItemReader implements ItemReader<FichierECH> {

    @Bean
    public FlatFileItemReader<FichierECH> flatFileItemReader()  throws Exception {
        FlatFileItemReader<FichierECH> itemReader = new FlatFileItemReader<>();
        System.out.println("\nValider.FlatFileItemReader0\n");
        itemReader.setResource(new FileSystemResource("C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\CDL_ECH.CSV"));
        DefaultLineMapper<FichierECH> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter("|");
        lineTokenizer.setStrict(false);

        lineTokenizer.setNames("Age","NATENG","TYPE");
        lineTokenizer.setIncludedFields(new int[] { 0, 1, 2 });
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(new FichierECHFieldSetMapper());    //lineMapper.setTargetType()
        itemReader.setLineMapper(lineMapper);

        return itemReader;
    }

    @Override
    public FichierECH read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }
}
