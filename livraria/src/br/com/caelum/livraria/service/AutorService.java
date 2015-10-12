package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorService {
	
	@EJB
	private AutorDao autorDao;
	
	public void save(Autor autor) {
		autorDao.salva(autor);
	}
	
	public List<Autor> findAllAuthor() {
		return autorDao.todosAutores();
	}
	
	public Autor findById(Integer autorId) {
		return autorDao.buscaPelaId(autorId);
	}

}
