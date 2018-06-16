package pe.osp.cine.osp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tc_turno database table.
 * 
 */
@Entity
@Table(name="tc_turno")
public class Turno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="nid_turno")
	private long idTurno;

	@Column(name="cdes_turno")
	private String turno;

	@Column(name="cdes_estado")
	private String estado;

	//bi-directional many-to-one association to Peliculaxturno
	@OneToMany(mappedBy="turno")
	private List<Peliculaxturno> peliculaxturnos;

    public Turno() {
    }

	public long getIdTurno() {
		return this.idTurno;
	}

	public void setIdTurno(long idTurno) {
		this.idTurno = idTurno;
	}

	public String getTurno() {
		return this.turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Peliculaxturno> getPeliculaxturnos() {
		return this.peliculaxturnos;
	}

	public void setPeliculaxturnos(List<Peliculaxturno> peliculaxturnos) {
		this.peliculaxturnos = peliculaxturnos;
	}
	
}