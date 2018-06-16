package pe.osp.cine.osp.service;

import java.util.List;

import pe.osp.cine.osp.entity.Pelicula;
import pe.osp.cine.osp.entity.Peliculaxturno;
import pe.osp.cine.osp.entity.PeliculaxturnoPK;

public interface IPeliculaService {
	
	 void mergePelicula(Pelicula pelicula);
	 
	 List<Pelicula> listarPeliculas();
	 
	 void eliminarPelicula(long id);
	 
	 Pelicula buscarPelicula(long id);
	 
	 List<Peliculaxturno> listarPeliculasXTurno(long idPelicula);
	 
	 void eliminarPeliculaXTurno(PeliculaxturnoPK pxt);
	 
	 void mergePeliculaxturno(Peliculaxturno peliculaxturno);
	 
}
