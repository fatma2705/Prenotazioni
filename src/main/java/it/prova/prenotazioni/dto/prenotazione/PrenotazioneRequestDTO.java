package it.prova.prenotazioni.dto.prenotazione;

import java.time.LocalDate;

public class PrenotazioneRequestDTO {
	private String numStanza;
	private LocalDate dataIn;
	private LocalDate dataOut;

	// Getters e Setters

	public String getNumStanza() {
		return numStanza;
	}

	public void setNumStanza(String numStanza) {
		this.numStanza = numStanza;
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
