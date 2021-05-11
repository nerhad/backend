package com.ecolepratique.rapport.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecolepratique.rapport.repository.medicament2RepositoryItf;
import com.ecolepratique.rapport.entite.Medicament;

@Service
public class MedicamentService implements MedicamentServiceItf {
	@Autowired
	private medicament2RepositoryItf Medicament2Dao;
	
	@Override
	public List<Medicament> list() {
		return Medicament2Dao.findAll();
	}
	@Override
	public Medicament create(Medicament medicament) {
		return Medicament2Dao.save(medicament);
	}
	@Override
	public Medicament getByNumDepotLegal(Long numDepotLegal) {
		return Medicament2Dao.findById(numDepotLegal).get();
	}
	@Override
	public Medicament deleteByNumDepotLegal(Long numDepotLegal) {
		Medicament medicament = getByNumDepotLegal(numDepotLegal); 
		Medicament2Dao.deleteById(numDepotLegal);
		return medicament;
	}
	@Override
	public Medicament updateByNumDepotLegal(Long numDepotLegal, Medicament medicament) {
		// modifier effet 
		//modifier contreIndication  
		medicament.setNumDepotLegal(numDepotLegal);
		return Medicament2Dao.save(medicament);
	}
	
}
