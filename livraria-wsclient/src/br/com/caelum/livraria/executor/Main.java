package br.com.caelum.livraria.executor;

import java.rmi.RemoteException;

import br.com.caelum.livraria.webservice.LivrariaWS;
import br.com.caelum.livraria.webservice.LivrariaWSProxy;
import br.com.caelum.livraria.webservice.Livro;

public class Main {
	
	public static void main(String args[]) {
		Livro[] books = null;
		LivrariaWS livrariaWSService = new LivrariaWSProxy();
		try {
			books = livrariaWSService.getFromTitle("Utunião");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		for (Livro book : books) {
			System.out.println("Title: "+book.getTitulo());
			System.out.println("Author: "+book.getAutor().getNome());
		}
	}

}
