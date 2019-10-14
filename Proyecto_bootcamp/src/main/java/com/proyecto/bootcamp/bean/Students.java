package com.proyecto.bootcamp.bean;

import java.io.Serializable;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Students{


	 private String completeName;
	
	 
	 

	private String sex;
	
	 

	
	private String DateBirth;
	
	private String typeidentify;
	
	
	
	private int  numberidentify;
	
	
	
	
}
