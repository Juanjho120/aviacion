package aviacion.vuelo.service;

import java.util.List;

import aviacion.generico.service.ICRUD;
import aviacion.vuelo.model.Vuelo;

/**
 * Services for Vuelo Model (Interface)
 * 
 * @author Juan Tzun
 */
public interface IVueloService extends ICRUD<Vuelo, Integer> {

	List<Vuelo> getByFechaIngreso(String fechaIngreso) throws Exception;
	
}
