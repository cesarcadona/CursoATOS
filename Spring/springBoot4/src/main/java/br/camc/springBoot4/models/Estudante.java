package br.camc.springBoot4.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Estudante{
	@ApiModelProperty(notes = "id Estudante", name="id", required=true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(notes = "nome Estudante", name="nome", required=true)
	@Column(nullable = false)
	private String nome;
	
	@ApiModelProperty(notes = "email Estudante", name="email", required=true)
	@Column(nullable = false)
	private String email;
	
	@ApiModelProperty(notes = "matricula Estudante", name="matricula", required=true)
	@Column(nullable = false)
	private Long matricula;
	
	@ApiModelProperty(notes = "data-nascimento Estudante", name="dataNasc", required=true)
	@Column(nullable = false)
	private String dataNasc;
	
	@ApiModelProperty(notes = "nacionalidade Estudante", name="nacionalidade", required=true)
	@Column(nullable = false)
	private String nacionalidade;
	
	
	
	public Estudante() {
		
	}



	public Estudante(Long id, String nome, String email, Long matricula, String dataNasc, String nacionalidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
		this.dataNasc = dataNasc;
		this.nacionalidade = nacionalidade.toUpperCase();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Long getMatricula() {
		return matricula;
	}



	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}



	public String getDataNasc() {
		return dataNasc;
	}



	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}



	public String getNacionalidade() {
		return nacionalidade;
	}



	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade.toUpperCase();
	}



	@Override
	public String toString() {
		return "Estudante [id=" + id + ", nome=" + nome + ", email=" + email + ", matricula=" + matricula
				+ ", dataNasc=" + dataNasc + ", nacionalidade=" + nacionalidade + "]";
	}


	
	
	
	

}
