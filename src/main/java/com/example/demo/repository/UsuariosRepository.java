package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TaskUsuarios;

public interface UsuariosRepository extends JpaRepository<TaskUsuarios, Long> {

}
