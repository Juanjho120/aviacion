package aviacion.horario.repository;

import org.springframework.stereotype.Repository;

import aviacion.generico.repository.IGenericRepository;
import aviacion.horario.model.Horario;

/**
 * Repository for Horario Model
 * 
 * @author Juan Tzun
 */
@Repository
public interface IHorarioRepository extends IGenericRepository<Horario, Integer> {

}
