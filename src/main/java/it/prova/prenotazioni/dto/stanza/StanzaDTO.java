package it.prova.prenotazioni.dto.stanza;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import it.prova.prenotazioni.model.Prenotazione;
import it.prova.prenotazioni.model.Stanza;
import it.prova.prenotazioni.model.Tipo;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StanzaDTO {
	
	private Long id;
	
	@NotNull(message = "{numero.notnull}")
	private Integer numero;
	@NotNull(message = "{tipo.notnull}")
	private Tipo tipo;
	@NotNull(message = "{prezzoNotte.notnull")
	private Float prezzoNotte;
	@JsonIgnoreProperties(value = {"stanza"})
	private List<Prenotazione> prenotazioni;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Float getPrezzoNotte() {
		return prezzoNotte;
	}
	public void setPrezzoNotte(Float prezzoNotte) {
		this.prezzoNotte = prezzoNotte;
	}
	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}
	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
	
	
	public Stanza buildStanzaModel(boolean includePrenotazioni) {
		Stanza result = new Stanza(this.id,this.numero,this.tipo,this.prezzoNotte);
		if(includePrenotazioni)
			result.setPrenotazioni(this.prenotazioni.);
	}
	
	
	

}
