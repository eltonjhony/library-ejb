package br.com.caelum.livraria.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.caelum.livraria.dao.UsuarioDao;
import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioService {

	@EJB
	private UsuarioDao usuarioDao;
	
	public Usuario findByLogin(String login) {
		return usuarioDao.buscaPeloLogin(login);
	}
}
