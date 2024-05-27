package it.prova.prenotazioni.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.prenotazioni.dto.stanza.StanzaDTO;
import it.prova.prenotazioni.model.Stanza;
import it.prova.prenotazioni.service.StanzaService;
import it.prova.prenotazioni.web.api.exception.StanzaNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/stanza")
public class StanzaController {

	@Autowired
	private StanzaService stanzaService;

	@GetMapping
	public List<StanzaDTO> listAll() {
		return StanzaDTO.buildStanzaDTOListFromModelList(stanzaService.listAllEager(), true);
	}

	@GetMapping("/{id}")
	public StanzaDTO findById(@PathVariable(value = "id", required = true) Long id) {
		Stanza stanza = stanzaService.findByIdEager(id);

		if (stanza == null) {
			throw new StanzaNotFoundException("Stanza not found with id:" + id);

		}

		return StanzaDTO.buildStanzaDTOFromModel(stanza, true);

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public StanzaDTO insertNew(@Valid @RequestBody StanzaDTO input) {
		Stanza nuovaStanza = stanzaService.inserisciNuovo(input.buildStanzaModel(false));
		return StanzaDTO.buildStanzaDTOFromModel(nuovaStanza, false);
	}
}
