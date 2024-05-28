package it.prova.prenotazioni.service;

import java.util.List;

import it.prova.prenotazioni.model.Prenotazione;

public interface PrenotazioneService {

	public List<Prenotazione> listAll();

	public List<Prenotazione> listAllEager();

	public Prenotazione findById(Long id);

	public Prenotazione findByIdEager(Long id);

	public List<Prenotazione> findByExample(Prenotazione example);

	public Prenotazione inserisciNuovo(Prenotazione input);

	public Prenotazione update(Prenotazione input);

	public void rimuovi(Long id);

}
