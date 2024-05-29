package it.prova.prenotazioni.dto.stanza;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import it.prova.prenotazioni.dto.prenotazione.PrenotazioneDTO;
import it.prova.prenotazioni.model.Stanza;
import it.prova.prenotazioni.model.Tipo;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StanzaDTO {

	private Long id;

	private String numero;
	@NotNull(message = "{tipo.notnull}")
	private Tipo tipo;
	@NotNull(message = "{prezzoNotte.notnull")
	private Float prezzoNotte;
	@JsonIgnoreProperties(value = { "stanza" })
	private List<PrenotazioneDTO> prenotazioni;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
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

	public List<PrenotazioneDTO> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(List<PrenotazioneDTO> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public Stanza buildStanzaModel(boolean includePrenotazioni) {
		Stanza result = new Stanza(this.id, this.getNumero(), this.tipo, this.prezzoNotte);
		if (includePrenotazioni) {
			result.setPrenotazioni(PrenotazioneDTO.buildPrenotazioneModelListFromDTOList(prenotazioni, false));
		}

		return result;
	}

	public static StanzaDTO buildStanzaDTOFromModel(Stanza model, boolean includePrenotazioni) {

		StanzaDTOBuilder builder = new StanzaDTOBuilder().id(model.getId()).numero(model.getNumero())
				.tipo(model.getTipo()).prezzoNotte(model.getPrezzoNotte());
		if (includePrenotazioni) {
			builder.prenotazione(PrenotazioneDTO.buildPrenotazioneDTOListFromModelList(model.getPrenotazioni(), false));

		}
		return builder.build();

	}

	public static List<Stanza> buildStanzaModelListFromDTOList(List<StanzaDTO> listaDTO, boolean includePrenotazioni) {

		return listaDTO.stream().map(listItem -> listItem.buildStanzaModel(true)).collect(Collectors.toList());
	}

	public static List<StanzaDTO> buildStanzaDTOListFromModelList(List<Stanza> models, boolean includePrenotazioni) {

		return models.stream().map(stanza -> StanzaDTO.buildStanzaDTOFromModel(stanza, true))
				.collect(Collectors.toList());
	}

}
