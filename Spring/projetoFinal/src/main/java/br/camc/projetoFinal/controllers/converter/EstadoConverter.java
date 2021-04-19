package br.camc.projetoFinal.controllers.converter;

import java.util.Optional;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.camc.projetoFinal.models.Estado;
import br.camc.projetoFinal.repositories.EstadoRepository;

@Component
public class EstadoConverter implements Converter<Estado>{

	@Autowired
	EstadoRepository estadoRepository;
	
	@Override
	public Estado getAsObject(FacesContext context, UIComponent component, String value) {
		Optional<Estado> estado = estadoRepository.findById(Long.parseLong(value)); 
		return estado.get();
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Estado value) {
		return value.getId().toString();
	}
	

}
