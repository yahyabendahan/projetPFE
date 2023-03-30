/*package com.example.cdl1.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Cdl1Application {

    public static void main(String[] args) {
        System.out.println("run.Cdl1Application1");
        SpringApplication.run(Cdl1Application.class, args);
        System.out.println("run.Cdl1Application2");
    }

}

*/


    /*
      @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    public static void main(String[] args)
    {
        SpringApplication.run(App.class, args);
    }


    public void perform() throws Exception
    {
        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        jobLauncher.run(job, params);
    }
     */
    /*
     public static void main(String[] args) throws Exception {

      String[] springConfig  =  { "jobs/job_hello_world.xml" };

      // Creating the application context object
      ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

      // Creating the job launcher
      JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");

      // Creating the job
      Job job = (Job) context.getBean("helloWorldJob");

      // Executing the JOB
      JobExecution execution = jobLauncher.run(job, new JobParameters());
      System.out.println("Exit Status : " + execution.getStatus());
   }
     */
