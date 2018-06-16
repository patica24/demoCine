package pe.osp.cine.osp.dao;
import java.util.List;

import pe.osp.cine.osp.entity.Turno;

public interface ITurnoDAO {
	
	 void mergeTurno(Turno turno);
	 
	 List<Turno> listarTurno();
	 
	 void eliminarTurno(long id);
	 
	 Turno buscarTurno(long id);
    
}
 