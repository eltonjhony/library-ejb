package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AutorDao {
	
	private static final String SELECT_ALL_AUTHOR = "select a from Autor a";
	
	@PersistenceContext
	private EntityManager entityManager;

	public void salva(Autor autor) {
		entityManager.persist(autor);
	}
	
	@SuppressWarnings("unchecked")
	public List<Autor> todosAutores() {
		return entityManager.createQuery(SELECT_ALL_AUTHOR).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = entityManager.find(Autor.class, autorId);
		return autor;
	}
	
}
