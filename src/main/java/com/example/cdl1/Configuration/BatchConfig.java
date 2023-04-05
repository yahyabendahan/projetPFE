package com.example.cdl1.Configuration;

import com.example.cdl1.Component.FichierPlat.FichierECH.FichierECH;
import com.example.cdl1.Component.FichierPlat.FichierECH.FichierECHItemProcessor;
import com.example.cdl1.Component.FichierPlat.FichierECH.FichierECHItemReader;
import com.example.cdl1.Component.FichierPlat.FichierECH.FichierECHItemWriter;
import com.example.cdl1.Component.FichierPlat.FichierSBF.FichierSBF;
import com.example.cdl1.Component.FichierPlat.FichierSBF.FichierSBFItemProcessor;
import com.example.cdl1.Component.FichierPlat.FichierSBF.FichierSBFItemReader;
import com.example.cdl1.Component.FichierPlat.FichierSBF.FichierSBFItemWriter;
import com.example.cdl1.Component.TableBD.IMPAYES_CDL;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collection;
import java.util.logging.Logger;

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

    FichierECH fichierech = new FichierECH();
    FichierECHItemReader echread=new FichierECHItemReader();
    FichierECHItemProcessor proces = new FichierECHItemProcessor();
    FichierECHItemWriter write = new FichierECHItemWriter();
    FichierSBF fichiersbf = new FichierSBF();
    FichierSBFItemReader sbfread =new FichierSBFItemReader();
    FichierSBFItemProcessor sbfproces = new FichierSBFItemProcessor();
    FichierSBFItemWriter sbfwriter = new FichierSBFItemWriter();


    JobRepository repo=new JobRepository() {
        @Override
        public boolean isJobInstanceExists(String jobName, JobParameters jobParameters) {
            return false;
        }

        @Override
        public JobInstance createJobInstance(String jobName, JobParameters jobParameters) {
            return null;
        }

        @Override
        public JobExecution createJobExecution(String jobName, JobParameters jobParameters) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
            return null;
        }

        @Override
        public void update(JobExecution jobExecution) {

        }

        @Override
        public void add(StepExecution stepExecution) {

        }

        @Override
        public void addAll(Collection<StepExecution> stepExecutions) {

        }

        @Override
        public void update(StepExecution stepExecution) {

        }

        @Override
        public void updateExecutionContext(StepExecution stepExecution) {

        }

        @Override
        public void updateExecutionContext(JobExecution jobExecution) {

        }

        @Override
        public StepExecution getLastStepExecution(JobInstance jobInstance, String stepName) {
            return null;
        }

        @Override
        public long getStepExecutionCount(JobInstance jobInstance, String stepName) {
            return 0;
        }

        @Override
        public JobExecution getLastJobExecution(String jobName, JobParameters jobParameters) {
            return null;
        }
    };

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
    } //not doing its work

    /*@Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    } //not doing its work
    */

    public DataSource dataSource= new DataSource() {
        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            return null;
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return false;
        }

        @Override
        public Connection getConnection() throws SQLException {
            return null;
        }

        @Override
        public Connection getConnection(String username, String password) throws SQLException {
            return null;
        }

        @Override
        public PrintWriter getLogWriter() throws SQLException {
            return null;
        }

        @Override
        public void setLogWriter(PrintWriter out) throws SQLException {

        }

        @Override
        public void setLoginTimeout(int seconds) throws SQLException {

        }

        @Override
        public int getLoginTimeout() throws SQLException {
            return 0;
        }

        @Override
        public Logger getParentLogger() throws SQLFeatureNotSupportedException {
            return null;
        }
    };// datasource
   /* @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }*/

     @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    /*@Bean
    protected JobRepository createJobRepository() throws Exception {
        JobRepositoryFactoryBean factory  = new JobRepositoryFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTransactionManager(transactionManager());
        factory.setDatabaseType("ORACLE");

        factory.afterPropertiesSet();
        return factory.getObject();
    }*/
    // jobRepositoryFactoryBean.setTransactionManager(transactionManager);

    	@Bean
	public Job job() throws Exception {
            System.out.println("\nValider.Job\n");
            jobBuilders =new JobBuilderFactory(repo);
            stepBuilders =new StepBuilderFactory(repo);//createJobRepository()

            Step StepECH=stepBuilders.get("StepECH")
                    .<FichierECH,IMPAYES_CDL>chunk(10)//,transactionManager()
                    .reader(readerECH()) //.reader(JdbcCursorItemReader())
                    .processor(processorECH())
                    .writer(writerECH()) //.writer(writerToFile())
                    .transactionManager(transactionManager())
                    // .faultTolerant()// .retryLimit(3)// .retry(Exception.class)// .taskExecutor(taskExecutor())
                    .build();

            Step StepSBF=stepBuilders.get("StepSBF")
                    .<FichierSBF,IMPAYES_CDL>chunk(10)//,transactionManager()
                    .reader(readerSBF()) //.reader(JdbcCursorItemReader())
                    .processor(processorSBF())
                    .writer(writerSBF()) //.writer(writerToFile())
                    .transactionManager(transactionManager())
                    // .faultTolerant()// .retryLimit(3)// .retry(Exception.class)// .taskExecutor(taskExecutor())
                    .build();

        return jobBuilders
                .get("job")
                //traitement des fichiers entrees
                .incrementer(new RunIdIncrementer())
                .start(StepECH)
                .next(StepSBF)
                .build();
	}


    /* @Bean
    public Step StepECH() throws Exception {
         System.out.println("\nValider.StepECH\n");
         stepBuilders =new StepBuilderFactory(repo);//createJobRepository()
         return stepBuilders.get("StepECH")
                 .<FichierECH,IMPAYES_CDL>chunk(10)//,transactionManager()
                 .reader(readerECH()) //.reader(JdbcCursorItemReader())
                 .processor(processorECH())
                 .writer(writerECH()) //.writer(writerToFile())
                 .transactionManager(transactionManager())
                // .faultTolerant()// .retryLimit(3)// .retry(Exception.class)// .taskExecutor(taskExecutor())
                 .build();
    }*/ //stepech
    /*@Bean
    public Step StepSBF() throws Exception {
        System.out.println("\nValider.StepSBF\n");
        stepBuilders =new StepBuilderFactory(repo);//createJobRepository()
        return stepBuilders.get("StepECH")
                .<FichierECH,IMPAYES_CDL>chunk(10)//,transactionManager()
                .reader(readerSBF()) //.reader(JdbcCursorItemReader())
                .processor(processorSBF())
                .writer(writerSBF()) //.writer(writerToFile())
                .transactionManager(transactionManager())
                // .faultTolerant()// .retryLimit(3)// .retry(Exception.class)// .taskExecutor(taskExecutor())
                .build();*/ //stepsbf


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

        @Bean
        public ItemReader readerECH() throws Exception {
            System.out.println("\nValider.ItemReaderECH\n");
            echread.flatFileItemReader();
            return  echread;
        }
        @Bean
        public ItemProcessor processorECH() throws Exception {
            System.out.println("\nValider.ItemProcessorECH\n");
            proces.process( fichierech);
            return proces;
        }
        @Bean
        public ItemWriter writerECH(){
            System.out.println("\nValider.ItemWriterECH\n");
            write.writerToBD(dataSource);
            write.writerToFile();
            return write;
        }
          @Bean
          public ItemReader readerSBF() throws Exception {
              System.out.println("\nValider.ItemReaderSBF\n");
              sbfread.flatFileItemReader();
             return  sbfread;
    }
         @Bean
         public ItemProcessor processorSBF() throws Exception {
              System.out.println("\nValider.ItemProcessorSBF\n");
              sbfproces.process(fichiersbf);
              return sbfproces;
    }
    @Bean
          public ItemWriter writerSBF(){
             System.out.println("\nValider.ItemWriterSBF\n");
             sbfwriter.writerToBD(dataSource);
             sbfwriter.writerToFile();
             return sbfwriter;
    }

/*
    //Finally, LinesWriter will have the responsibility of writing ... to an output file:
    private Resource outputResource = new FileSystemResource("C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\FichierRejet\\CDL_ECH_FAILS.CSV");


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


