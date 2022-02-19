package com.vamshi.proj.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Employee {
  private Long eid;
  private String name;
  private String address;
  private List<Long> contacts;
}
