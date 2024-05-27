package it.prova.prenotazioni.repository.stanza;

import java.util.List;

import it.prova.prenotazioni.model.Stanza;

public interface CustomStanzaRepository {

	public List<Stanza> findByExample(Stanza Example);

}
