package br.cinema.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FilmeAtor implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="idFilme")
	private Long idFilme;
	@Column(name="idAtor")
	private Long idAtor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="id", columnDefinition="idFilme", insertable=false, updatable=false)
	private Filme filme;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="id", columnDefinition="idAtor", insertable=false, updatable=false)
	private Ator ator;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdFilme() {
		return idFilme;
	}
	public void setIdFilme(Long idFilme) {
		this.idFilme = idFilme;
	}
	public Long getIdAtor() {
		return idAtor;
	}
	public void setIdAtor(Long idAtor) {
		this.idAtor = idAtor;
	}
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	public Ator getAtor() {
		return ator;
	}
	public void setAtor(Ator ator) {
		this.ator = ator;
	}
}
