package com.cientificosProyectos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cientificosProyectos.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
}