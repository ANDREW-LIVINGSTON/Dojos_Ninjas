package com.AL.dojoninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AL.dojoninjas.services.DojoService;
import com.AL.dojoninjas.services.NinjaService;
import com.AL.dojoninjas.models.Dojo;
import com.AL.dojoninjas.models.Ninja;

@Controller
public class DojoController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	public DojoController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }
	
	
	@RequestMapping("/dojos/new")
	public String newDojo(Model model) {
		model.addAttribute("dojo", new Dojo());
        return "createDojo.jsp";
	}
	@RequestMapping(value="/dojos", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
        	return "createDojo.jsp";
        } else {
			dojoService.createDojo(dojo);
            return "createDojo.jsp";
        }
   }

	@RequestMapping("/ninjas/new")
	public String newNinja(Model model) {
		model.addAttribute("ninja", new Ninja());
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
;		return "createPerson.jsp";
	}
	@RequestMapping(value="/ninjas", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
        	return"createPerson.jsp";
        } else {
			ninjaService.createNinja(ninja);
        	return "createPerson.jsp";
    	}
	}
	
	@RequestMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findDojo(id));
		
		List<Ninja> ninjas = ninjaService.allNinjas();
		model.addAttribute("ninjas", ninjas);
		return "show.jsp";
	}
}
	
	