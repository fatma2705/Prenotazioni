package it.prova.prenotazioni.dto.prenotazione;

import java.time.LocalDate;

public class PrenotazioneRequestDTO {
	private String tipo;
	private LocalDate dataIn;
	private LocalDate dataOut;

	// Getters e Setters
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
}
