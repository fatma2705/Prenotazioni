package it.prova.prenotazioni.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "stanza")
public class Stanza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "numero")
	private String numero = generateUniqueCode();
	@Column(name = "tipo")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	@Column(name = "prezzo_notte")
	private Float prezzoNotte;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stanza")
	private List<Prenotazione> prenotazioni = new ArrayList<>();

	public Stanza() {

	}

	public Stanza(Long id,String numero, Tipo tipo, Float prezzoNotte) {
		this.id = id;
		this.numero = generateUniqueCode();
		this.tipo = tipo;
		this.prezzoNotte = prezzoNotte;
	}

	public Stanza(Long id,String numero, Tipo tipo, Float prezzoNotte, List<Prenotazione> prenotazioni) {
		this.id = id;
		this.numero = generateUniqueCode();
		this.tipo = tipo;
		this.prezzoNotte = prezzoNotte;
		this.prenotazioni = prenotazioni;
	}
	
	public Stanza(Long id, Tipo tipo, Float prezzoNotte, List<Prenotazione> prenotazioni) {
		this.id = id;
		this.tipo = tipo;
		this.prezzoNotte = prezzoNotte;
		this.prenotazioni = prenotazioni;
	}
	
	public Stanza(Long id,Tipo tipo, Float prezzoNotte) {
		this.id = id;
		this.tipo = tipo;
		this.prezzoNotte = prezzoNotte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Float getPrezzoNotte() {
		return prezzoNotte;
	}

	public void setPrezzoNotte(Float prezzoNotte) {
		this.prezzoNotte = prezzoNotte;
	}

	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public static String generateUniqueCode() {
		final int BASE = 36;
		int counter = 0;
		Set<String> generatedCodes = new HashSet<>();

		String code;
		do {
			code = Integer.toString(counter, BASE).toUpperCase();
			counter++;
		} while (generatedCodes.contains(code) || code.length() != 2);

		generatedCodes.add(code);
		return code;
	}

}
