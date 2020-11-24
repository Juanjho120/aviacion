package aviacion.operador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Model for Table "operadores"
 * 
 * @author Juan Tzun
 */
@Entity
@Table(name = "operadores")
public class Operador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOperador;
	
	@NotNull(message = "El codigo del operador no puede ser nulo")
	@Size(min = 2, message = "El codigo del operador debe tener por lo menos 2 caracteres")
	@Column(name = "codigo", nullable = false, length = 5)
	private String codigo;
	
	@NotNull(message = "El nombre del operador no puede ser nulo")
	@Size(min = 3, message = "El nombre del operador debe tener por lo menos 3 caracteres")
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	public Operador() {}

	/**
	 * @param idOperador
	 * @param codigo
	 * @param nombre
	 */
	public Operador(Integer idOperador, String codigo, String nombre) {
		this.idOperador = idOperador;
		this.codigo = codigo;
		this.nombre = nombre;
	}

	/**
	 * @return the idOperador
	 */
	public Integer getIdOperador() {
		return idOperador;
	}

	/**
	 * @param idOperador the idOperador to set
	 */
	public void setIdOperador(Integer idOperador) {
		this.idOperador = idOperador;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
