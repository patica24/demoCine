package pe.osp.cine.osp.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.osp.cine.osp.dao.IPeliculaDAO;
import pe.osp.cine.osp.dao.ITurnoDAO;
import pe.osp.cine.osp.entity.Pelicula;
import pe.osp.cine.osp.entity.Turno;
import pe.osp.cine.osp.service.IPeliculaService;
import pe.osp.cine.osp.service.ITurnoService;

@Service
public class TurnoService implements ITurnoService {
	@Autowired
	private ITurnoDAO turnoDAO;

	@Override
	public void agregarTurno(Turno turno) {
		// TODO Auto-generated method stub
		turnoDAO.agregarTurno(turno);
	}

	@Override
	public List<Turno> listarTurno() {
		// TODO Auto-generated method stub
		return turnoDAO.listarTurno();
	}

	@Override
	public void eliminarTurno(long id) {
		// TODO Auto-generated method stub
		turnoDAO.eliminarTurno(id);
	}

	@Override
	public void actualizarTurno(Turno turno) {
		// TODO Auto-generated method stub
		turnoDAO.actualizarTurno(turno);
	}

	
	
	
	
}
