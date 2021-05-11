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

import com.ecolepratique.rapport.entite.Praticien;
import com.ecolepratique.rapport.service.PraticienServiceItf;

@RestController
@RequestMapping("/praticien")
@CrossOrigin("*")
public class PraticienRestApi {
	@Autowired
	private PraticienServiceItf praticienService;
	
	@GetMapping("")
	public List<Praticien> list() {
		System.out.println("PraticienRestApi - list()");
		List<Praticien> praticiens = praticienService.list();
		//System.out.println("medicaments=" + praticiens);
		return praticiens;
	}
	@GetMapping("/{id}")
	public Praticien get(@PathVariable("id") Long id) {
		System.out.println("PraticienRestApi - get(id) ");
		return praticienService.getById(id);
	}
	@PostMapping("")
	public Praticien create(@Valid @RequestBody Praticien praticien) {
        return praticienService.create(praticien);
	}
	@PutMapping("/{id}")
	public Praticien update(@PathVariable("id") Long id,@Valid @RequestBody Praticien praticien) {
		return praticienService.updateById(id, praticien);
	}
	@DeleteMapping("/{id}")
	public Praticien delete(@PathVariable("id") Long id) {
		return praticienService.deleteById(id);
	}
	@GetMapping(
			params = "visite"
	)
	public List<Praticien> findByIsVisite(@RequestParam("visite") boolean isVisite) {
		System.out.println("PraticienRestApi - findByIsVisite()");
		List<Praticien> praticiens = praticienService.findByIsVisite(isVisite);
		return praticiens;
	}
	@GetMapping(
			params = "nom"
	)
	public List<Praticien> findByNom(@RequestParam("nom") String nom) {
		System.out.println("PraticienRestApi - findByNom()");
		List<Praticien> praticiens = praticienService.findByNom(nom);
		//System.out.println("medicaments=" + praticiens);
		return praticiens;
	}
	@GetMapping(
			params = "specialite"
	)
	public List<Praticien> findBySpecialite(@RequestParam("specialite") String specialite) {
		System.out.println("PraticienRestApi - findBySpecialite() specialite=" + specialite);
		return praticienService.findBySpecialite(specialite);
	}	
	@GetMapping(
			params = "ville"
	)
	public List<Praticien> findByAdresseLike(@RequestParam("ville") String ville) {
		return praticienService.findByAdresseLike(ville);
	}
	@GetMapping(    
			params = { "ville", "specialite", "visite"}
	)
	public List<Praticien> findBySpecialiteIsVisteAdresseLike(@RequestParam("ville") String ville, 
															@RequestParam("specialite") String specialite,
															@RequestParam("visite") boolean isVisite) {
		System.out.println("PraticienRestApi - findBySpecialiteIsVisteAdresseLike ville=" + ville + " specialite=" + specialite +" isVisite=" + isVisite);
		return praticienService.findBySpecialiteIsVisteAdresseLike(ville, specialite, isVisite);
	}
	@GetMapping(
			params = {"ville", "specialite"}
	)
	public List<Praticien> findBySpecialiteAndAdresseLike(@RequestParam("specialite") String specialite, @RequestParam("ville") String ville) {
		return praticienService.findBySpecialiteAndAdresseLike(specialite, ville);
	}
	@GetMapping(
			params = {"specialite", "visite"}
	)
	public List<Praticien> findBySpecialiteAndVisite(@RequestParam("specialite") String specialite, @RequestParam("visite") boolean visite) {
		return praticienService.findBySpecialiteAndVisite(specialite, visite);
	}
	@GetMapping(
			params = {"ville", "visite"}
	)
	public List<Praticien> findByVilleAndVisite(@RequestParam("ville") String ville, @RequestParam("visite") boolean visite) {
		return praticienService.findByVilleAndVisite(ville, visite);
	}
	

}
 