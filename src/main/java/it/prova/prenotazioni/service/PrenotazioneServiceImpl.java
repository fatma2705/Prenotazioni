package it.prova.prenotazioni.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.prenotazioni.model.Prenotazione;
import it.prova.prenotazioni.model.Stanza;
import it.prova.prenotazioni.repository.prenotazione.PrenotazioneRepository;
import it.prova.prenotazioni.web.api.exception.EmptyDatabase;
import it.prova.prenotazioni.web.api.exception.PrenotazioneNotFoundException;
import it.prova.prenotazioni.web.api.exception.StanzaNotFoundException;

@Service
@Transactional
public class PrenotazioneServiceImpl implements PrenotazioneService {

	@Autowired
	private PrenotazioneRepository prenotazioneRepository;

	@Override
	public List<Prenotazione> listAll() {
		return (List<Prenotazione>) prenotazioneRepository.findAll();
	}

	@Override
	public List<Prenotazione> listAllEager() {
		List<Prenotazione> prenotazione = prenotazioneRepository.listAllEager();
		if (prenotazione == null || prenotazione.isEmpty())
			throw new EmptyDatabase("Database vuoto ..!");
		return prenotazione;
	}

	@Override
	public Prenotazione findById(Long id) {
		return prenotazioneRepository.findById(id).orElse(null);
	}

	@Override
	public Prenotazione findByIdEager(Long id) {
		Prenotazione prenotazione = prenotazioneRepository.findByIdEager(id);
		if (prenotazione == null) {
			throw new PrenotazioneNotFoundException("Prenotazione not found with id:" + id);
		}
		return prenotazione;
	}

	@Override
	public List<Prenotazione> findByExample(Prenotazione example) {
		return prenotazioneRepository.findByExample(example);
	}

	@Override
	public Prenotazione prenotaStanza(String numStanza, LocalDate dataIn, LocalDate dataOut) {
		Prenotazione prenotazione = prenotazioneRepository.prenotaStanza(numStanza, dataIn, dataOut);
		return prenotazioneRepository.save(prenotazione);
	}

	@Override
	public Prenotazione update(Prenotazione input) {
		Prenotazione prenotazione = prenotazioneRepository.findByIdEager(input.getId());

		if (prenotazione == null) {
			throw new PrenotazioneNotFoundException("Prenotazione not found with id:" + input.getId());
		}
		return prenotazioneRepository.save(input);
	}

	@Override
	public void rimuovi(Long id) {
		Prenotazione prenotazione = prenotazioneRepository.findByIdEager(id);
		if (prenotazione == null) {
			throw new PrenotazioneNotFoundException("Prenotazione not found with id:" + id);
		}
		prenotazioneRepository.deleteById(id);
	}

	@Override
	public void annullaPrenotazione(Long id) {
		Prenotazione prenotazione = prenotazioneRepository.findByIdEager(id);
		prenotazione.setAnnullata(true);
		if (prenotazione.getStanza() != null) {
			prenotazione.getStanza().getPrenotazioni().remove(prenotazione);
			prenotazione.setStanza(null);
		}

	}

	@Override
	public List<Prenotazione> listAllNonAnnullate() {
		List<Prenotazione> prenotazione = prenotazioneRepository.listAllNonAnnullate();
		if (prenotazione == null || prenotazione.isEmpty())
			throw new EmptyDatabase("Database vuoto ..!");
		return prenotazione;
	}
}
