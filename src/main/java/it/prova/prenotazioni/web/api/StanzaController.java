package it.prova.prenotazioni.web.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.prenotazioni.dto.stanza.StanzaDTO;
import it.prova.prenotazioni.model.Stanza;
import it.prova.prenotazioni.model.Tipo;
import it.prova.prenotazioni.service.StanzaService;
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

	@GetMapping("/disponibili")
	public List<StanzaDTO> listAllStanzeDisponibili(@RequestParam String tipo, @RequestParam LocalDate dataIn,
			@RequestParam LocalDate dataOut) {
		Tipo myTipo = Tipo.valueOf(tipo);
		return StanzaDTO.buildStanzaDTOListFromModelList(stanzaService.stanzeDisponibili(myTipo, dataIn, dataOut),
				true);
	}

	@GetMapping("/{id}")
	public StanzaDTO findById(@PathVariable(value = "id", required = true) Long id) {
		Stanza stanza = stanzaService.findByIdEager(id);
		return StanzaDTO.buildStanzaDTOFromModel(stanza, true);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public StanzaDTO insertNew(@Valid @RequestBody StanzaDTO input) {
		Stanza nuovaStanza = stanzaService.inserisciNuovo(input.buildStanzaModel(false));
		return StanzaDTO.buildStanzaDTOFromModel(nuovaStanza, false);
	}

	@PostMapping("/search")
	public List<StanzaDTO> search(@RequestBody StanzaDTO example) {
		return StanzaDTO.buildStanzaDTOListFromModelList(stanzaService.findByExample(example.buildStanzaModel(false)),
				false);
	}

	@PutMapping
	public StanzaDTO aggiorna(@Valid @RequestBody StanzaDTO input) {

		Stanza aggiornato = stanzaService.update(input.buildStanzaModel(false));
		return StanzaDTO.buildStanzaDTOFromModel(aggiornato, false);

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(required = true) Long id) {
		stanzaService.rimuovi(id);
	}
}
