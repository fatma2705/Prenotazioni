package it.prova.prenotazioni.web.api.exception;

public class StanzaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StanzaNotFoundException(String msg) {
		super(msg);
	}

}
