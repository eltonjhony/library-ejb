package br.com.caelum.livraria.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.service.AutorService;
import br.com.caelum.livraria.service.LivroService;

@Model
public class LivroBean {
	
	@Inject
	private Livro livro;
	private Integer autorId;
	
	@EJB
	private LivroService livroService;
	
	@EJB
	private AutorService autorService;

	public void cadastra() {
		Autor autor = this.autorService.findById(this.autorId);
		this.livro.setAutor(autor);
		this.livroService.save(livro);
		this.livro = new Livro();
	}

	public List<Autor> getAutores() {
		return autorService.findAllAuthor();
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
	public Integer getAutorId() {
		return autorId;
	}
	
	public List<Livro> getLivros() {
		return this.livroService.findAllBooks();
	}
}
