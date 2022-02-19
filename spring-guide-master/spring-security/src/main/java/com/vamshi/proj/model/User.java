package com.vamshi.proj.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "user_security")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="uid")
	private Long usrId;
	
	@Column(name="uname")
	private String usrName;
	
	@Column(name="uemail")
	private String usrMail;
	
	@Column(name="upwd")
	private String usrPwd;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="rolestab",joinColumns =@JoinColumn(name="uid"))
	@Column(name="urole")
	private Set<String> usrRoles;

	
}
