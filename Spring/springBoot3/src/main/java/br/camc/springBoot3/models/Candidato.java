package br.camc.springBoot3.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Candidato {
	
	
	@ApiModelProperty(notes = "id Candidato", name="id", required=true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(notes = "Numero do Candidato", name="electionNumber", required=true, value="Numero do Candidato")
	@Column(nullable = false)
	private int electionNumber;
	
	@ApiModelProperty(notes = "Nome do Candidado", name="name", required=true, value="Nome da Candidato")
	@Column(nullable = false)
	private String name;
	
	@ApiModelProperty(notes = "Quantidade de votos do Candidado", name="votes", required=true, value="Quantidade de votos do Candidado")
	@Column(nullable = true)
	private int votes;

	public Candidato() {
		
	}

	public Candidato(Long id, int electionNumber, String name, int votes) {		
		this.id = id;
		this.electionNumber = electionNumber;
		this.name = name;
		this.votes = votes;
	}

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

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getElectionNumber() {
		return electionNumber;
	}

	public void setElectionNumber(int electionNumber) {
		this.electionNumber = electionNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + electionNumber;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + votes;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidato other = (Candidato) obj;
		if (electionNumber != other.electionNumber)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (votes != other.votes)
			return false;
		return true;
	}
	
	
	
	

}
