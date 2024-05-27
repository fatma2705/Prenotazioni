package it.prova.prenotazioni.web.api.exception;

public class EmptyDatabase extends RuntimeException {


		private static final long serialVersionUID = 1L;
		
		public EmptyDatabase(String msg) {
			super(msg);
		}

	}


