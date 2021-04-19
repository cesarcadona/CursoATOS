package br.camc.projetoFinal.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import br.camc.projetoFinal.models.Pessoa;
import br.camc.projetoFinal.repositories.PessoaRepository;

@Named
@ViewScoped
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	private List<Pessoa> pessoas;
	
	private Pessoa pessoa = new Pessoa();
	
	private boolean editMode = false;
	
	

	@PostConstruct
	public void init() {
		setPessoas(pessoaRepository.findAll());
		
	}
	
	public void salvar() {
		pessoaRepository.save(pessoa);
		if(!editMode)
			pessoas.add(pessoa);
		pessoa = new Pessoa();
		editMode = false;
	}
	
	public void excluir(Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
		pessoas.remove(pessoa);
	}
	
	public void alterar(Pessoa pessoa) {
		setPessoa(pessoa);
		editMode = true;
	}
	
	public void cancelar() {
		pessoa = new Pessoa();
		editMode = false;
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}
	
}
