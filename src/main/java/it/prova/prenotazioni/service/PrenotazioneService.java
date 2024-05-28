package it.prova.prenotazioni.service;

import java.time.LocalDate;
import java.util.List;

import it.prova.prenotazioni.model.Prenotazione;
import it.prova.prenotazioni.model.Tipo;

public interface PrenotazioneService {

	public List<Prenotazione> listAll();

	public List<Prenotazione> listAllEager();

	public Prenotazione findById(Long id);

	public Prenotazione findByIdEager(Long id);

	public List<Prenotazione> findByExample(Prenotazione example);

	public Prenotazione prenotaStanza(Tipo tipo , LocalDate dataIn , LocalDate dataOut);

	public Prenotazione update(Prenotazione input);

	public void rimuovi(Long id);

}
