package com.example.cdl1.Configuration;


import com.example.cdl1.Component.FichierPlat.FichierECH.FichierECH;
import com.example.cdl1.Component.FichierPlat.FichierECH.FichierECHFieldSetMapper;
import com.example.cdl1.Component.FichierPlat.FichierECH.FichierECHItemProcessor;
import com.example.cdl1.Component.TableBD.IMPAYES_CDL;
import com.example.cdl1.Component.TableBD.TYPE_DOSSIER;
import com.example.cdl1.Component.TableBD.TYPE_DOSSIERResultRowMapper;
import com.example.cdl1.ItemReader;
import jakarta.validation.constraints.NotNull;
import lombok.SneakyThrows;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.builder.SimpleJobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@SpringBootApplication
@EnableBatchProcessing
public class BatchConfig {


    public static void main(String[] args) {

            System.out.println("run.Cdl1Application1");
            SpringApplication.run(BatchConfig.class, args);
            System.out.println("run.Cdl1Application2");
        }

    @Autowired(required = false)
    private SimpleJobBuilder jobBuilders;

    @Autowired(required = false)
    private SimpleStepBuilder stepBuilders;

    @Autowired
    private DataSource dataSource;



    	@Bean
	public Job job() throws Exception {

        return jobBuilders                //traitement des fichiers entrees
                .incrementer(new RunIdIncrementer())
                .start(StepECH())
                .build();
	}



     @Bean
    public Step StepECH() throws Exception {
        return stepBuilders
                .reader(flatFileItemReader())
                .reader(JdbcCursorItemReader())
                .processor(processor())
                .writer(writerToBD())
                .writer(writerToFile())
                .faultTolerant()
                .retryLimit(3)
                .retry(Exception.class)
                .build();
    }

/*
    @Bean
    public Job job() throws Exception {
        System.out.println("run.beforejob");
        //stepBuilders =new SimpleStepBuilder();
        Step Step1= stepBuilders                 //  .get("fichierECH")
                .reader(flatFileItemReader())
                .reader(JdbcCursorItemReader())
                .processor(processor())
                .writer(writerToBD())
                .writer(writerToFile())
            //    .writer(new linesProcessor(),transactionManager)
              //  .processor(new linesWriter(),transactionManager)
              //  .allowStartIfComplete(true)
                .build();
        System.out.println("run.Afterjob");


        //Step Step2 =stepBuilders.
        //...

        return jobBuilders                //traitement des fichiers entrees
                .incrementer(new RunIdIncrementer())
                .start(Step1)
                .build();


    }
*/
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
          lineMapper.setFieldSetMapper(new FichierECHFieldSetMapper());
          itemReader.setLineMapper(lineMapper);
          System.out.println("\nValider.FlatFileItemReader1\n");
          return itemReader;
      }
        @Bean
        public JdbcCursorItemReader<TYPE_DOSSIER> JdbcCursorItemReader() throws SQLException {
            System.out.println("\nValider.JdbcCursorItemReader1\n");

            JdbcCursorItemReader<TYPE_DOSSIER> TYPE_DOSSIER = new JdbcCursorItemReader<>();
            TYPE_DOSSIER.setDataSource(dataSource);
            TYPE_DOSSIER.setSql("select LIBELLE_COURT from TYPE_DOSSIER");
            TYPE_DOSSIER.setRowMapper(new TYPE_DOSSIERResultRowMapper());
            System.out.println("\nValider.JdbcCursorItemReader2\n");

            return TYPE_DOSSIER;
        }

        @Bean
        public FichierECHItemProcessor processor()  {
            return new FichierECHItemProcessor();
        }


    //Finally, LinesWriter will have the responsibility of writing ... to an output file:
    private Resource outputResource = new FileSystemResource("C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\FichierRejet\\RejetECH.CSV");


    //=>to BD
         @Bean
  public JdbcBatchItemWriter<IMPAYES_CDL> writerToBD() {
    JdbcBatchItemWriter<IMPAYES_CDL> itemWriter = new JdbcBatchItemWriter<>();
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
        beanWrapperFieldExtractor.setNames(new String[]{"Age", "NATENG", "TYPE","CPT","MONTANT_CREANCE","DATE_CREANCE","NO_DOSSIER","DATE_ECHEANCE","DATE_MISE_IMPAYE","DATE_REGLEMENT","MONTANT_AMORTISSEMENT","MONTANT_INTERET_NORMAL","TVA_INTERET","MONTANT_INTERET_RETARD","TVA_INTERET_RETARD","MONATANT_PENALITE_RETARD","TVA_PENALITE_RETARD","NUM_COMPTE_PAYEUR","CODE_CATEGORIE","NUM_DOSSIER_COMPLET","NUMERO_LIGNE","NUMERO_TIRAGE" });
        DelimitedLineAggregator<IMPAYES_CDL> aggregator = new DelimitedLineAggregator<>();
        aggregator.setDelimiter("|");
        aggregator.setFieldExtractor(beanWrapperFieldExtractor);
        return aggregator;
    }



}


