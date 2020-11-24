package aviacion.horario.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aviacion.exception.ModelNotFoundException;
import aviacion.horario.model.Horario;
import aviacion.horario.service.IHorarioService;

@RestController
@RequestMapping("/horarios")
public class HorarioController {

	@Autowired
	private IHorarioService horarioService;
	
	/**
	 * Obtiene todos los horarios en la base de datos
	 * @return Listado de horarios
	 * @throws Exception
	 */
	@GetMapping
	public ResponseEntity<List<Horario>> getAll() throws Exception {
		List<Horario> horarioList = horarioService.getAll();
		if(horarioList.isEmpty()) {
			throw new ModelNotFoundException("No se encuentran horarios en la base de datos");
		}
		return new ResponseEntity<List<Horario>>(horarioList, HttpStatus.OK);
	}
	
	/**
	 * Busca un horario por su id
	 * @param id
	 * @return Horario
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Horario> getById(@PathVariable("id") Integer id) throws Exception {
		Horario horario = horarioService.getById(id);
		if(horario == null) {
			throw new ModelNotFoundException("Horario con id " + id + " no encontrado");
		}
		return new ResponseEntity<Horario>(horario, HttpStatus.OK);
	}
	
	/**
	 * Guarda un nuevo horario
	 * No lo guarda cuando encuentra otro horario con la misma hora
	 * @param horarioNew
	 * @throws Exception
	 */
	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody Horario horarioNew) throws Exception {
		Horario horario = horarioService.create(horarioNew);
		if(horario==null) {
			throw new Exception("No se ha podido crear el horario");
		} else {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	
	/**
	 * Actualiza todos los valores del horario buscandolo por su id
	 * @param horarioUp
	 * @return Horario actualizado
	 * @throws Exception
	 */
	@PutMapping
	public ResponseEntity<Horario> update(@Valid @RequestBody Horario horarioUp) throws Exception {
		Horario horario = horarioService.update(horarioUp);
		return new ResponseEntity<Horario>(horario, HttpStatus.CREATED);
	}
	
	/**
	 * Elimina un horario de la base de datos por su id
	 * @param id
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		Horario horario = horarioService.getById(id);
		if(horario == null) {
			throw new ModelNotFoundException("Horario con id " + id + " no encontrado");
		}
		horarioService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
