package com.vamshi.proj.config;

import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vamshi.proj.listener.JobComplitionLister;
import com.vamshi.proj.model.ReaderIO;
import com.vamshi.proj.model.WriterIO;
import com.vamshi.proj.procesor.CustomProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	   @Autowired
	    private JobBuilderFactory jobBuilderFactory;

	    @Autowired
	    private StepBuilderFactory stepBuilderFactory;

	    @Autowired
	    private DataSource dataSource;
	
	    @Bean
	    public ItemReader<ReaderIO> reader() {
	        return new JdbcCursorItemReaderBuilder<ReaderIO>().name("the-reader")
	                .sql("select id, first_name, last_name, random_num from readerio").dataSource(dataSource)
	                 .rowMapper((ResultSet resultSet, int rowNum) -> {
	                    if (!(resultSet.isAfterLast()) && !(resultSet.isBeforeFirst())) {
	                        ReaderIO readerio = new ReaderIO();
	                        readerio.setFirstName(resultSet.getString("first_name"));
	                        readerio.setLastName(resultSet.getString("last_name"));
	                        readerio.setId(resultSet.getInt("id"));
	                        readerio.setRandomNum(resultSet.getString("random_num"));

	                        
	                        return readerio;
	                    } else {
	                        
	                        return null;
	                    }
	                }).build();
	    }
	    
	    
	    @Bean
	    public ItemProcessor<ReaderIO, WriterIO> processor() {
	        return new CustomProcessor();
	    }

	    @Bean
	    public JdbcBatchItemWriter<WriterIO> writer(DataSource dataSource, ItemPreparedStatementSetter<WriterIO> setter) {
	        return new JdbcBatchItemWriterBuilder<WriterIO>()
	                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	                .itemPreparedStatementSetter(setter)
	                .sql("insert into writer (id, full_name, random_num) values (?,?,?)").dataSource(dataSource).build();
	    }
	    
	    
	    
	    @Bean
	    public ItemPreparedStatementSetter<WriterIO> setter() {
	        return (item, ps) -> {
	            ps.setLong(1, item.getId());
	            ps.setString(2, item.getFullName());
	            ps.setString(3, item.getRandomNum());
	        };
	    }
	    
	    @Bean
	    public Job importUserJob(JobComplitionLister listener, Step step1) {
	        return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener).flow(step1)
	                .end().build();
	    }

	    
	    @Bean
	    public Step step1(JdbcBatchItemWriter<WriterIO> writer, ItemReader<ReaderIO> reader) {
	        return stepBuilderFactory.get("step1").<ReaderIO, WriterIO>chunk(5).reader(reader).processor(processor())
	                .writer(writer).build();
	    }

}
