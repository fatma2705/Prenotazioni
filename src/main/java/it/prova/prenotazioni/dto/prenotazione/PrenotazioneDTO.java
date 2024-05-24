package it.prova.prenotazioni.dto.prenotazione;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import it.prova.prenotazioni.model.Prenotazione;
import it.prova.prenotazioni.model.Stanza;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrenotazioneDTO {

	private Long id;
	@NotBlank(message = "{codice.notblank}")
	private String codice;
	@NotNull(message = "{dataIn.notnull")
	private LocalDate dataIn;
	@NotNull(message = "{dataOut.notnull}")
	private LocalDate dataOut;
	@NotNull(message = "{annullata.notnull}")
	private Boolean annullata;
	@JsonIgnoreProperties(value = { "prenotazioni" })
	private Stanza stanza;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public LocalDate getDataIn() {
		return dataIn;
	}

	public void setDataIn(LocalDate dataIn) {
		this.dataIn = dataIn;
	}

	public LocalDate getDataOut() {
		return dataOut;
	}

	public void setDataOut(LocalDate dataOut) {
		this.dataOut = dataOut;
	}

	public Boolean getAnnullata() {
		return annullata;
	}

	public void setAnnullata(Boolean annullata) {
		this.annullata = annullata;
	}

	public Stanza getStanza() {
		return stanza;
	}

	public void setStanza(Stanza stanza) {
		this.stanza = stanza;
	}
	
	public Prenotazione buildPrenotazioneModel(boolean includeStanza) {
		Prenotazione result = new Prenotazione(this.id,this.codice,this.dataIn,this.dataOut,this.annullata);
		if (includeStanza) {
			result.setStanza(this.stanza.buildStanzaModel(false));
		}
			return result;
	}
	
	public static PrenotazioneDTO buildPrenotazioneDTOFromModel(Prenotazione model , boolean includeStanza) {
		
	}

}
