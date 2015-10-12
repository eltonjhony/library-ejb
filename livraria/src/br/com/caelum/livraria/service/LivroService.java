package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroService {

	@EJB
	private LivroDao livroDao;
	
	public void save(Livro livro) {
		livroDao.salva(livro);
	}
	
	public List<Livro> findAllBooks() {
		return livroDao.todosLivros();
	}

	public List<Livro> getFromTitle(String title) {
		return livroDao.getFromTitle(title);
	}
	
}
