package pe.osp.cine.osp.dao.impl;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.osp.cine.osp.dao.IPeliculaDAO;
import pe.osp.cine.osp.dao.ITurnoDAO;
import pe.osp.cine.osp.entity.Pelicula;
import pe.osp.cine.osp.entity.Turno;

@Transactional
@Repository
public class TurnoDAO implements ITurnoDAO {
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public void agregarTurno(Turno turno) {
		// TODO Auto-generated method stub
		entityManager.persist(turno);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Turno> listarTurno() {
		// TODO Auto-generated method stub
		String hql = "FROM Turno as t ORDER BY t.idTurno";
		return (List<Turno>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void eliminarTurno(long id) {
		// TODO Auto-generated method stub		
		entityManager.remove(buscarTurno(id));
	}

	@Override
	public void actualizarTurno(Turno turno) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Turno buscarTurno(long id) {
		return entityManager.find(Turno.class, id);
	}

}
