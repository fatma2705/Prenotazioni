package it.prova.prenotazioni.repository.stanza;

import java.time.LocalDate;
import java.util.List;

import it.prova.prenotazioni.model.Stanza;
import it.prova.prenotazioni.model.Tipo;

public interface CustomStanzaRepository {

	public List<Stanza> findByExample(Stanza Example);
	
	List<Stanza> stanzeDisponibili(Tipo tipo, LocalDate dataIn, LocalDate dataOut);

}
