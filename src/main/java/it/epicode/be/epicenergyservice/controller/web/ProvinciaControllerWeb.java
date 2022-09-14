package it.epicode.be.epicenergyservice.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.epicode.be.epicenergyservice.service.ProvinciaService;

@Controller
@RequestMapping("/province")
public class ProvinciaControllerWeb {

	@Autowired
	ProvinciaService provinciaService;
	
	@GetMapping("/mostraelenco")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public ModelAndView mostraElenco(Pageable pageable) {
		return new ModelAndView("elencoProvince", "listaProvince", provinciaService.findAll(pageable));
	}
	
}
