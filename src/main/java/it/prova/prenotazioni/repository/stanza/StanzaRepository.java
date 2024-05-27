package it.prova.prenotazioni.repository.stanza;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.prenotazioni.model.Stanza;

public interface StanzaRepository extends CrudRepository<Stanza, Long> {

	@Query(" select distinct s from Stanza s left join fetch s.prenotazioni ")
	public List<Stanza> listAllEager();

	@Query(" select s from Stanza s left join fetch s.id=?1")
	public Stanza findByTdEager(Long id);

}