package aviacion.vuelo.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aviacion.generico.repository.IGenericRepository;
import aviacion.generico.service.CRUDImpl;
import aviacion.vuelo.model.Vuelo;
import aviacion.vuelo.repository.IVueloRepository;
import aviacion.vuelo.service.IVueloService;

/**
 * Services for Vuelo Model (Implementation)
 * 
 * @author Juan Tzun
 */
@Service
public class VueloServiceImpl extends CRUDImpl<Vuelo, Integer> implements IVueloService {
	
	@Autowired
	private IVueloRepository vueloRepository;

	@Override
	protected IGenericRepository<Vuelo, Integer> getRepository() {
		return vueloRepository;
	}

	@Override
	public List<Vuelo> getByFechaIngreso(String fechaIngreso) throws Exception {
		//Convirtiendo cadena de texto a tipo de fecha LocalDateTime
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate fechaIngresoParse = LocalDate.parse(fechaIngreso, formatter);
		
		return vueloRepository.findByFechaIngreso(fechaIngresoParse);
	}
	
}
