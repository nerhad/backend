package com.ecolepratique.rapport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecolepratique.rapport.entite.User;


public interface UserRepositoryItf extends JpaRepository<User, String> {

}
