package com.google.controller;

import java.util.Date;





import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.En.*;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	private static Entity Distrito = null;
	Usuario u=new Usuario();
	Persona per=new Persona();
	Distrito d=new Distrito();
	public Scanner leer=new Scanner(System.in);
	//get all customers
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String Registrar(ModelMap model) {
		
		return "register";
	}
	
	@RequestMapping(value="/Distrito", method = RequestMethod.GET)
	public String Distritos(ModelMap model) {
		System.out.println("entro a distrito y va a listar....");
		
		
		d.listarC();
		System.out.println("adicionar");
		String a=leer.next(),b=leer.next(),c=leer.next();
		d=new Distrito();
		d.adicionar(a,b,c);
		d.listarC();
		
		System.out.println("ahora vamos a buscar ");
		String aa;
		aa=leer.next();
		Distrito = d.buscar(aa);
		d.listarC();
		
		
		System.out.println("ahora vamos a eliminar ");
		aa=leer.next();
		d.delete(aa);
		d.listarC();
	
		
		System.out.println("ahora vamos a editar ");
		aa=leer.next();
		a=leer.next();b=leer.next();c=leer.next();
		
		d.delete(aa);
		d=new Distrito(a,b,c);
		d.adicionar(a,b,c);
		d.listarC();
		
		return "thank";
	}
	
	@RequestMapping(value="/add_u", method = RequestMethod.POST)
	public ModelAndView add_u(HttpServletRequest request, ModelMap model) {

		String Username = request.getParameter("Username");
		String password = request.getParameter("password");
		String nombre = request.getParameter("nombre");
		String ap = request.getParameter("ap");
		String am = request.getParameter("am");
		String ci = request.getParameter("ci");
		String f = request.getParameter("f");
		String sexo = request.getParameter("sexo");
		per=new Persona(Username,nombre,ap,am,ci,f,sexo);
		per.adicionar();
		
		u=new Usuario(Username,password);
		u.adicionar_U();
		
        return new ModelAndView("redirect:thank");
        
	}
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String Index(ModelMap model) {
		//revisar porq dar vueltas....
		return "index";
	}
	
	@RequestMapping(value="/thank", method = RequestMethod.GET)
	public String Thank(ModelMap model) {
		
		return "thank";
	}
	
	@RequestMapping(value="/list_U", method = RequestMethod.GET)
	public String listUsuarios(ModelMap model) {

		
		List<Entity> Usuario = u.listar_U();
		List<Entity> Persona =per.listar();
	    model.addAttribute("UsuarioList",  Usuario);
		return "list_U";

	}
	
	@RequestMapping(value="/delete_U/{Username}", method = RequestMethod.GET)
	public ModelAndView delete_U(@PathVariable String Username,
			HttpServletRequest request, ModelMap model) {

		System.out.println("modificando el delete....");
        u.delete_U(Username);
        return new ModelAndView("redirect:../list_U");
        
	}
	
	@RequestMapping(value="/update_U/{Username}", method = RequestMethod.GET)
	public String getUpdateCustomerPage_U(@PathVariable String Username, 
			HttpServletRequest request, ModelMap model) {
		
		u.update(Username,model);
		
		return "update_U";

	}

	
	@RequestMapping(value="/update_U", method = RequestMethod.POST)
	public ModelAndView update_U(HttpServletRequest request, ModelMap model) {

		String Username = request.getParameter("Username");
		String password = request.getParameter("password");
		u.update1(Username, password,request);
        return new ModelAndView("redirect:list_U");
        
	}
	
	
}