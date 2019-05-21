package br.cinema.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest")
public class ApplicationRest extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> sets = new HashSet<>();
		sets.add(UsuarioRest.class);
		sets.add(AtorRest.class);
		sets.add(DiretorFilmeRest.class);
		sets.add(DiretorRest.class);
		sets.add(FilmeAtorRest.class);
		sets.add(FilmeRest.class);
		sets.add(GeneroRest.class);
		sets.add(ProdutoraRest.class);
		sets.add(SessaoRest.class);
		sets.add(TicketRest.class);
		sets.add(FilterOrigin.class);
		
		return sets;
	}
}
