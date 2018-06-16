package pe.osp.cine.osp.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.osp.cine.osp.dao.IPeliculaDAO;
import pe.osp.cine.osp.entity.Pelicula;
import pe.osp.cine.osp.service.IPeliculaService;

@Service
public class PeliculaService implements IPeliculaService {
	@Autowired
	private IPeliculaDAO peliculaDAO;

	@Override
	public void agregarPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		peliculaDAO.agregarPelicula(pelicula);
	}

	@Override
	public List<Pelicula> listarPeliculas() {
		// TODO Auto-generated method stub
		return peliculaDAO.listarPeliculas();
	}

	@Override
	public void eliminarPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		peliculaDAO.eliminarPelicula(pelicula);
	}

	@Override
	public void actualizarPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		peliculaDAO.actualizarPelicula(pelicula);
	}
	
	
	
	
}
