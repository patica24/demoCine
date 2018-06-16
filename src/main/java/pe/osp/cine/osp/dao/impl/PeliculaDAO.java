package pe.osp.cine.osp.dao.impl;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.osp.cine.osp.dao.IPeliculaDAO;
import pe.osp.cine.osp.entity.Pelicula;

@Transactional
@Repository
public class PeliculaDAO implements IPeliculaDAO {
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public void agregarPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		entityManager.persist(pelicula);
	}	
	
	@SuppressWarnings("unchecked")
	public List<Pelicula> listarPeliculas() {
		String hql = "FROM Pelicula as p ORDER BY p.idPelicula";
		return (List<Pelicula>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void eliminarPelicula(Pelicula pelicula) {
		entityManager.remove(pelicula);
	}

	@Override
	public void actualizarPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		
	}
}
