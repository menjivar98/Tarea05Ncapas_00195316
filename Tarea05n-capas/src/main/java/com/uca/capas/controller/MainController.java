package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.EstudianteDao;
import com.uca.capas.domain.Estudiante;

@Controller
public class MainController {
	@Autowired
	private EstudianteDao estudianteDao;

	
	@RequestMapping("/inicio")
	public ModelAndView index() {
		Estudiante estudiante = new Estudiante();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante", estudiante);
		mav.setViewName("index");
		
		return mav;
		
	}
	
	@RequestMapping(value="/formulario")
	public ModelAndView insert(Estudiante estudiante) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("estudiante", estudiante);
		
		
		try {
			estudianteDao.insert(new Estudiante(estudiante.getNombre(),
					estudiante.getApellido(),estudiante.getCarnet(),
					estudiante.getCarrera()));
			mav.setViewName("index");
		}catch(Exception e) {
		
		}
		
		
		return mav;
		
	}

	@RequestMapping("/listado")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes =  null;
		try {
			estudiantes = estudianteDao.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		
		return mav;
	}
	
	
	
			
}
