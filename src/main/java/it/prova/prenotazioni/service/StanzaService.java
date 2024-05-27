package it.prova.prenotazioni.service;

import java.util.List;

import it.prova.prenotazioni.model.Stanza;

public interface StanzaService {

	public List<Stanza> listAll();

	public List<Stanza> listAllEager();

	public Stanza findById(Long id);

	public Stanza findByIdEager(Long id);

	public List<Stanza> findByExample(Stanza example);

	public Stanza inserisciNuovo(Stanza input);

	public Stanza update(Stanza input);

	public void rimuovi(Long id);

}
