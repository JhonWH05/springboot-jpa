package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TaskVacantes;

public interface VacantesRepository extends JpaRepository<TaskVacantes, Long>{

}
