package aviacion.operador.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aviacion.generico.repository.IGenericRepository;
import aviacion.generico.service.CRUDImpl;
import aviacion.operador.model.Operador;
import aviacion.operador.repository.IOperadorRepository;
import aviacion.operador.service.IOperadorService;

/**
 * Services for Operador Model (Implementation)
 * 
 * @author Juan Tzun
 */
@Service
public class OperadorServiceImpl extends CRUDImpl<Operador, Integer> implements IOperadorService {

	@Autowired
	private IOperadorRepository operadorRepository;

	@Override
	protected IGenericRepository<Operador, Integer> getRepository() {
		return operadorRepository;
	}
	
}
