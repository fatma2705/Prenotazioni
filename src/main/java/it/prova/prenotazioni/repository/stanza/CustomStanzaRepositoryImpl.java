package it.prova.prenotazioni.repository.stanza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import it.prova.prenotazioni.model.Stanza;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class CustomStanzaRepositoryImpl implements CustomStanzaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Stanza> findByExample(Stanza example) {
		Map<String, Object> paramaterMap = new HashMap<String, Object>();
		List<String> whereClauses = new ArrayList<String>();

		StringBuilder queryBuilder = new StringBuilder(
				"select s from Stanza s left join fetch s.prenotazioni p where s.id = s.id");

		if (example.getNumero() != null) {
			whereClauses.add(" s.numero = :numero");
			paramaterMap.put("numero", example.getNumero());
		}

		if (example.getTipo() != null) {
			whereClauses.add(" s.tipo = :tipo");
			paramaterMap.put("tipo", example.getTipo());
		}

		if (example.getPrezzoNotte() != null) {
			whereClauses.add(" s.prezzo_notte = :prezzoNotte");
			paramaterMap.put("prezzoNotte", example.getPrezzoNotte());
		}

		queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Stanza> typedQuery = entityManager.createQuery(queryBuilder.toString(), Stanza.class);

		for (String key : paramaterMap.keySet()) {
			typedQuery.setParameter(key, paramaterMap.get(key));
		}

		return typedQuery.getResultList();
	}

}
