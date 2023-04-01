package com.example.cdl1.Configuration;

import com.example.cdl1.Component.FichierPlat.FichierECH.FichierECH;
import com.example.cdl1.Component.FichierPlat.FichierECH.FichierECHItemProcessor;
import com.example.cdl1.Component.FichierPlat.FichierECH.FichierECHItemReader;
import com.example.cdl1.Component.FichierPlat.FichierECH.FichierECHItemWriter;
import com.example.cdl1.Component.TableBD.IMPAYES_CDL;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@SpringBootApplication
@EnableBatchProcessing
//@EnableTransactionManagement
public class BatchConfig {


    public static void main(String[] args) {

            System.out.println("run.Cdl1Application1");
            SpringApplication.run(BatchConfig.class, args);
            System.out.println("run.Cdl1Application2");
        }

    private JobBuilderFactory jobBuilders;

    private StepBuilderFactory stepBuilders;


    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(8);
        executor.setQueueCapacity(20);
        return executor;
    }
    @Bean
    public MeterRegistry meterRegistry() {
        return new SimpleMeterRegistry();
    }
    @Autowired
    private DataSource dataSource;
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }


   /* @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }
    */
    @Bean
    protected JobRepository createJobRepository() throws Exception {
        JobRepositoryFactoryBean factory  = new JobRepositoryFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTransactionManager(transactionManager());
        factory.setDatabaseType("ORACLE");

        factory.afterPropertiesSet();
        return factory.getObject();
    }
   // jobRepositoryFactoryBean.setTransactionManager(transactionManager);






    	@Bean
	public Job job() throws Exception {
            System.out.println("\nValider.Job\n");
            jobBuilders =new JobBuilderFactory(createJobRepository());
        return jobBuilders
                .get("job")
                //traitement des fichiers entrees
                .incrementer(new RunIdIncrementer())
                .start(StepECH())
                //.next()
                .build();
	}



     @Bean
    public Step StepECH() throws Exception {
         System.out.println("\nValider.Step\n");
         stepBuilders =new StepBuilderFactory(createJobRepository());
         return stepBuilders.get("StepECH")
                 .<FichierECH,IMPAYES_CDL>chunk(10,transactionManager())
                 .reader(reader()) //.reader(JdbcCursorItemReader())
                 .processor(processor())
                 .writer(writer()) //.writer(writerToFile())
                // .faultTolerant()
                // .retryLimit(3)
                // .retry(Exception.class)
                 .taskExecutor(taskExecutor())
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
*/ //simplebuilder


      /*@Bean
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
      } */

        /*@Bean
        public JdbcCursorItemReader<TYPE_DOSSIER> JdbcCursorItemReader() throws SQLException {
            System.out.println("\nValider.JdbcCursorItemReader1\n");

            JdbcCursorItemReader<TYPE_DOSSIER> TYPE_DOSSIER = new JdbcCursorItemReader<>();
            TYPE_DOSSIER.setDataSource(dataSource);
            TYPE_DOSSIER.setSql("select LIBELLE_COURT from TYPE_DOSSIER");
            TYPE_DOSSIER.setRowMapper(new TYPE_DOSSIERResultRowMapper());
            System.out.println("\nValider.JdbcCursorItemReader2\n");

            return TYPE_DOSSIER;
        }*/


    public void afficher (){
        System.out.println("\nafficheritem=>\n");
    }
        @Bean
        public ItemReader reader(){
            System.out.println("\nValider.ItemReader\n");
            return new FichierECHItemReader();
        }
        @Bean
        public ItemProcessor/*<? super FichierECH, ? extends IMPAYES_CDL>*/ processor(){
            System.out.println("\nValider.ItemProcessor\n");
            return new FichierECHItemProcessor();
        }
        @Bean
        public ItemWriter writer(){
            System.out.println("\nValider.ItemWriter\n");
            return new FichierECHItemWriter();
        }

/*
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
 */


}


