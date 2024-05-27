package it.prova.prenotazioni.repository.prenotazione;

import java.util.List;

import it.prova.prenotazioni.model.Prenotazione;

public interface CustomPrenotazioneRepository {

	List<Prenotazione> findByExample(Prenotazione example);

}
