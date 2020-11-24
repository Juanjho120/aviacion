package aviacion.vuelo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import aviacion.generico.repository.IGenericRepository;
import aviacion.vuelo.model.Vuelo;

/**
 * Repository for Vuelo Model
 * 
 * @author Juan Tzun
 */
@Repository
public interface IVueloRepository extends IGenericRepository<Vuelo, Integer> {

	@Query("FROM Vuelo WHERE fechaIngreso = :fechaIngreso ORDER BY operador.idOperador")
	List<Vuelo> findByFechaIngreso(LocalDate fechaIngreso);
	
}
