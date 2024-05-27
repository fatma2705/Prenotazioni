package it.prova.prenotazioni.repository.prenotazione;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.prenotazioni.model.Prenotazione;

public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long> {

	@Query(" select distinct p from Prenotazione p left join fetch p.stanza")
	public List<Prenotazione> listAllEager();

	@Query(" select p from Prenotazione p left join fetch p.stanza s where p.id=?1")
	public Prenotazione findByIdEager(Long id);

}
