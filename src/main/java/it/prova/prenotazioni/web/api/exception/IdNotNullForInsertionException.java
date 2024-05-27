package it.prova.prenotazioni.web.api.exception;

public class IdNotNullForInsertionException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public IdNotNullForInsertionException(String msg) {
		super(msg);
	}

}
