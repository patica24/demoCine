package pe.osp.cine.osp.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.osp.cine.osp.dao.IPeliculaDAO;
import pe.osp.cine.osp.entity.Pelicula;
import pe.osp.cine.osp.entity.Peliculaxturno;
import pe.osp.cine.osp.entity.PeliculaxturnoPK;
import pe.osp.cine.osp.service.IPeliculaService;

@Service
public class PeliculaService implements IPeliculaService {
	@Autowired
	private IPeliculaDAO peliculaDAO;

	@Override
	public void mergePelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		peliculaDAO.mergePelicula(pelicula);
	}

	@Override
	public List<Pelicula> listarPeliculas() {
		// TODO Auto-generated method stub
		return peliculaDAO.listarPeliculas();
	}

	@Override
	public void eliminarPelicula(long id) {
		// TODO Auto-generated method stub
		peliculaDAO.eliminarPelicula(id);
	}

	@Override
	public Pelicula buscarPelicula(long id) {
		// TODO Auto-generated method stub
		return peliculaDAO.buscarPelicula(id);
	}

	@Override
	public List<Peliculaxturno> listarPeliculasXTurno(long idPelicula) {
		// TODO Auto-generated method stub
		return peliculaDAO.listarPeliculasXTurno(idPelicula);
	}


	@Override
	public void mergePeliculaxturno(Peliculaxturno peliculaxturno) {
		// TODO Auto-generated method stub
		peliculaDAO.mergePeliculaxturno(peliculaxturno);
	}

	@Override
	public void eliminarPeliculaXTurno(PeliculaxturnoPK pxt) {
		// TODO Auto-generated method stub
		peliculaDAO.eliminarPeliculaXTurno(pxt);
	}

	


	
	
	
}
