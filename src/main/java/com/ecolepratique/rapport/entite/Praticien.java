package com.ecolepratique.rapport.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Praticien {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String nom;
	@NotNull
	@Length(min=2, max=30)
	private String prenom;
	@NotNull
	private String adresse;
	@NotNull
	private String specialite;
	private boolean isVisite;
	public Praticien() {}
	public Praticien(String nom, String prenom, String adresse, String specialite) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.specialite = specialite;
		isVisite = false;
	}
	@Override
	public String toString() {
		return "Praticien [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", specialite="
				+ specialite + ", isVisite=" + isVisite + "]\n";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public boolean isVisite() {
		return isVisite;
	}
	public void setVisite(boolean isVisite) {
		this.isVisite = isVisite;
	}
}
