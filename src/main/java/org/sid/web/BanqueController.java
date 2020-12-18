package org.sid.web;

import org.sid.entities.Compte;
import org.sid.metier.IBanque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BanqueController {
     @Autowired
	private IBanque banque;
	
     @RequestMapping("/operations")
     public String index()
     {
    	 return "comptes";
     }
     @RequestMapping("/consulterCompte")
     public String consulter(Model model,String cpte)
     { 
    	  model.addAttribute("message", "hello");
    	 model.addAttribute("codeCompte",cpte);
    	try {
    	Compte cp=banque.consulterCompte(cpte); 
       	 model.addAttribute("comptes",cp);
		} catch (Exception e) { 
			// TODO: handle exception
			model.addAttribute("exception",e);
		} 
    	 return "comptes";
     }
	
	
}
