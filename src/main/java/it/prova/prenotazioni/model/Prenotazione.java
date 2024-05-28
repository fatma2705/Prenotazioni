package it.prova.prenotazioni.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prenotazione")
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "codice")
	private String codice = generateUniqueCode();
	@Column(name = "data_in")
	private LocalDate dataIn;
	@Column(name = "data_out")
	private LocalDate dataOut;
	@Column(name = "annullata")
	private Boolean annullata = false;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stanza_id", nullable = false)
	private Stanza stanza;

	public Prenotazione() {

	}

	public Prenotazione(Long id, LocalDate dataIn, LocalDate dataOut, Stanza stanza) {
		this.id = id;
		this.dataIn = dataIn;
		this.dataOut = dataOut;
		this.stanza = stanza;
	}

	public Prenotazione(Long id, LocalDate dataIn, LocalDate dataOut) {
		this.id = id;
		this.dataIn = dataIn;
		this.dataOut = dataOut;
	}

	public Prenotazione(LocalDate dataIn, LocalDate dataOut, Stanza stanza) {
		this.dataIn = dataIn;
		this.dataOut = dataOut;
		this.stanza = stanza;
	}

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

	public static String generateUniqueCode() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}

}
