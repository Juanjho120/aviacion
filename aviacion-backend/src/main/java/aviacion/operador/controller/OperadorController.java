package aviacion.operador.controller;

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
import aviacion.operador.model.Operador;
import aviacion.operador.service.IOperadorService;

@RestController
@RequestMapping("/operadores")
public class OperadorController {

	@Autowired
	private IOperadorService operadorService;
	
	/**
	 * Obtiene todos los operadores en la base de datos
	 * @return Listado de operadores
	 * @throws Exception
	 */
	@GetMapping
	public ResponseEntity<List<Operador>> getAll() throws Exception {
		List<Operador> operadorList = operadorService.getAll();
		if(operadorList.isEmpty()) {
			throw new ModelNotFoundException("No se encuentran operadores en la base de datos");
		}
		return new ResponseEntity<List<Operador>>(operadorList, HttpStatus.OK);
	}
	
	/**
	 * Busca un operador por su id
	 * @param id
	 * @return Operador
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Operador> getById(@PathVariable("id") Integer id) throws Exception {
		Operador operador = operadorService.getById(id);
		if(operador == null) {
			throw new ModelNotFoundException("Operador con id " + id + " no encontrado");
		}
		return new ResponseEntity<Operador>(operador, HttpStatus.OK);
	}
	
	/**
	 * Guarda un nuevo operador
	 * No lo guarda cuando encuentra otro operador con el mismo codigo
	 * @param operadorNew
	 * @throws Exception
	 */
	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody Operador operadorNew) throws Exception {
		Operador operador = operadorService.create(operadorNew);
		if(operador==null) {
			throw new Exception("No se ha podido crear el operador");
		} else {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	
	/**
	 * Actualiza todos los valores del operador buscandolo por su id
	 * @param operadorUp
	 * @return Operador actualizado
	 * @throws Exception
	 */
	@PutMapping
	public ResponseEntity<Operador> update(@Valid @RequestBody Operador operadorUp) throws Exception {
		Operador operador = operadorService.update(operadorUp);
		return new ResponseEntity<Operador>(operador, HttpStatus.CREATED);
	}
	
	/**
	 * Elimina un operador de la base de datos por su id
	 * @param id
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		Operador operador = operadorService.getById(id);
		if(operador == null) {
			throw new ModelNotFoundException("Operador con id " + id + " no encontrado");
		}
		operadorService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
