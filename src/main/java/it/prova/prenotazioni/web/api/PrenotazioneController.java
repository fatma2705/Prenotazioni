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

import it.prova.prenotazioni.dto.prenotazione.PrenotazioneDTO;
import it.prova.prenotazioni.dto.prenotazione.PrenotazioneRequestDTO;
import it.prova.prenotazioni.dto.stanza.StanzaDTO;
import it.prova.prenotazioni.model.Prenotazione;
import it.prova.prenotazioni.model.Stanza;
import it.prova.prenotazioni.model.Tipo;
import it.prova.prenotazioni.service.PrenotazioneService;
import it.prova.prenotazioni.service.StanzaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/prenotazione")
public class PrenotazioneController {

	@Autowired
	private PrenotazioneService prenotazioneService;

	@Autowired
	private StanzaService stanzaService;

	@GetMapping("/GetStanza")
	public List<StanzaDTO> listAllStanzeDisponibili(@RequestParam String tipo, @RequestParam LocalDate dataIn,
			@RequestParam LocalDate dataOut) {
		Tipo myTipo = Tipo.valueOf(tipo);
		return StanzaDTO.buildStanzaDTOListFromModelList(stanzaService.stanzeDisponibili(myTipo, dataIn, dataOut),
				true);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PrenotazioneDTO prenotaStanza(@RequestBody PrenotazioneRequestDTO requestDTO) {
		Prenotazione nuovaPrenotazione = prenotazioneService.prenotaStanza(requestDTO.getNumStanza(),
				requestDTO.getDataIn(), requestDTO.getDataOut());
		return PrenotazioneDTO.buildPrenotazioneDTOFromModel(nuovaPrenotazione, true);
	}

	@GetMapping
	public List<PrenotazioneDTO> listAll() {
		return PrenotazioneDTO.buildPrenotazioneDTOListFromModelList(prenotazioneService.listAllEager(), true);
	}

	@GetMapping("/{id}")
	public PrenotazioneDTO findById(@PathVariable(value = "id", required = true) Long id) {
		Prenotazione prenotazione = prenotazioneService.findByIdEager(id);
		return PrenotazioneDTO.buildPrenotazioneDTOFromModel(prenotazione, true);
	}

	@PostMapping("/search")
	public List<PrenotazioneDTO> search(@RequestBody PrenotazioneDTO example) {
		return PrenotazioneDTO.buildPrenotazioneDTOListFromModelList(
				prenotazioneService.findByExample(example.buildPrenotazioneModel(false)), false);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(required = true) Long id) {
		prenotazioneService.rimuovi(id);
	}

	@PutMapping
	public PrenotazioneDTO aggiorna(@Valid @RequestBody PrenotazioneDTO input) {
		Prenotazione aggiornato = prenotazioneService.update(input.buildPrenotazioneModel(true));
		return PrenotazioneDTO.buildPrenotazioneDTOFromModel(aggiornato, true);

	}

}
