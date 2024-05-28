package it.prova.prenotazioni.repository.prenotazione;

import java.time.LocalDate;
import java.util.List;

import it.prova.prenotazioni.model.Prenotazione;
import it.prova.prenotazioni.model.Tipo;

public interface CustomPrenotazioneRepository {

	List<Prenotazione> findByExample(Prenotazione example);
	
	Prenotazione prenotaStanza(Tipo tipo,LocalDate dataIn , LocalDate dataOut);

}
