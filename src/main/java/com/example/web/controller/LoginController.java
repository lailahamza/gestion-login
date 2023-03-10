package com.example.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.web.model.Login;
import com.example.web.model.Privilege;
import com.example.web.model.Role;
import com.example.web.service.LoginService;
import com.example.web.service.RoleService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	RoleService roleService;
	
//	@GetMapping("/login")
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String loginPage() {
		
		return "login";
		
	}
	
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String welcomePage(ModelMap model, @RequestParam String id, @RequestParam String pwd) {
		if (loginService.authentif(id, pwd)) {
			model.put("message", "erreur d'authentification!");
			return "login";
		}
		return "welcome";
		}
	
	@GetMapping("/listLogins")
	public ModelAndView listLoginsPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",loginService.getLogins());
		mv.setViewName("listLogins");//page jsp
		for (Object[] obj : loginService.getNombreLoginsByRole()) {
			System.out.println(obj[0]+" ---- "+obj[1]);
		}
		//System.out.println(loginService.getRoleByIntitule("admin"));
		return mv;
		
	}
	
	@GetMapping(value="/affectRole")
	public String affectRole() {
		Role role = new Role(); 
		role.setIntitule("admin");
		Login login = new Login("12","pwd");
		loginService.affectRoleToLogin(login, role);
		return "welcome";
		
	}
	
	@GetMapping("/listIdentifiants")
	public ModelAndView listLogins() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",loginService.getLoginsRole("admin"));
		mv.setViewName("listLogins");//page jsp
		return mv;
		
	}
	
	
	@GetMapping("/affectPrivRole")
	public String affectPrivRole() {
		Role r = new Role(); r.setIntitule("user");
		Privilege p = new Privilege(); p.setIntitule("read");
		roleService.affecterrivilegeRole(p, r);		
		return "welcome";		
	}
	
	
	
	
	
	
}
