package it.prova.prenotazioni.dto.stanza;

import java.util.List;

import it.prova.prenotazioni.dto.prenotazione.PrenotazioneDTO;
import it.prova.prenotazioni.model.Tipo;

public class StanzaDTOBuilder {

	private StanzaDTO dto = new StanzaDTO();

	public StanzaDTOBuilder id(Long id) {
		this.dto.setId(id);
		return this;
	}

	public StanzaDTOBuilder numero(Integer numero) {
		this.dto.setNumero(numero);
		return this;
	}

	public StanzaDTOBuilder tipo(Tipo tipo) {
		this.dto.setTipo(tipo);
		return this;
	}

	public StanzaDTOBuilder prezzoNotte(Float prezzoNotte) {
		this.dto.setPrezzoNotte(prezzoNotte);
		return this;

	}

	public StanzaDTOBuilder prenotazione(List<PrenotazioneDTO> prenotazioni) {
		this.dto.setPrenotazioni(prenotazioni);
		return this;
	}

	public StanzaDTO build() {
		return this.dto;
	}

}
