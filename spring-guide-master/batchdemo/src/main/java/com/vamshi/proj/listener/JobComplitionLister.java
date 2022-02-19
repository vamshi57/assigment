package com.vamshi.proj.listener;

import java.util.List;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.vamshi.proj.model.WriterIO;

@Component
public class JobComplitionLister  extends JobExecutionListenerSupport{
	private final JdbcTemplate jdbcTemplate;

	public JobComplitionLister(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		
		   if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
	           System.out.println("the job completed");
	            List<WriterIO> results = jdbcTemplate.query("SELECT id, full_name, random_num FROM writer", (rs, row) -> {
	                WriterIO writerIO = new WriterIO();
	                writerIO.setId(rs.getLong("id"));
	                writerIO.setFullName(rs.getString("full_name"));
	                writerIO.setRandomNum(rs.getString("random_num"));
	                return writerIO;
	            });
		   
	            for (WriterIO writerIO : results) {
	                System.out.println("Found <" + writerIO + "> in the database.");
	            }
		   }     
	            
	            
		super.afterJob(jobExecution);
	}

}
