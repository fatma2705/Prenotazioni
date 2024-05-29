package it.prova.prenotazioni.web.api.exception;

public class PrenotazioneNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PrenotazioneNotFoundException(String msg) {
		super(msg);
	}

}
