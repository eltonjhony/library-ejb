package br.com.caelum.livraria.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.service.LivroService;

@WebService
@Stateless
public class LivrariaWS {

	@EJB
	private LivroService livroService;
	
	@WebResult(name="books")
	public List<Livro> getFromTitle(@WebParam(name="title") String title) {		
		return livroService.getFromTitle(title);
	}
	
}
