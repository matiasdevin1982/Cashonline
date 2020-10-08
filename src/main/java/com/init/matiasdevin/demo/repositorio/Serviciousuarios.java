package com.init.matiasdevin.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.matiasdevin.demo.entidades.Usuarios;

public interface Serviciousuarios extends JpaRepository<Usuarios, Integer> {

}
