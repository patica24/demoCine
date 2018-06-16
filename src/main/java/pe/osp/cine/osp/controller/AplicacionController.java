package pe.osp.cine.osp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.osp.cine.osp.entity.Pelicula;
import pe.osp.cine.osp.entity.Peliculaxturno;
import pe.osp.cine.osp.entity.PeliculaxturnoPK;
import pe.osp.cine.osp.entity.Turno;
import pe.osp.cine.osp.service.IPeliculaService;
import pe.osp.cine.osp.service.ITurnoService;


@Controller
public class AplicacionController {
	@Autowired
	private IPeliculaService peliculaService;
	
	@Autowired
	private ITurnoService turnoService;

	/*---------------------------
	Pantalla : LISTA TODAS LAS PELICULAS
	-----------------------------*/
	@RequestMapping(value="/")
    public String viewPeliculas(Model model) {
    	List<Pelicula> pelicula =  peliculaService.listarPeliculas();
        model.addAttribute("peliculas", pelicula);
        model.addAttribute("pelicula", new Pelicula());
        return "peliculas";
    }

    /*---------------------------
	Action : GUARDAR PELICULAS
	-----------------------------*/
	@RequestMapping(value="/guardarPelicula", method = RequestMethod.POST)
    public String saveTurno(Model model, Pelicula pelicula) {
		peliculaService.mergePelicula(pelicula);
    	List<Pelicula> list =  peliculaService.listarPeliculas();
    	model.addAttribute("peliculas", list);
    	model.addAttribute("pelicula", new Pelicula());
        return "peliculas";
    }    
	
	/*---------------------------
	Action : ANULAR PELICULA
	-----------------------------*/
	@RequestMapping(value="/eliminarPelicula/{id}", method = RequestMethod.GET)
    public String deletePelicula(Model model, @PathVariable(required = true, name = "id") long id) {

		
		
		List<Peliculaxturno> peliculasxturno = peliculaService.listarPeliculasXTurno(id);
		for(int i = 0; i< peliculasxturno.size();i++) {
			peliculaService.eliminarPeliculaXTurno(peliculasxturno.get(i).getId());
		}
		
		peliculaService.eliminarPelicula(id);
		
    	List<Pelicula> list =  peliculaService.listarPeliculas();
    	model.addAttribute("peliculas", list);
    	model.addAttribute("pelicula", new Pelicula());
        return "peliculas";
    }
	
	/*----------------------------
	 PANTALLA: MODAL PELICULA
	-----------------------------*/
	
	@RequestMapping("/modalPelicula/{id}")
	public String modalPelicula(Model model, @PathVariable(required = true, name = "id") long id) {
		if(id ==0 ) {
			model.addAttribute("pelicula",new Pelicula());
		}else {
			Pelicula pelicula = peliculaService.buscarPelicula(id);
			model.addAttribute("pelicula",pelicula );
		}
		
	    return "modalPelicula :: modalContents";
	}
	
	/*----------------------------
	 PANTALLA: PELICULA X TURNOS
	-----------------------------*/
	
	@RequestMapping("/peliculaxTurno/{id}")
	public String peliculaXTurnos(Model model, @PathVariable(required = true, name = "id") long id) {
			Pelicula pelicula = peliculaService.buscarPelicula(id);
			
			Peliculaxturno peliculaxturno = new Peliculaxturno();
			peliculaxturno.setPelicula(pelicula);
			peliculaxturno.setTurno(new Turno());
			
			model.addAttribute("peliculaxturno",peliculaxturno);
			
			List<Peliculaxturno> peliculasxturno = peliculaService.listarPeliculasXTurno(id);
			model.addAttribute("turnosxpelicula",peliculasxturno);
			
			List<Turno> turno =  turnoService.listarTurno();
			model.addAttribute("turnos",turno);

	    return "peliculaxTurno";
	}
	

	/*----------------------------
	 PANTALLA: PELICULA X TURNOS
	-----------------------------*/
	
