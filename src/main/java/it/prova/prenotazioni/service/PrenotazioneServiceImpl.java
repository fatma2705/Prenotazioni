package it.prova.prenotazioni.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.prenotazioni.model.Prenotazione;
import it.prova.prenotazioni.repository.prenotazione.PrenotazioneRepository;
import it.prova.prenotazioni.web.api.exception.EmptyDatabase;

@Service
@Transactional
public class PrenotazioneServiceImpl implements PrenotazioneService {

	@Autowired
	private PrenotazioneRepository prenotazioneRepository;

	@Override
	public List<Prenotazione> listAll() {
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prenotazione findByIdEager(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prenotazione> findByExample(Prenotazione example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prenotazione prenotaStanza(String numStanza , LocalDate dataIn , LocalDate dataOut) {
		Prenotazione prenotazione = prenotazioneRepository.prenotaStanza(numStanza, dataIn, dataOut);
		return prenotazioneRepository.save(prenotazione);
	}

	@Override
	public Prenotazione update(Prenotazione input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rimuovi(Long id) {
		// TODO Auto-generated method stub

	}

}
