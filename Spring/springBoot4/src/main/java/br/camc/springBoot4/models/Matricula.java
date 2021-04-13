package br.camc.springBoot4.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Matricula {
	
	@ApiModelProperty(notes = "id Matricula", name="id", required=true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(notes = "status matricula", name="status", required=true)
	@Column(nullable=false, columnDefinition = "boolean default true")
	boolean status;
	
	@ManyToOne
	private Estudante estudante;
	
	@ManyToOne
	private Disciplina disciplina;

	public Matricula() {
	}
	
	

	public Matricula(boolean status, Estudante estudante, Disciplina disciplina) {
		this.status = status;
		this.estudante = estudante;
		this.disciplina = disciplina;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}



	@Override
	public String toString() {
		return "Matricula [id=" + id + ", status=" + status + ", estudante=" + estudante + ", disciplina=" + disciplina
				+ "]";
	}

	
	
	
	
}
