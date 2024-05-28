package it.prova.prenotazioni.repository.prenotazione;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import it.prova.prenotazioni.dto.prenotazione.PrenotazioneDTO;
import it.prova.prenotazioni.model.Prenotazione;
import it.prova.prenotazioni.model.Stanza;
import it.prova.prenotazioni.model.Tipo;
import it.prova.prenotazioni.repository.stanza.StanzaRepository;
import it.prova.prenotazioni.web.api.exception.ListStanzeDisponibiliNull;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class CustomPrenotazioneRepositoryImpl implements CustomPrenotazioneRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private StanzaRepository stanzaRepository;

	@Override
	public List<Prenotazione> findByExample(Prenotazione example) {

		Map<String, Object> paramaterMap = new HashMap<String, Object>();
		List<String> whereClauses = new ArrayList<String>();

		StringBuilder queryBuilder = new StringBuilder(
				" select p from Prenotazione p left join fetch p.stanza s where p.id = p.id ");

		if (StringUtils.isNotBlank(example.getCodice())) {
			whereClauses.add(" p.codice like :codice");
			paramaterMap.put("codice", "%" + example.getCodice() + "%");
		}

		if (example.getDataIn() != null) {
			whereClauses.add(" p.dataIn > :dataIn");
			paramaterMap.put("dataIn", example.getDataIn());
		}

		if (example.getDataOut() != null) {
			whereClauses.add(" p.dataOut > :dataOut");
			paramaterMap.put("dataOut", example.getDataOut());
		}

		if (example.getAnnullata() != null) {
			whereClauses.add(" p.annullata = :annullata");
			paramaterMap.put("annullata", example.getAnnullata());
		}

		if (example.getStanza() != null && example.getStanza().getNumero() != null) {
			whereClauses.add(" s.numero = :numero");
			paramaterMap.put("numero", example.getStanza().getNumero());
		}

		queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Prenotazione> typedQuery = entityManager.createQuery(queryBuilder.toString(), Prenotazione.class);

		for (String key : paramaterMap.keySet()) {
			typedQuery.setParameter(key, paramaterMap.get(key));
		}

		return typedQuery.getResultList();

	}

	@Override
	public Prenotazione prenotaStanza(Tipo tipo, LocalDate dataIn, LocalDate dataOut) {
		List<Stanza> stanzeDisponibili = stanzaRepository.stanzeDisponibili(tipo, dataIn, dataOut);
		if (stanzeDisponibili == null || stanzeDisponibili.isEmpty()) {
			throw new ListStanzeDisponibiliNull("No available stanze found");
		}
		Prenotazione prenotazione = new Prenotazione(dataIn,dataOut,stanzeDisponibili.get(0));
		return prenotazione;
	}

}
