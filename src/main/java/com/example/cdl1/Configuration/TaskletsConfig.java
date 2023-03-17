package com.example.cdl1.Configuration;


import com.example.cdl1.FichierCDL.FichierECH;
import com.example.cdl1.FichierCDL.FichierECHFieldSetMapper;
import com.example.cdl1.FichierCDL.FichierECHResultRowMapper;
import com.example.cdl1.TableBD.TYPE_DOSSIER;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableBatchProcessing
public class TaskletsConfig {

    //@Autowired
    private JobBuilder jobBuilders;

    //@Autowired
    private StepBuilder stepBuilders;

    //@Autowired
    private DataSource dataSource;

    @Bean
    public Job job() {
        return jobBuilders
                //.get
                .incrementer(new RunIdIncrementer())
                .start(Step1())
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
    @Bean
    protected Step Step1() {
        return stepBuilders
              //  .get("readLines")
                .tasklet(new linesReader())
                .tasklet(new linesProcessor())
                .tasklet(new linesWriter())
                .build();
    }

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


    // ...



  //  @ResponseBody



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

          lineTokenizer.setNames("l","NATENG","TYPE");
          lineMapper.setLineTokenizer(lineTokenizer);
          lineMapper.setFieldSetMapper(new FichierECHFieldSetMapper());
          itemReader.setLineMapper(lineMapper);
          itemReader.open(new ExecutionContext());
          FichierECH FichierECH = itemReader.read();

          return itemReader;
      }

    }



    //LinesProcessor will calculate the age for every person in the file:
    public class linesProcessor implements Tasklet {
        @Override
        public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
            return null;
        }
        // ...

//JdbcCursorItemReader ?
        /* setDataSource ?
         *setSql ?
         *setRowMapper ?*/
    @Bean
    public JdbcCursorItemReader<FichierECH> FichierECH() throws SQLException {

        JdbcCursorItemReader<FichierECH> fichierech = new JdbcCursorItemReader<>();
        fichierech.setDataSource(dataSource);
        fichierech.setSql("select NATENG from FichierECH");
        fichierech.setRowMapper(new FichierECHResultRowMapper());

        JdbcCursorItemReader<FichierECH> fichierech2 = new JdbcCursorItemReader<>();
        fichierech2.setDataSource(dataSource);
        fichierech2.setSql("select TYPE from FichierECH");
        fichierech2.setRowMapper(new FichierECHResultRowMapper());

        JdbcCursorItemReader<TYPE_DOSSIER> TYPE_DOSSIER = new JdbcCursorItemReader<>();
        TYPE_DOSSIER.setDataSource(dataSource);
        TYPE_DOSSIER.setSql("select LIBELLE_COURT from TYPE_DOSSIER");



        //flatFileItemReader
        //while(fichierech.setMaxRows(5)>int i)
        if(fichierech.toString()=="ECH")
            if(fichierech2.toString()==TYPE_DOSSIER.toString()){
                System.out.println("*envoye vers table IMPAYES_CDL*");
                // insert row(fichierech) in IMPAYES_CDL /

                //stmt1 = con1.prepareCall("insert into IMPAYES_CDL(NATENG,TYPE) values(fichierech.toString(),fichierech2.toString() )");

                // String Result1 = String.valueOf(stmt1.executeQuery("insert into IMPAYES_CDL(NATENG,TYPE) values(fichierech.toString(),fichierech2.toString())"));
            }
            else {
                System.out.println("*envoyée la ligne vers fichier 'rejetech.txt'*");
                // insert row(fichierech) in rejetech.txt
            }



        //end while
        return null;
    }

    }




    //Finally, LinesWriter will have the responsibility of writing names and ages to an output file:
    public class linesWriter implements Tasklet {
        @Override
        public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
            return null;
        }
        // ...
        /*
         @Bean
  public JdbcBatchItemWriter<FichierECH> writer() {
    JdbcBatchItemWriter<FichierECH> itemWriter = new JdbcBatchItemWriter<FichierECH>();
    itemWriter.setDataSource(dataSource());
    itemWriter.setSql("INSERT INTO EMPLOYEE (ID, FIRSTNAME, LASTNAME) VALUES (:id, :firstName, :lastName)");
    itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<FichierECH>());
    return itemWriter;
  }
         */
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
