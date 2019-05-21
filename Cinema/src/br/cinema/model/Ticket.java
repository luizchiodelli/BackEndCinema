package br.cinema.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Ticket implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="idUsuario")
	private Long idUsuario;
	@Column(name="idSessao")
	private Long idSessao;
	private String numCartao;
	private Integer numPoltrona;
	private char filaPoltrona;
	private String tipoTicket;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataTicket;
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="id", columnDefinition="idUsuario", insertable=false, updatable=false)
	private Usuario usuario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="id", columnDefinition="idSessao", insertable=false, updatable=false)
	private Sessao sessao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Long getIdSessao() {
		return idSessao;
	}
	public void setIdSessao(Long idSessao) {
		this.idSessao = idSessao;
	}
	public String getNumCartao() {
		return numCartao;
	}
	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}
	public Integer getNumPoltrona() {
		return numPoltrona;
	}
	public void setNumPoltrona(Integer numPoltrona) {
		this.numPoltrona = numPoltrona;
	}
	public char getFilaPoltrona() {
		return filaPoltrona;
	}
	public void setFilaPoltrona(char filaPoltrona) {
		this.filaPoltrona = filaPoltrona;
	}
	public String getTipoTicket() {
		return tipoTicket;
	}
	public void setTipoTicket(String tipoTicket) {
		this.tipoTicket = tipoTicket;
	}
	public Date getDataTicket() {
		return dataTicket;
	}
	public void setDataTicket(Date dataTicket) {
		this.dataTicket = dataTicket;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Sessao getSessao() {
		return sessao;
	}
	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
}
