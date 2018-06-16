package pe.osp.cine.osp.dao.impl;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.osp.cine.osp.dao.IPeliculaDAO;
import pe.osp.cine.osp.entity.Pelicula;
import pe.osp.cine.osp.entity.Peliculaxturno;
import pe.osp.cine.osp.entity.PeliculaxturnoPK;

@Transactional
@Repository
public class PeliculaDAO implements IPeliculaDAO {
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public void mergePelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		entityManager.merge(pelicula);
	}	
	
	@SuppressWarnings("unchecked")
	public List<Pelicula> listarPeliculas() {
		String hql = "FROM Pelicula as p ORDER BY p.idPelicula";
		return (List<Pelicula>) entityManager.createQuery(hql).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Peliculaxturno> listarPeliculasXTurno(long idPelicula) {
		String hql = "FROM Peliculaxturno e where e.pelicula.idPelicula = :id";
		return (List<Peliculaxturno>) entityManager.createQuery(hql).setParameter("id", idPelicula).getResultList();
	}
	

	@Override
	public void eliminarPelicula(long id) {
		// TODO Auto-generated method stub		
		entityManager.remove(buscarPelicula(id));
	}

	
	@Override
	public Pelicula buscarPelicula(long id) {
		return entityManager.find(Pelicula.class, id);
	}

	@Override
	public void eliminarPeliculaXTurno(PeliculaxturnoPK pxt) {
		// TODO Auto-generated method stub
		entityManager.remove(buscarPeliculaxturno(pxt));
	
	}
	
	public Peliculaxturno buscarPeliculaxturno(PeliculaxturnoPK pxt) {
		return entityManager.find(Peliculaxturno.class, pxt);
	}
	
	@Override
	public void mergePeliculaxturno(Peliculaxturno peliculaxturno) {
		// TODO Auto-generated method stub
		entityManager.merge(peliculaxturno);
	}	

}
