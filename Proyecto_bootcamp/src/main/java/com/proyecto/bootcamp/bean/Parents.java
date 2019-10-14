package com.proyecto.bootcamp.bean;

import java.io.Serializable;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;






@Document(collection = "Parents")
public class Parents{

	
	@Id
     private  String _id;
	 
	 private String complementName;
	
	
	private String sex;
	
	private String dateBirth;
	
	private String typeidentify;
	
	
	private int  numberidentify;
	
	
	
	
	


	
	
	
	
	
	
	


	public Parents(String _id, String complementName, String sex, String dateBirth, String typeidentify,
			int numberidentify) {
		super();
		this._id = _id;
		this.complementName = complementName;
		this.sex = sex;
		this.dateBirth = dateBirth;
		this.typeidentify = typeidentify;
		this.numberidentify = numberidentify;
	}










	public String get_id() {
		return _id;
	}










	public void set_id(String _id) {
		this._id = _id;
	}










	public String getComplementName() {
		return complementName;
	}


	public void setComplementName(String complementName) {
		this.complementName = complementName;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getDateBirth() {
		return dateBirth;
	}


	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}


	public String getTypeidentify() {
		return typeidentify;
	}


	public void setTypeidentify(String typeidentify) {
		this.typeidentify = typeidentify;
	}


	public int getNumberidentify() {
		return numberidentify;
	}


	public void setNumberidentify(int numberidentify) {
		this.numberidentify = numberidentify;
	}


	
	
	

	
	

	
	
}
