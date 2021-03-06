package com.websystique.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String areg[]){
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-batch-context.xml");
		
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("examResultJob");
	 
		try {
			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Eccezione Job Exit Status : "+ execution.getStatus());
	 
		} catch (JobExecutionException e) {
			System.out.println("Job ExamResult fallitos");
			e.printStackTrace();
		}
	}

}

/*
 * Right-click on your project
	Click Properties
	Java build path: Libraries; Remove the "JRE System Library[J2SE 1.5]"
	Click Add Library -> JRE System Library
 */
