package com.example.cdl1.Configuration;


import com.example.cdl1.Component.FichierPlat.FichierECH.FichierECH;
import com.example.cdl1.Component.FichierPlat.FichierECH.FichierECHFieldSetMapper;
import com.example.cdl1.Component.FichierPlat.FichierECH.FichierECHItemProcessor;
import com.example.cdl1.Component.FichierPlat.FichierECH.FichierECHFieldSetMapper;
import com.example.cdl1.Component.TableBD.TYPE_DOSSIER;
import com.example.cdl1.Component.TableBD.TYPE_DOSSIERResultRowMapper;
import lombok.SneakyThrows;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import javax.sql.DataSource;
import java.io.File;
import java.sql.SQLException;

//@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilder jobBuilders;

    @Autowired
    private StepBuilder stepBuilders;

    @Autowired
    private DataSource dataSource;


    @Bean
    public Job job() {
        Step Step1=stepBuilders
                //  .get("fichierECH")
                .tasklet(new linesReader())
                .tasklet(new linesProcessor())
                .tasklet(new linesWriter())
                .allowStartIfComplete(true)
                .build();
        //step step2
        //...

        return jobBuilders
                //traitement des fichiers entrees
                .incrementer(new RunIdIncrementer())
                .start(Step1)
                .build();
    }

    /*
      @Bean
  public Step step1() {
    return stepBuilderFactory
        .get("step1")
        .<Employee, Employee>chunk(1)
        .reader(reader())
        .processor(processor())
        .writer(writer())
        .build();
  }
  */


/*
    @Bean
    protected Step processLines() {
        return stepBuilders
                //.get("processLines")
                .tasklet(new linesProcessor())
                .build();
    }

    @Bean
    protected Step writeLines() {
        return stepBuilders
               // .get("writeLines")
                .tasklet(new linesWriter())
                .build();
    }
*/


    //LinesReader will be in charge of reading data from the input file:
    public class linesReader implements Tasklet {
        @Override
        public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
            return null;
        }

      @Bean
      FlatFileItemReader<FichierECH> flatFileItemReader() throws Exception {
          FlatFileItemReader<FichierECH> itemReader = new FlatFileItemReader<>();
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
      //    itemReader.open(new ExecutionContext());
       //   FichierECH FichierECH = itemReader.read();

          return itemReader;
      }
        @Bean
        public JdbcCursorItemReader<TYPE_DOSSIER> TYPE_DOSSIER() throws SQLException {

            JdbcCursorItemReader<TYPE_DOSSIER> TYPE_DOSSIER = new JdbcCursorItemReader<>();
            TYPE_DOSSIER.setDataSource(dataSource);
            TYPE_DOSSIER.setSql("select LIBELLE_COURT from TYPE_DOSSIER");
            TYPE_DOSSIER.setRowMapper(new TYPE_DOSSIERResultRowMapper());

            return TYPE_DOSSIER;
        }

    }



    //LinesProcessor will ...in the file:
    public class linesProcessor implements Tasklet {
        @Override
        public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
            return null;
        }
        // ...

        @Bean
        public FichierECHItemProcessor processor() {
            return new FichierECHItemProcessor();
        }

    }
/*
    @Value("C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\FichierRejet\\RejetECH*.txt")
    private Resource[] inputResources;
*/

    private Resource outputResource = new FileSystemResource("C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\FichierRejet\\RejetECH.csv");


    //Finally, LinesWriter will have the responsibility of writing ... to an output file:
    public class linesWriter implements Tasklet {
        private DataSource dataSource;

        @Override
        public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
            return null;
        }
        // ...

//=>to BD
         @Bean
  public JdbcBatchItemWriter<FichierECH> writerToBD() {
    JdbcBatchItemWriter<FichierECH> itemWriter = new JdbcBatchItemWriter<FichierECH>();
    itemWriter.setDataSource(this.dataSource);
    itemWriter.setSql("INSERT INTO IMPAYES_CDL (NATENG, TYPE, CPT, MONTANT_CREANCE, DATE_CREANCE, NO_DOSSIER, DATE_ECHEANCE, DATE_MISE_IMPAYE, DATE_REGLEMENT, MONTANT_AMORTISSEMENT, MONTANT_INTERET_NORMAL, TVA_INTERET, MONTANT_INTERET_RETARD, TVA_INTERET_RETARD, MONATANT_PENALITE_RETARD, TVA_PENALITE_RETARD, NUM_COMPTE_PAYEUR, CODE_CATEGORIE, NUM_DOSSIER_COMPLET, NUMERO_LIGNE, NUMERO_TIRAGE) VALUES (:NATENG,:TYPE,:CPT,:MONTANT_CREANCE,:DATE_CREANCE,:NO_DOSSIER,:DATE_ECHEANCE,:DATE_MISE_IMPAYE,:DATE_REGLEMENT,:MONTANT_AMORTISSEMENT,:MONTANT_INTERET_NORMAL,:TVA_INTERET,:MONTANT_INTERET_RETARD,:TVA_INTERET_RETARD,:MONATANT_PENALITE_RETARD,:TVA_PENALITE_RETARD,:NUM_COMPTE_PAYEUR,:CODE_CATEGORIE,:NUM_DOSSIER_COMPLET,:NUMERO_LIGNE,:NUMERO_TIRAGE)");
    itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<FichierECH>());
    itemWriter.afterPropertiesSet();

    return itemWriter;
  }

