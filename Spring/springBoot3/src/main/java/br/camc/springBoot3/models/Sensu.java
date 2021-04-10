package br.camc.springBoot3.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Sensu {
	
	@ApiModelProperty(notes = "id Sensu", name="id", required=true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ApiModelProperty(notes = "Ano do Sensu", name="year", required=true, value="Ano do Sensu")
	@Column(nullable = false)
	private int year;
	@ApiModelProperty(notes = "População do Sensu", name="population", required=true, value="População do Sensu")
	@Column(nullable = false)
	private int population;
	
	
	public Sensu() {
		
	}


	public Sensu(Long id, int year, int population) {
		super();
		this.id = id;
		this.year = year;
		this.population = population;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getPopulation() {
		return population;
	}


	public void setPopulation(int population) {
		this.population = population;
	}
	
	
	
	

}
