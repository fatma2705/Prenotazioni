package it.prova.prenotazioni.web.api.exception;

public class StillHasPrenotazioniLinkedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StillHasPrenotazioniLinkedException(String msg) {
		super(msg);
	}

}
