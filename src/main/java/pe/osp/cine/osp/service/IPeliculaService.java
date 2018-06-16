package pe.osp.cine.osp.service;

import java.util.List;

import pe.osp.cine.osp.entity.Pelicula;

public interface IPeliculaService {
	
	 void agregarPelicula(Pelicula pelicula);
	 
	 List<Pelicula> listarPeliculas();
	 
	 void eliminarPelicula(Pelicula pelicula);
	 
	 void actualizarPelicula(Pelicula pelicula);
}
