package aviacion.vuelo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import aviacion.horario.model.Horario;
import aviacion.operador.model.Operador;

/**
 * Model for Table "vuelos"
 * 
 * @author Juan Tzun
 */
@Entity
@Table(name = "vuelos")
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVuelo;
	
	@NotNull(message = "El numero del vuelo no puede ser nulo")
	@Column(name = "numero", nullable = false, length = 10)
	private String numero;
	
	@NotNull(message = "El operador no puede ser nulo")
	@ManyToOne
	@JoinColumn(name = "id_operador", nullable = false, foreignKey = @ForeignKey(name = "fkVueloOperador"))
	private Operador operador;
	
	@NotNull(message = "El horario de salida no puede ser nulo")
	@ManyToOne
	@JoinColumn(name = "horario_salida", nullable = false, foreignKey = @ForeignKey(name = "fkVueloHorarioSalida"))
	private Horario horarioSalida;
	
	@NotNull(message = "El horario de salida no puede ser nulo")
	@ManyToOne
	@JoinColumn(name = "horario_entrada", nullable = false, foreignKey = @ForeignKey(name = "fkVueloHorarioEntrada"))
	private Horario horarioEntrada;
	
	@NotNull(message = "La fecha del vuelo no puede ser nulo")
	@FutureOrPresent(message = "La fecha del vuelo debe estar en tiempo presente o futuro")
	@Column(name = "fecha_ingreso", nullable = false)
	private LocalDate fechaIngreso;
	
	public Vuelo() {}

	/**
	 * @param idVuelo
	 * @param numero
	 * @param operador
	 * @param horarioSalida
	 * @param horarioEntrada
	 * @param fechaIngreso
	 */
	public Vuelo(Integer idVuelo, String numero, Operador operador, Horario horarioSalida, Horario horarioEntrada, LocalDate fechaIngreso) {
		this.idVuelo = idVuelo;
		this.numero = numero;
		this.operador = operador;
		this.horarioSalida = horarioSalida;
		this.horarioEntrada = horarioEntrada;
		this.fechaIngreso = fechaIngreso;
	}

	/**
	 * @return the idVuelo
	 */
	public Integer getIdVuelo() {
		return idVuelo;
	}

	/**
	 * @param idVuelo the idVuelo to set
	 */
	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the operador
	 */
	public Operador getOperador() {
		return operador;
	}

	/**
	 * @param operador the operador to set
	 */
	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	/**
	 * @return the horarioSalida
	 */
	public Horario getHorarioSalida() {
		return horarioSalida;
	}

	/**
	 * @param horarioSalida the horarioSalida to set
	 */
	public void setHorarioSalida(Horario horarioSalida) {
		this.horarioSalida = horarioSalida;
	}

	/**
	 * @return the horarioEntrada
	 */
	public Horario getHorarioEntrada() {
		return horarioEntrada;
	}

	/**
	 * @param horarioEntrada the horarioEntrada to set
	 */
	public void setHorarioEntrada(Horario horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	/**
	 * @return the fechaIngreso
	 */
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	/**
	 * @param fechaIngreso the fechaIngreso to set
	 */
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
}
