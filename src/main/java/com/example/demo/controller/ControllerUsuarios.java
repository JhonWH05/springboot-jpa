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

import com.example.demo.model.TaskUsuarios;
import com.example.demo.model.TaskVacantes;
import com.example.demo.repository.UsuariosRepository;

@RestController
public class ControllerUsuarios {
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@GetMapping(value = "/map")
			public String map() {
				return "prueba exitosa";
			}
	
	@GetMapping(value = "/tasksUsuarios")
	public List<TaskUsuarios> getTasks(){
		return usuariosRepository.findAll();
		}
	
	@PostMapping (value = "/saveUsuario")
	public String saveUsuarios(@RequestBody TaskUsuarios taskUsuarios) {
		usuariosRepository.save(taskUsuarios);
		return "Usuarios guardados";
		
	}
	
	@PutMapping(value = "/updateUsuario/{id}")
	public String updateUsuarios(@PathVariable long id, @RequestBody TaskUsuarios taskUsuarios) {
		TaskUsuarios updatedUsuarios = usuariosRepository.findById(id).get();
		updatedUsuarios.setNombre(taskUsuarios.getNombre());
		updatedUsuarios.setApellidos(taskUsuarios.getApellidos());
		updatedUsuarios.setTelefono(taskUsuarios.getTelefono());
		updatedUsuarios.setCorreo(taskUsuarios.getCorreo());
		updatedUsuarios.setContraseña(taskUsuarios.getContraseña());
		updatedUsuarios.setEstado(taskUsuarios.getEstado());
		updatedUsuarios.setFechaRegistro(taskUsuarios.getFechaRegistro());
		updatedUsuarios.setFechaActualizacion(taskUsuarios.getFechaActualizacion());
		
		usuariosRepository.save(updatedUsuarios);
		return "Actualizacion Realizada";
	}
	
	@DeleteMapping(value = "/deleteUsuario/{id}")
	public String deleteUsuarios(@PathVariable long id) {
		TaskUsuarios deletedUsuarios = usuariosRepository.findById(id).get();
		usuariosRepository.delete(deletedUsuarios);
		return "Usuario Eliminado";
	}
	
}
