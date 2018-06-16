package pe.osp.cine.osp.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the td_peliculaxturno database table.
 * 
 */
@Embeddable
public class PeliculaxturnoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="nid_pelicula")
	private long idPelicula;

	@Column(name="nid_turno")
	private long idTurno;

    public PeliculaxturnoPK() {
    }
	

	public long getIdPelicula() {
		return idPelicula;
	}


	public void setIdPelicula(long idPelicula) {
		this.idPelicula = idPelicula;
	}


	public long getIdTurno() {
		return idTurno;
	}


	public void setIdTurno(long idTurno) {
		this.idTurno = idTurno;
	}
/*

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PeliculaxturnoPK)) {
			return false;
		}
		PeliculaxturnoPK castOther = (PeliculaxturnoPK)other;
		return 
			(this.idPelicula == castOther.idPelicula)
			&& (this.idTurno == castOther.idTurno);

    }
    
	public int hashCode() {
		final long prime = 31;
		long hash = 17;
		hash = hash * prime + this.idPelicula;
		hash = hash * prime + this.idTurno;
		
		return hash;
    }*/
}