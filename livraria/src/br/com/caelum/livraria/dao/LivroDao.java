package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class LivroDao {

	private static final String SELECT_ALL_BOOKS = "select l from Livro l";
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salva(Livro livro) {
		entityManager.persist(livro);
	}
	
	@SuppressWarnings("unchecked")
	public List<Livro> todosLivros() {
		List<Livro> livros = entityManager.createQuery(SELECT_ALL_BOOKS).getResultList();
		
		return livros;
	}

	public List<Livro> getFromTitle(String title) {
		TypedQuery<Livro> query = entityManager.createQuery(
				"select l from Livro l where l.titulo like :pTitle", Livro.class);
		query.setParameter("pTitle", title + "%");

		return query.getResultList();
	}
	
}
