package com.vamshi.proj.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class Student {
  private long id;
  private String name;
  private String address;
  private String course;
}
