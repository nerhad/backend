package com.ecolepratique.rapport.entite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
public class Rapport {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private LocalDate date;
	@NotNull
	@NotEmpty
	@Column(columnDefinition = "TEXT") 
	private String bilan;
	@NotNull
	@NotEmpty
	@Column(columnDefinition = "TEXT") 
	private String motif;
////////////////////////////////////	
// ajout d"une liste d'offre //////
	@OneToMany(fetch = FetchType.EAGER)
	private List<Offre> offres;
	
	
//////////////////////////////////////////////////////////////////	

	public Rapport () {};

	public Rapport(LocalDate date, String bilan, String motif) {
		super();
		this.date = date;
		this.bilan = bilan;
		this.motif = motif;
		offres = new ArrayList<>();
	}
	
	
	
	public void addOffre(Offre offre) {
		offres.add(offre); 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getBilan() {
		return bilan;
	}

	public void setBilan(String bilan) {
		this.bilan = bilan;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	@Override
	public String toString() {
		return "Rapport [id=" + id + ", date=" + date + ", bilan=" + bilan + ", motif=" + motif + ", offres=" + offres
				+ "]";
	}

	
//////////////////////////////////////////////////////////////////	
	

	
	
}
