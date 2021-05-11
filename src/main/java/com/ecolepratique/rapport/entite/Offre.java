package com.ecolepratique.rapport.entite;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
public class Offre {
	@Id
	@GeneratedValue
	private Long id; 
	@Min(2) @Max(10) 
	private int quantite;
	@OneToOne
	private Medicament medicament; 
	
	public Offre() {}
	

	@Override
	public String toString() {
		return "Offre [id=" + id + ", quantite=" + quantite + ", medicament=" + medicament + "]";
	}



	public Offre(int quantite, Medicament medicament) {
		super();
		this.quantite = quantite;
		this.medicament = medicament;
	}




	public int getQuantite() {
		return quantite;
	}



	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}



	public Medicament getMedicament() {
		return medicament;
	}



	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}






	



	
	

	
	
	
	
}
