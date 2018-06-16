package pe.osp.cine.osp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.osp.cine.osp.entity.Pelicula;
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
    	List<Pelicula> peli =  peliculaService.listarPeliculas();
        model.addAttribute("peliculas", peli);
        model.addAttribute("pelicula", new Pelicula());
        return "peliculas";
    }

    /*---------------------------
	Action : GUARDAR PELICULAS
	-----------------------------*/
	@RequestMapping(value="/guardarPelicula", method = RequestMethod.POST)
    public String saveTurno(Model model, Pelicula pelicula) {
		peliculaService.agregarPelicula(pelicula);
    	List<Pelicula> list =  peliculaService.listarPeliculas();
    	model.addAttribute("peliculas", list);
    	model.addAttribute("pelicula", new Pelicula());
        return "peliculas";
    }    
	
	/*---------------------------
	Pantalla : LISTA TODAS LOS TURNOS
	-----------------------------*/
	@RequestMapping(value="/turnos")
    public String viewTurnos(Model model) {
    	List<Turno> turno =  turnoService.listarTurno();
        model.addAttribute("turnos", turno);
        model.addAttribute("turno", new Turno());
        model.addAttribute("tur",new Turno());
        return "turnos";
    }
    
    /*---------------------------
	Action : GUARDAR TURNOS
	-----------------------------*/
	@RequestMapping(value="/guardarTurno", method = RequestMethod.POST)
    public String saveTurno(Model model, Turno turno) {
		turnoService.agregarTurno(turno);
    	List<Turno> list =  turnoService.listarTurno();
    	model.addAttribute("turnos", list);
    	model.addAttribute("turno", new Turno());
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
    	model.addAttribute("turno", new Turno());
        return "turnos";
    }
	
	@RequestMapping("/showContentPart")
	public String showContentPart(Model model) {
		Turno tur = new Turno();
		model.addAttribute("tur",tur );
	    return "turnos :: #contenido";
	}
	
	

} 