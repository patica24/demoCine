package pe.osp.cine.osp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the td_peliculaxturno database table.
 * 
 */
@Entity
@Table(name="td_peliculaxturno")
public class Peliculaxturno implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PeliculaxturnoPK id;

	//bi-directional many-to-one association to Pelicula
    @ManyToOne
	@JoinColumn(name="nid_pelicula", referencedColumnName = "nid_pelicula", insertable=false, updatable=false)
	private Pelicula pelicula;

	//bi-directional many-to-one association to Turno
    @ManyToOne
	@JoinColumn(name="nid_turno", referencedColumnName = "nid_turno", insertable=false, updatable=false)
	private Turno turno;

    public Peliculaxturno() {
    }

	public PeliculaxturnoPK getId() {
		return this.id;
	}

	public void setId(PeliculaxturnoPK id) {
		this.id = id;
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
}