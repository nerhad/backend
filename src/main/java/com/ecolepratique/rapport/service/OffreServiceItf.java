package com.ecolepratique.rapport.service;

import java.util.List;

import com.ecolepratique.rapport.entite.Offre;



public interface OffreServiceItf  {
	
	Offre findOffreById(Long id);
	Offre updateOffreById(Long id, Offre offre);
	Offre deleteOffreById(Long id);
	List<Offre> listOffre();
}
