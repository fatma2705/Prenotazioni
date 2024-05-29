package it.prova.prenotazioni.repository.prenotazione;

import java.time.LocalDate;
import java.util.List;

import it.prova.prenotazioni.model.Prenotazione;

public interface CustomPrenotazioneRepository {

	List<Prenotazione> findByExample(Prenotazione example);

	Prenotazione prenotaStanza(String numStanza, LocalDate dataIn, LocalDate dataOut);

}
