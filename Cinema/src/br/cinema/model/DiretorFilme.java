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
public class DiretorFilme implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="idDiretor")
	private Long idDiretor;
	@Column(name="idFilme")
	private Long idFilme;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="id", columnDefinition="idDiretor", insertable=false, updatable=false)
	private Diretor diretor;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="id", columnDefinition="idFilme", insertable=false, updatable=false)
	private Filme filme;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdDiretor() {
		return idDiretor;
	}
	public void setIdDiretor(Long idDiretor) {
		this.idDiretor = idDiretor;
	}
	public Long getIdFilme() {
		return idFilme;
	}
	public void setIdFilme(Long idFilme) {
		this.idFilme = idFilme;
	}
	public Diretor getDiretor() {
		return diretor;
	}
	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
}
