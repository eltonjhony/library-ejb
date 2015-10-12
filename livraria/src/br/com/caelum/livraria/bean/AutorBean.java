package br.com.caelum.livraria.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.service.AutorService;

@Model
public class AutorBean {
	
	@Inject
	private Autor autor;
	
	@EJB
	private AutorService autorService;
	
	public Autor getAutor() {
		return autor;
	}
	
	public void cadastra() {
		this.autorService.save(autor);
		this.autor = new Autor();
	}
	
	public List<Autor> getAutores() {
		return this.autorService.findAllAuthor();
	}
}
