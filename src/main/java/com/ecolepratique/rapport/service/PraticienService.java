package com.ecolepratique.rapport.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecolepratique.rapport.entite.Praticien;
import com.ecolepratique.rapport.repository.PraticienRepositoryItf;

@Service
public class PraticienService implements PraticienServiceItf {
	@Autowired
	private PraticienRepositoryItf praticienRepository;
	
	@Override
	public List<Praticien> list() {
		return praticienRepository.findAll();
	}
	@Override
	public Praticien create(Praticien praticien) {
		return praticienRepository.save(praticien);
	}
	@Override
	public Praticien getById(Long id) {
		return praticienRepository.findById(id).get();
	}
	@Override
	public Praticien deleteById(Long id) {
		Praticien praticien = getById(id);
		praticienRepository.deleteById(id);
		return praticien;
	}
	@Override
	public Praticien updateById(Long id, Praticien praticien) {
		praticien.setId(id);
		return praticienRepository.save(praticien);
	}
	@Override
	public List<Praticien> findByIsVisite(boolean isVisite) {
		if(isVisite == true)
			return praticienRepository.findByIsVisiteTrue();
		else return praticienRepository.findByIsVisiteFalse();
	}
	@Override
	public List<Praticien> findByNom(String nom) {
		return praticienRepository.findByNom(nom);
	}
	@Override
	public List<Praticien> findBySpecialite(String specialite) {
		return praticienRepository.findBySpecialite(specialite);
	}
	@Override
	public List<Praticien> findByAdresseLike(String motcle) {
		return praticienRepository.findByAdresseLike("%" + motcle + "%");
	}
	@Override
	public List<Praticien> findBySpecialiteIsVisteAdresseLike(String adresse, String specialite, boolean isVisite) {
		if(isVisite == true) {
			return praticienRepository.findBySpecialiteAndAdresseLikeAndIsVisiteTrue(specialite, "%" + adresse + "%");
		}
		else {
			return praticienRepository.findBySpecialiteAndAdresseLikeAndIsVisiteFalse(specialite, "%" + adresse + "%");
		}
	}
	@Override
	public List<Praticien> findBySpecialiteAndAdresseLike(String specialite, String ville) {
		return praticienRepository.findBySpecialiteAndAdresseLike(specialite, "%" + ville + "%");
	}
	@Override
	public List<Praticien> findBySpecialiteAndVisite(String specialite, boolean isVisite) {
		if(isVisite == true)
			return praticienRepository.findBySpecialiteAndIsVisiteTrue(specialite);
		else return praticienRepository.findBySpecialiteAndIsVisiteFalse(specialite);
	}
	@Override
	public List<Praticien> findByVilleAndVisite(String ville, boolean isVisite) {
		if(isVisite == true)
			return praticienRepository.findByAdresseLikeAndIsVisiteTrue("%" + ville + "%");
		else return praticienRepository.findByAdresseLikeAndIsVisiteFalse("%" + ville + "%");
	}	
	
}
