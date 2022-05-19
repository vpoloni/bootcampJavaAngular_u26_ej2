package com.cientificosProyectos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cientificosProyectos.dto.Proyecto;

public interface IProyectoDAO extends JpaRepository<Proyecto, String> {

}
