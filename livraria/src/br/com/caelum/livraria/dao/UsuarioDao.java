package br.com.caelum.livraria.dao;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UsuarioDao {

	private static final String SELECT_USER_BY_LOGIN = "select u from Usuario u where u.login=:pLogin";
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Usuario buscaPeloLogin(String login) {
		return (Usuario) this.entityManager
				.createQuery(SELECT_USER_BY_LOGIN)
				.setParameter("pLogin", login).getSingleResult();
	}
	
}
