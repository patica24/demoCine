package pe.osp.cine.osp.dao;
import java.util.List;

import pe.osp.cine.osp.entity.Pelicula;
import pe.osp.cine.osp.entity.Turno;

public interface ITurnoDAO {
	
	 void agregarTurno(Turno turno);
	 
	 List<Turno> listarTurno();
	 
	 void eliminarTurno(long id);
	 
	 void actualizarTurno(Turno turno);
	 
	 Turno buscarTurno(long id);
    
}
 