package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TaskVacantes;
import com.example.demo.repository.VacantesRepository;

@RestController
public class ControllerVacantes {
	
	@Autowired
	private VacantesRepository vacantesRepository;
	
	@GetMapping(value = "/")
	public String holaMundo() {
		return "HOLA MUNDO";
	}
	
	@GetMapping(value = "/tasks")
	public List<TaskVacantes> getTasks(){
		return vacantesRepository.findAll();
		}

	@PostMapping(value = "/saveVacante")
	public String saveVacantes(@RequestBody TaskVacantes taskVacantes) {
		vacantesRepository.save(taskVacantes);
		return "saved taskVacantes";
	}
	
	@PutMapping(value = "/update/{id}")
	public String updateVacantes(@PathVariable long id, @RequestBody TaskVacantes taskVacantes) {
		TaskVacantes updatedVacantes = vacantesRepository.findById(id).get();
		updatedVacantes.setNombre(taskVacantes.getNombre());
		updatedVacantes.setDescripcion(taskVacantes.getDescripcion());
		updatedVacantes.setFechaRegistro(taskVacantes.getFechaRegistro());
		updatedVacantes.setFechaPublicacion(taskVacantes.getFechaPublicacion());
		updatedVacantes.setSalario(taskVacantes.getSalario());
		
		vacantesRepository.save(updatedVacantes);
		return "update task";
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteVacantes(@PathVariable long id) {
		TaskVacantes deletedVacantes=vacantesRepository.findById(id).get();
		vacantesRepository.delete(deletedVacantes);
		return "delete task";
	}
	
}
