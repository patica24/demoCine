package pe.osp.cine.osp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tc_pelicula database table.
 * 
 */
@Entity
@Table(name="tc_pelicula")
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="nid_pelicula")
	private long idPelicula;

	@Column(name="cdes_estado")
	private String estado;

	@Column(name="cdes_pelicula")
	private String nomPelicula;

    @Temporal( TemporalType.DATE)
	@Column(name="dfec_publicacion")
	private Date fechaPublicacion;



	//bi-directional many-to-one association to Peliculaxturno
	@OneToMany(mappedBy="pelicula")
	private List<Peliculaxturno> peliculaxturnos;

    public Pelicula() {
    }

	public long getIdPelicula() {
		return this.idPelicula;
	}

	public void setIdPelicula(long idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNomPelicula() {
		return this.nomPelicula;
	}

	public void setNomPelicula(String nomPelicula) {
		this.nomPelicula = nomPelicula;
	}

	public Date getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}


	public List<Peliculaxturno> getPeliculaxturnos() {
		return this.peliculaxturnos;
	}

	public void setPeliculaxturnos(List<Peliculaxturno> peliculaxturnos) {
		this.peliculaxturnos = peliculaxturnos;
	}
	
}