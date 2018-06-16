package pe.osp.cine.osp.dao;
import java.util.List;

import pe.osp.cine.osp.entity.Pelicula;
import pe.osp.cine.osp.entity.Peliculaxturno;
import pe.osp.cine.osp.entity.PeliculaxturnoPK;
import pe.osp.cine.osp.entity.Turno;

public interface IPeliculaDAO {
	
	 void mergePelicula(Pelicula pelicula);
	 
	 List<Pelicula> listarPeliculas();
	 
	 void eliminarPelicula(long id);
	 
	 Pelicula buscarPelicula(long id);
	 
	 List<Peliculaxturno> listarPeliculasXTurno(long idPelicula);
	 
	 void eliminarPeliculaXTurno(PeliculaxturnoPK pxt);
	 
	 void mergePeliculaxturno(Peliculaxturno peliculaxturno);
}
 