//=>to file

    @SneakyThrows
    @Bean
    public FlatFileItemWriter<FichierECH> writerToFile() {
        FlatFileItemWriter<FichierECH> writer = new FlatFileItemWriter<>();
        writer.setResource((WritableResource) outputResource);  //reject.txt
        writer.setAppendAllowed(true);    //All job repetitions should "append" to same output file
        writer.setLineAggregator(getDelimitedLineAggregator());
        writer.afterPropertiesSet();
        return writer;
    }
     private DelimitedLineAggregator<FichierECH> getDelimitedLineAggregator() {
        BeanWrapperFieldExtractor<FichierECH> beanWrapperFieldExtractor = new BeanWrapperFieldExtractor<FichierECH>();
        beanWrapperFieldExtractor.setNames(new String[]{"Age", "NATENG", "TYPE","CPT","MONTANT_CREANCE","DATE_CREANCE","NO_DOSSIER","DATE_ECHEANCE","DATE_MISE_IMPAYE","DATE_REGLEMENT","MONTANT_AMORTISSEMENT","MONTANT_INTERET_NORMAL","TVA_INTERET","MONTANT_INTERET_RETARD","TVA_INTERET_RETARD","MONATANT_PENALITE_RETARD","TVA_PENALITE_RETARD","NUM_COMPTE_PAYEUR","CODE_CATEGORIE","NUM_DOSSIER_COMPLET","NUMERO_LIGNE","NUMERO_TIRAGE" });
        DelimitedLineAggregator<FichierECH> aggregator = new DelimitedLineAggregator<FichierECH>();
        aggregator.setDelimiter("|");
        aggregator.setFieldExtractor(beanWrapperFieldExtractor);
        return aggregator;
    }

    }

}







/*
@Configuration
@EnableBatchProcessing
public class JobConfiguration {
    //@Autowired
    public JobBuilder jobBuilder;
    //@Autowired
    public StepBuilder stepBuilder;

    //@Autowired
    private ItemReader<FichierECH> FichierECHItemReader;
    //@Autowired
    private ItemWriter<FichierECH> FichierECHItemWriter;
    //@Autowired
    private ItemProcessor<FichierECH, FichierECH> itemProcessor;

    @Bean
    public Job myJob(){
       TaskletStep step = new TaskletStep(getName(Integer.parseInt("CDL-Fichier-File-Load")))
                .<FichierECH, FichierECH>chunk(10)
                .registerChunkListener ((ChunkListener) FichierECHItemReader)
                .writer (FichierECHItemWriter)
                .processor (itemProcessor)
                .build();
       Step step=stepBuilder.getName("CDL-Fichier-File-Load")
                .<FichierECH, FichierECH>chunk(10)
                .reader (FichierECHItemReader)
                .writer (FichierECHItemWriter) .processor (itemProcessor)
                .build();
        return jobBuilder.getName("CDL-Load")
                .incrementer(new RunIdIncrementer()) .start(step)
                .build();
    }
 */




    // At this point, all our steps implement Tasklet interface. That will force us to implement its execute method:

    //@Override
   /* public RepeatStatus execute(StepContribution stepContribution,
                                ChunkContext chunkContext) throws Exception {
        // ...
        return null;*/





//TaskletStep step = new TaskletStep(getName());



/*
﻿
@Configuration
@EnableBatchProcessing
public class SpringBatchConfiguration {
@Autowired private JobBuilderFactory jobBuilderFactory;
@Autowired private StepBuilderFactory stepBuilderFactory;
@Autowired private ItemReader<FichierECH> FichierECHItemReader;
@Autowired private ItemWriter<FichierECH> FichierECHItemWriter;
@Autowired private ItemProcessor<FichierECH, FichierECH> itemProcessor;
  @Bean
public Job myJob(){
Step step=stepBuilder.get("CDL-Fichier-File-Load")
.<FichierECH, FichierECH>chunk(10)
.reader (FichierECHItemReader)
.writer (FichierECHItemWriter) .processor (itemProcessor)
.build();
return jobBuilder.get("CDL-Load")
.incrementer(new RunIdIncrementer()) .start(step)
.build();
}
 */
