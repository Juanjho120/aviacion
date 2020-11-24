package aviacion.horario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aviacion.generico.repository.IGenericRepository;
import aviacion.generico.service.CRUDImpl;
import aviacion.horario.model.Horario;
import aviacion.horario.repository.IHorarioRepository;
import aviacion.horario.service.IHorarioService;

/**
 * Services for Horario Model (Implementation)
 * 
 * @author Juan Tzun
 */
@Service
public class HorarioServiceImpl extends CRUDImpl<Horario, Integer> implements IHorarioService {
	
	@Autowired
	private IHorarioRepository horarioRepository;

	@Override
	protected IGenericRepository<Horario, Integer> getRepository() {
		return horarioRepository;
	}

}
