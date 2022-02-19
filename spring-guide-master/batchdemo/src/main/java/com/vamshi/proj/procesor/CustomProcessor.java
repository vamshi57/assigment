package com.vamshi.proj.procesor;

import org.springframework.batch.item.ItemCountAware;
import org.springframework.batch.item.ItemProcessor;

import com.vamshi.proj.model.ReaderIO;
import com.vamshi.proj.model.WriterIO;


public class CustomProcessor  implements ItemProcessor<ReaderIO, WriterIO>{
	
	
	@Override
	public WriterIO process(ReaderIO item) throws Exception {
		 WriterIO writerio = new WriterIO();
	        writerio.setId(item.getId());
	        writerio.setFullName(item.getFirstName() + " " + item.getLastName());
	        writerio.setRandomNum(String.valueOf(Math.random()).substring(3, 8));
		return writerio;
	}

}
