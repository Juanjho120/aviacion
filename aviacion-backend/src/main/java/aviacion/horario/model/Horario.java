package aviacion.horario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Model for Table "horarios"
 * 
 * @author Juan Tzun
 */
@Entity
@Table(name = "horarios")
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHorario;
	
	@NotNull(message = "La hora del horario no puede ser nulo")
	@Size(min = 5, max = 5, message = "La hora del horario debe tener 5 caracteres")
	@Column(name = "hora", nullable = false, length = 20)
	private String hora;
	
	public Horario() {}

	/**
	 * @param idHorario
	 * @param hora
	 */
	public Horario(Integer idHorario, String hora) {
		this.idHorario = idHorario;
		this.hora = hora;
	}

	/**
	 * @return the idHorario
	 */
	public Integer getIdHorario() {
		return idHorario;
	}

	/**
	 * @param idHorario the idHorario to set
	 */
	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}

	/**
	 * @return the hora
	 */
	public String getHora() {
		return hora;
	}

	/**
	 * @param hora the hora to set
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}
	
}
