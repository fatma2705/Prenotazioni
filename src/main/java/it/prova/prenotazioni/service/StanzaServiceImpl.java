package it.prova.prenotazioni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.prenotazioni.model.Stanza;
import it.prova.prenotazioni.repository.stanza.StanzaRepository;
import it.prova.prenotazioni.web.api.exception.IdNotNullForInsertionException;

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
		return (List<Stanza>) stanzaRepository.listAllEager();
	}

	@Override
	public Stanza findById(Long id) {
		return stanzaRepository.findById(id).orElse(null);
	}

	@Override
	public Stanza findByIdEager(Long id) {
		return stanzaRepository.findByIdEager(id);
	}

	@Override
	public List<Stanza> findByExample(Stanza example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stanza inserisciNuovo(Stanza input) {
		if (input.getId() != null)
			throw new IdNotNullForInsertionException("L'elemento da inserire non deve avere il campo id valorizzato.");
		return stanzaRepository.save(input);
	}

	@Override
	public Stanza update(Stanza input) {
		return null;
	}

	@Override
	public void rimuovi(Long id) {
		// TODO Auto-generated method stub

	}

}
