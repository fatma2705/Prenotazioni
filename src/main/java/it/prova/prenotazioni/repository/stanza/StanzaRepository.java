package it.prova.prenotazioni.repository.stanza;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.prenotazioni.model.Stanza;

public interface StanzaRepository extends CrudRepository<Stanza, Long>, CustomStanzaRepository {

	@Query(" select distinct s from Stanza s left join fetch s.prenotazioni ")
	public List<Stanza> listAllEager();

	@Query(" select s from Stanza s join fetch s.prenotazioni p where s.id=?1")
	public Stanza findByIdEager(Long id);

}
