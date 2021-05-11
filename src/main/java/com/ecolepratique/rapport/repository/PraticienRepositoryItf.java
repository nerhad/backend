package com.ecolepratique.rapport.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecolepratique.rapport.entite.Praticien;

public interface PraticienRepositoryItf extends JpaRepository<Praticien, Long> {
	List<Praticien> findByIsVisiteFalse();
	List<Praticien> findByIsVisiteTrue();
	List<Praticien> findByNom(String nom);
	List<Praticien> findBySpecialite(String specialite);
	List<Praticien> findByAdresseLike(String ville);
	List<Praticien> findBySpecialiteAndAdresseLikeAndIsVisiteFalse(String specialite, String adresse);
	List<Praticien> findBySpecialiteAndAdresseLikeAndIsVisiteTrue(String specialite, String adresse);
	List<Praticien> findBySpecialiteAndAdresseLike(String specialite, String adresse);
	List<Praticien> findBySpecialiteAndIsVisiteTrue(String specialite);
	List<Praticien> findBySpecialiteAndIsVisiteFalse(String specialite);
	List<Praticien> findByAdresseLikeAndIsVisiteTrue(String adresse);
	List<Praticien> findByAdresseLikeAndIsVisiteFalse(String adresse);
}
