package aviacion.vuelo.controller;

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
import aviacion.vuelo.model.Vuelo;
import aviacion.vuelo.service.IVueloService;

@RestController
@RequestMapping("/vuelos")
public class VueloController {
	
	@Autowired
	private IVueloService vueloService;
	
	/**
	 * Obtiene todos los vuelos en la base de datos
	 * @return Listado de vuelos
	 * @throws Exception
	 */
	@GetMapping
	public ResponseEntity<List<Vuelo>> getAll() throws Exception {
		List<Vuelo> vueloList = vueloService.getAll();
		if(vueloList.isEmpty()) {
			throw new ModelNotFoundException("No se encuentran vuelos en la base de datos");
		}
		return new ResponseEntity<List<Vuelo>>(vueloList, HttpStatus.OK);
	}
	
	/**
	 * Obtiene todos los vuelos de una fecha en la base de datos
	 * @param fechaIngreso
	 * @return Listado de vuelos
	 * @throws Exception
	 */
	@GetMapping("/fecha/{fechaIngreso}")
	public ResponseEntity<List<Vuelo>> getByFechaIngreso(@PathVariable("fechaIngreso") String fechaIngreso) throws Exception {
		List<Vuelo> vueloList = vueloService.getByFechaIngreso(fechaIngreso);
		if(vueloList.isEmpty()) {
			throw new ModelNotFoundException("No se encuentran vuelos en la base de datos para la fecha "+fechaIngreso);
		}
		return new ResponseEntity<List<Vuelo>>(vueloList, HttpStatus.OK);
	}
	
	/**
	 * Busca un vuelo por su id
	 * @param id
	 * @return Vuelo
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Vuelo> getById(@PathVariable("id") Integer id) throws Exception {
		Vuelo vuelo = vueloService.getById(id);
		if(vuelo == null) {
			throw new ModelNotFoundException("Vuelo con id " + id + " no encontrado");
		}
		return new ResponseEntity<Vuelo>(vuelo, HttpStatus.OK);
	}
	
	/**
	 * Guarda un nuevo vuelo
	 * @param vueloNew
	 * @throws Exception
	 */
	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody Vuelo vueloNew) throws Exception {
		Vuelo vuelo = vueloService.create(vueloNew);
		if(vuelo==null) {
			throw new Exception("No se ha podido crear el vuelo");
		} else {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	
	/**
	 * Actualiza todos los valores del vuelo buscandolo por su id
	 * @param vueloUp
	 * @return Vuelo actualizado
	 * @throws Exception
	 */
	@PutMapping
	public ResponseEntity<Vuelo> update(@Valid @RequestBody Vuelo vueloUp) throws Exception {
		Vuelo vuelo = vueloService.update(vueloUp);
		return new ResponseEntity<Vuelo>(vuelo, HttpStatus.CREATED);
	}
	
	/**
	 * Elimina un vuelo de la base de datos por su id
	 * @param id
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		Vuelo vuelo = vueloService.getById(id);
		if(vuelo == null) {
			throw new ModelNotFoundException("Vuelo con id " + id + " no encontrado");
		}
		vueloService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
