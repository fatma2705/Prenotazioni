package it.prova.prenotazioni.dto.prenotazione;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import it.prova.prenotazioni.dto.stanza.StanzaDTO;
import it.prova.prenotazioni.model.Prenotazione;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrenotazioneDTO {

	private Long id;
	private String codice;
	@NotNull(message = "{dataIn.notnull")
	private LocalDate dataIn;
	@NotNull(message = "{dataOut.notnull}")
	private LocalDate dataOut;
	private Boolean annullata;
	@JsonIgnoreProperties(value = { "prenotazioni" })
	private StanzaDTO stanza;

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

	public StanzaDTO getStanza() {
		return stanza;
	}

	public void setStanza(StanzaDTO stanza) {
		this.stanza = stanza;
	}

	public Prenotazione buildPrenotazioneModel(boolean includeStanza) {
		Prenotazione result = new Prenotazione(this.id, this.dataIn, this.dataOut);
		if (includeStanza) {
			result.setStanza(this.stanza.buildStanzaModel(false));
		}
		return result;
	}

	public static PrenotazioneDTO buildPrenotazioneDTOFromModel(Prenotazione model, boolean includeStanza) {

		PrenotazioneDTOBuilder builder = new PrenotazioneDTOBuilder().id(model.getId()).codice(model.getCodice())
				.dataIn(model.getDataIn()).dataOut(model.getDataOut()).annullata(model.getAnnullata());
		if (includeStanza) {
			builder.stanza(StanzaDTO.buildStanzaDTOFromModel(model.getStanza(), false));
		}
		return builder.build();
	}

	public static List<Prenotazione> buildPrenotazioneModelListFromDTOList(List<PrenotazioneDTO> dtos,
			boolean includeStanza) {

		return dtos.stream().map(item -> {
			return item.buildPrenotazioneModel(includeStanza);
		}).collect(Collectors.toList());
	}

	public static List<PrenotazioneDTO> buildPrenotazioneDTOListFromModelList(List<Prenotazione> models,
			boolean includeStanza) {
		return models.stream().map(item -> {
			return PrenotazioneDTO.buildPrenotazioneDTOFromModel(item, includeStanza);
		}).collect(Collectors.toList());
	}

}
