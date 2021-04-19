package br.camc.projetoFinal.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CarouselView {
	
	private List<String> images = new ArrayList<String>();
	
	@PostConstruct
	public void init() {
		images.add("images/atos.png");
		images.add("images/ufn.png");
		
	}
	
	
	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}
	
	

}
