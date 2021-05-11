package com.ecolepratique.rapport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecolepratique.rapport.entite.Offre;
import com.ecolepratique.rapport.entite.Rapport;
import com.ecolepratique.rapport.repository.OffreRepositoryItf;


@Service
public class OffreService implements OffreServiceItf {

@Autowired
public OffreRepositoryItf  offrerepo;



@Override
public Offre findOffreById(Long id) {
	return offrerepo.findById(id).get();
}

@Override
public Offre updateOffreById(Long id, Offre offre) {
	Offre ancienOffre = findOffreById(id); 
	offre.setId(id);
	offre.setMedicament(ancienOffre.getMedicament());
	return offrerepo.save(offre);
}

@Override
public Offre deleteOffreById(Long id) {
	Offre offre = findOffreById(id); 
	offrerepo.deleteById(id);
	return offre;
}

@Override
public List<Offre> listOffre() {
	return offrerepo.findAll();
} 

	
}
