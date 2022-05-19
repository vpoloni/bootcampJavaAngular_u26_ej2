package com.cientificosProyectos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cientificosProyectos.dto.Cientifico;

public interface ICientificoDAO extends JpaRepository<Cientifico, String> {

}