	@RequestMapping("/eliminarTurnoxPelicula/{idPelicula}/{idTurno}")
	public String eliminarPeliculaXTurnos(Model model, @PathVariable(required = true, name = "idPelicula") long idPelicula, @PathVariable(required = true, name = "idTurno") long idTurno) {
			PeliculaxturnoPK peliculapk = new PeliculaxturnoPK();
			peliculapk.setIdPelicula(idPelicula);
			peliculapk.setIdTurno(idTurno);
			
			peliculaService.eliminarPeliculaXTurno(peliculapk);
			
			Pelicula pelicula = peliculaService.buscarPelicula(idPelicula);
			
			Peliculaxturno peliculaxturno = new Peliculaxturno();
			peliculaxturno.setPelicula(pelicula);
			peliculaxturno.setTurno(new Turno());
			
			model.addAttribute("peliculaxturno",peliculaxturno);
			
			List<Peliculaxturno> peliculasxturno = peliculaService.listarPeliculasXTurno(idPelicula);
			model.addAttribute("turnosxpelicula",peliculasxturno);
			
			List<Turno> turno =  turnoService.listarTurno();
			model.addAttribute("turnos",turno);

	    return "peliculaxTurno";
	}
	
    /*---------------------------
	Action : GUARDAR PELICULAS POR TURNOS
	-----------------------------*/
	@RequestMapping(value="/guardarPeliculaxturno", method = RequestMethod.POST)
    public String savePeliculasxTurno(Model model, Peliculaxturno peliculaxturno) {
		
		PeliculaxturnoPK peliculapk = new PeliculaxturnoPK();
		peliculapk.setIdPelicula(peliculaxturno.getPelicula().getIdPelicula());
		peliculapk.setIdTurno(peliculaxturno.getTurno().getIdTurno());
		peliculaxturno.setId(peliculapk);
		peliculaService.mergePeliculaxturno(peliculaxturno);
		
		Pelicula pelicula = peliculaService.buscarPelicula(peliculaxturno.getPelicula().getIdPelicula());
		
		Peliculaxturno peliculaxturnotemp = new Peliculaxturno();
		peliculaxturnotemp.setPelicula(pelicula);
		peliculaxturnotemp.setTurno(new Turno());
		
		model.addAttribute("peliculaxturno",peliculaxturnotemp);
		
		List<Peliculaxturno> peliculasxturno = peliculaService.listarPeliculasXTurno(peliculaxturno.getPelicula().getIdPelicula());
		model.addAttribute("turnosxpelicula",peliculasxturno);
		
		List<Turno> turno =  turnoService.listarTurno();
		model.addAttribute("turnos",turno);
        return "peliculaxTurno";
    }
	
	
	
	/*---------------------------
	Pantalla : LISTA TODAS LOS TURNOS
	-----------------------------*/
	@RequestMapping(value="/turnos")
    public String viewTurnos(Model model) {
    	List<Turno> turno =  turnoService.listarTurno();
        model.addAttribute("turnos", turno);
        return "turnos";
    }
    
    /*---------------------------
	Action : GUARDAR TURNOS
	-----------------------------*/
	@RequestMapping(value="/guardarTurno", method = RequestMethod.POST)
    public String saveTurno(Model model, Turno turno) {
		turnoService.mergeTurno(turno);
    	List<Turno> list =  turnoService.listarTurno();
    	model.addAttribute("turnos", list);
        return "turnos";
    }
	
	/*---------------------------
	Action : ANULAR TURNOS
	-----------------------------*/
	@RequestMapping(value="/eliminarTurno/{id}", method = RequestMethod.GET)
    public String deleteTurno(Model model, @PathVariable(required = true, name = "id") long id) {
		turnoService.eliminarTurno(id);
    	List<Turno> list =  turnoService.listarTurno();
    	model.addAttribute("turnos", list);
        return "turnos";
    }
	
	/*----------------------------
	 PANTALLA: MODAL TURNO
	-----------------------------*/
	
	@RequestMapping("/modalTurno/{id}")
	public String modalTurno(Model model, @PathVariable(required = true, name = "id") long id) {
		
		if(id ==0 ) {
			model.addAttribute("turno",new Turno());
		}else {
			Turno turno = turnoService.buscarTurno(id);
			model.addAttribute("turno",turno );
		}
		
	    return "modalTurno :: modalContents";
	}
	
	

} 