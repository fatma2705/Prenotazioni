package it.prova.prenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.prenotazioni.model.Stanza;
import it.prova.prenotazioni.repository.stanza.StanzaRepository;
import it.prova.prenotazioni.web.api.exception.EmptyDatabase;
import it.prova.prenotazioni.web.api.exception.IdNotNullForInsertionException;
import it.prova.prenotazioni.web.api.exception.StanzaNotFoundException;
import it.prova.prenotazioni.web.api.exception.StillHasPrenotazioniLinkedException;

@Service
@Transactional
public class StanzaServiceImpl implements StanzaService {

	@Autowired
	private StanzaRepository stanzaRepository;

	@Override
	public List<Stanza> listAll() {
		return (List<Stanza>) stanzaRepository.findAll();
	}

	@Override
	public List<Stanza> listAllEager() {
		List<Stanza> stanze = stanzaRepository.listAllEager();
		if (stanze == null) {
			throw new EmptyDatabase("Database vuoto ..!");
		}
		return stanze;
	}

	@Override
	public Stanza findById(Long id) {
		return stanzaRepository.findById(id).orElse(null);
	}

	@Override
	public Stanza findByIdEager(Long id) {
		Stanza stanza = stanzaRepository.findByIdEager(id);
		if (stanza == null) {
			throw new StanzaNotFoundException("Stanza not found with id:" + id);
		}
		return stanza;
	}

	@Override
	public List<Stanza> findByExample(Stanza example) {
		return stanzaRepository.findByExample(example);
	}

	@Override
	public Stanza inserisciNuovo(Stanza input) {
		if (input.getId() != null)
			throw new IdNotNullForInsertionException("L'elemento da inserire non deve avere il campo id valorizzato.");
		return stanzaRepository.save(input);
	}

	@Override
	public Stanza update(Stanza input) {
		Stanza stanza = stanzaRepository.findByIdEager(input.getId());
		if (stanza == null) {
			throw new StanzaNotFoundException("Stanza not found with id:" + input.getId());
		}
		return stanzaRepository.save(input);
	}

	@Override
	public void rimuovi(Long id) {
		Stanza stanza = stanzaRepository.findByIdEager(id);
		if (stanza == null) {
			throw new StanzaNotFoundException("Stanza not found with id:" + id);
		}
		if (stanza.getPrenotazioni() != null && !stanza.getPrenotazioni().isEmpty()) {
			throw new StillHasPrenotazioniLinkedException(
					"Cannot delete, there are still prenotazioni linked to this stanza.");
		}
		stanzaRepository.deleteById(id);
	}

}
