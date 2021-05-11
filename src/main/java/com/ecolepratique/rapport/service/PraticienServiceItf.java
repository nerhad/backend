package com.ecolepratique.rapport.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.ecolepratique.rapport.entite.Praticien;

public interface PraticienServiceItf {
	Praticien create(Praticien medicament);
	List<Praticien> list();
	Praticien getById(Long id);
	Praticien deleteById(Long id);
	Praticien updateById(Long id, Praticien praticien);
	List<Praticien> findByIsVisite(boolean isVisite);
	List<Praticien> findByNom(String nom);
	List<Praticien> findBySpecialite(String specialite);
	List<Praticien> findByAdresseLike(String ville);
	List<Praticien> findBySpecialiteIsVisteAdresseLike(String ville, String specialite, boolean isVisite);
	List<Praticien> findBySpecialiteAndAdresseLike(String specialite, String ville);
	List<Praticien> findBySpecialiteAndVisite(String specialite, boolean visite);
	List<Praticien> findByVilleAndVisite(String ville, boolean visite);
}
