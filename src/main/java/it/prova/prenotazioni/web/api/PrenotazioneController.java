package it.prova.prenotazioni.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.prenotazioni.dto.prenotazione.PrenotazioneDTO;
import it.prova.prenotazioni.dto.prenotazione.PrenotazioneRequestDTO;
import it.prova.prenotazioni.model.Prenotazione;
import it.prova.prenotazioni.model.Tipo;
import it.prova.prenotazioni.service.PrenotazioneService;

@RestController
@RequestMapping("/api/prenotazione")
public class PrenotazioneController {

	@Autowired
	private PrenotazioneService prenotazioneService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PrenotazioneDTO prenotaStanza(@RequestBody PrenotazioneRequestDTO requestDTO) {
		Tipo newTipo = Tipo.valueOf(requestDTO.getTipo());
		Prenotazione nuovaPrenotazione = prenotazioneService.prenotaStanza(newTipo, requestDTO.getDataIn(),
				requestDTO.getDataOut());
		return PrenotazioneDTO.buildPrenotazioneDTOFromModel(nuovaPrenotazione, true);
	}

}
