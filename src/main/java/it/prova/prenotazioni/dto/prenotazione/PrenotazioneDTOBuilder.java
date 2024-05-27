package it.prova.prenotazioni.dto.prenotazione;

import java.time.LocalDate;

import it.prova.prenotazioni.dto.stanza.StanzaDTO;

public class PrenotazioneDTOBuilder {

	private PrenotazioneDTO dto = new PrenotazioneDTO();

	public PrenotazioneDTOBuilder id(Long id) {
		this.dto.setId(id);
		return this;

	}

	public PrenotazioneDTOBuilder codice(String codice) {
		this.dto.setCodice(codice);
		return this;
	}

	public PrenotazioneDTOBuilder dataIn(LocalDate dataIn) {
		this.dto.setDataIn(dataIn);
		return this;
	}

	public PrenotazioneDTOBuilder dataOut(LocalDate dataOut) {
		this.dto.setDataOut(dataOut);
		return this;
	}

	public PrenotazioneDTOBuilder annullata(Boolean annullata) {
		this.dto.setAnnullata(annullata);
		return this;
	}

	public PrenotazioneDTOBuilder stanza(StanzaDTO stanza) {
		this.dto.setStanza(stanza);
		return this;
	}

	public PrenotazioneDTO build() {
		return this.dto;
	}

}
