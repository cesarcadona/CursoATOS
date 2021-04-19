package br.camc.projetoFinal.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.camc.projetoFinal.models.Estado;
import br.camc.projetoFinal.repositories.EstadoRepository;

@Named
@ViewScoped
public class EstadoController {
	
	@Autowired
    private EstadoRepository estadoRepository;
	
	private List<Estado> estados;
	
	

	@PostConstruct
	public void init() {
		setEstados(estadoRepository.findAll());
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
}
