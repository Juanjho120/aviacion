package aviacion.operador.repository;

import org.springframework.stereotype.Repository;

import aviacion.generico.repository.IGenericRepository;
import aviacion.operador.model.Operador;

/**
 * Repository for Operador Model
 * 
 * @author Juan Tzun
 */
@Repository
public interface IOperadorRepository extends IGenericRepository<Operador, Integer> {

}
