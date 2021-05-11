package com.ecolepratique.rapport.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecolepratique.rapport.entite.Offre;
import com.ecolepratique.rapport.entite.Rapport;
import com.ecolepratique.rapport.entite.Visiteur;
import com.ecolepratique.rapport.service.OffreServiceItf;
import com.ecolepratique.rapport.service.VisiteurServiceItf;


@RestController
@RequestMapping("/offre")
@CrossOrigin("*")
public class OffreRestApi {
	
	@Autowired
	private OffreServiceItf offreService;
	
	@GetMapping("")
	public List<Offre> listOffre() {
		System.out.println("RapportRestApi - listOffre");
		List<Offre> offres = offreService.listOffre();
		//System.out.println("VisiteurRestApi - listVisteur visiteurs=" + visiteurs);
		return offres;
	}
	@GetMapping("/{id}")
	public Offre getOffreById(@PathVariable("id") Long id) {
		System.out.println("OffreRestApi - get(id) ");
		return offreService.findOffreById(id);
	}
//	@PostMapping("")
//	public Visiteur createVisiteur(@RequestBody Visiteur visiteur) {
//		System.out.println("VisiteurRestApi - create visiteur=" + visiteur);
//        return visiteurService.createVisiteur(visiteur);
//	}
	@PutMapping("/{id}")
	public Offre updateVisiteur(@PathVariable("id") Long id, @Valid @RequestBody Offre offre) {
		return offreService.updateOffreById(id, offre);
	}
	@DeleteMapping("/{id}")
	public Offre deleteVisiteur(@PathVariable("id") Long id) {
		return offreService.deleteOffreById(id);
	}
	

	
}
