package it.prova.prenotazioni.repository.stanza;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.prenotazioni.model.Stanza;

public interface StanzaRepository extends CrudRepository<Stanza, Long>, CustomStanzaRepository, JpaRepository<Stanza, Long> {

	@Query(" select distinct s from Stanza s left join fetch s.prenotazioni ")
	public List<Stanza> listAllEager();

	@Query(" select s from Stanza s join fetch s.prenotazioni p where s.id=?1")
	public Stanza findByIdEager(Long id);
	
	 @Query("SELECT s FROM Stanza s WHERE s.numero = ?1")
	    Stanza findByNumeroStanza(String numStanza);
}
