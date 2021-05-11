package com.ecolepratique.rapport.service;

import com.ecolepratique.rapport.entite.Offre;
import com.ecolepratique.rapport.entite.Rapport;
import com.ecolepratique.rapport.entite.Visiteur;
import com.ecolepratique.rapport.repository.OffreRepositoryItf;
import com.ecolepratique.rapport.repository.RapportRepositoryItf;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RapportService implements RapportServiceItf {
	@Autowired
	private RapportRepositoryItf rapportRepository;
	
	@Autowired
	private OffreRepositoryItf  offrerepo;
	

	@Override
	public Rapport findRapportById(Long id) {
		//return rapportRepository.findById(id);
		return rapportRepository.findById(id).get();
	}
	@Override
	public List<Rapport> listRapport() {
		return rapportRepository.findAll();
	}
	@Override
	public Rapport updateRapport(Long id, Rapport rapport) {
		Rapport ancienRapport = findRapportById(id); 
		rapport.setId(id); 
		rapport.setOffres(ancienRapport.getOffres());
		return rapportRepository.save(rapport);
	}
	@Override
	public Rapport deleteById(Long id) {
		Rapport rapport = findRapportById(id);
		rapportRepository.deleteById(id);
		return rapport;
	}
	@Override
	public List<Rapport> listRapportByChampEtMotCle(String champ, String motCle){
		List<Rapport> rapports = null;
		if(champ.equals("motif")){
			rapports = rapportRepository.findByMotifLike("%" + motCle + "%");
		}
		else if(champ.equals("bilan")) {
			rapports = rapportRepository.findByBilanLike("%" + motCle + "%");
		}
		return rapports;
	}
	public List<Rapport> listRapportByDate(String date, String type){
		String[] tab = date.split("-"); 
		List<Rapport> rapports = null;
		if(type.equals("after"))
			rapports = rapportRepository.findByDateAfter(LocalDate.of(Integer.valueOf(tab[0]), Integer.valueOf(tab[1]), Integer.valueOf(tab[2])));
		else if(type.equals("before"))
			rapports = rapportRepository.findByDateBefore(LocalDate.of(Integer.valueOf(tab[0]), Integer.valueOf(tab[1]), Integer.valueOf(tab[2])));
		return rapports;
	}
	
	@Override
	public Offre createOffre(Long id, Offre offre) {
		offre = offrerepo.save(offre);
		Rapport rapport = findRapportById(id); 
		rapport.addOffre(offre);
		rapportRepository.save(rapport);
		return offre;
	}
	
	
}
