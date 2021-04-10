package br.camc.springBoot3.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Individuo {

	@ApiModelProperty(notes = "id Individuo", name="id", required=true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(notes = "Individuo nome", name="name", required=true, value="Individuo nome")
	@Column(nullable = false)
	private String name;
	
	
	@ApiModelProperty(notes = "Individuo Tipo", name="type", required=true, value="Individuo Tipo")
	@Column(nullable = false)
	private String type;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
}
