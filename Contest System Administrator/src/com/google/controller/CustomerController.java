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
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	private static Entity Distrito = null;
	private static Entity UE_turno = null;
	private static Entity UE_dependencia= null;
	private static Entity UE_area= null;
	private static Entity ubicacion_pais=null;
	private static Entity ubicacion_departamento=null;
	private static Entity Ubicacion_provincia=null;
	private static Entity Ubicacion_seccion=null;
	private static Entity Ubicacion_canton=null;
	private static Entity ubicacion_localidad=null;
	private static Entity Ubicacion_zona=null;
	private static Entity Ubicacion_calle=null;
	private static Entity Evaluacion=null;
	private static Entity Administracion_permisos=null;
	private static Entity Administracion_roles=null;
	private static Entity Administracion_roles_permisos=null;
	private static Entity Administracion_usuario_roles=null;
	private static Entity Parentezco=null;
	Parentezco pa=new Parentezco();
	Administracion_usuario_roles aur=new Administracion_usuario_roles();
	Administracion_roles_permisos aro=new Administracion_roles_permisos(); 
	Administracion_roles_permisos arp=new Administracion_roles_permisos();
	Administracion_permisos ap=new Administracion_permisos();
	Evaluacion ev=new Evaluacion();
	Ubicacion_calle uca=new Ubicacion_calle();
	Ubicacion_zona uzo=new Ubicacion_zona();
	ubicacion_localidad ul=new ubicacion_localidad();
	Ubicacion_canton uc=new Ubicacion_canton();
	Ubicacion_seccion use=new Ubicacion_seccion();
	Ubicacion_provincia us=new Ubicacion_provincia();
	ubicacion_departamento ud=new ubicacion_departamento();
	Usuario u=new Usuario();
	Persona per=new Persona();
	Distrito d=new Distrito();
	UE_turno t=new UE_turno();
	UE_area ar=new UE_area();
	UE_dependencia de=new UE_dependencia();
	ubicacion_pais upro=new ubicacion_pais();
	public Scanner leer=new Scanner(System.in);
	//get all customers
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String Registrar(ModelMap model) {
		
		return "register";
	}
	
	@RequestMapping(value="/Distrito", method = RequestMethod.GET)
	public String Distritos(ModelMap model) {
		
		pa.listarC();
		System.out.println("si si es primera ves");
		if(leer.next().equals("si")){
			System.out.println("adicionar");
			String a=leer.next(),b=leer.next();
			pa=new Parentezco(a,b);
			pa.adicionar();
		}
		
		System.out.println("entro a distrito y va a listar....");
		pa.listarC();
		System.out.println("adicionar");
		String a=leer.next(),b=leer.next();
		pa=new Parentezco(a,b);
		pa.adicionar();
		pa.listarC();
		
		System.out.println("ahora vamos a buscar ");
		String aa;
		aa=leer.next();
		Ubicacion_provincia = null;
		Ubicacion_provincia = pa.buscar(aa);
		if(Ubicacion_provincia != null)
			System.out.println("si existe.....");
		else System.out.println("No existe....");
		pa.listarC();
		
		
		System.out.println("ahora vamos a eliminar ");
		aa=leer.next();
		pa.delete(aa);
		pa.listarC();
	
		
		System.out.println("ahora vamos a editar ");
		aa=leer.next();
		a=leer.next();b=leer.next();
		pa.delete(aa);
		pa=new Parentezco(a,b);
		pa.adicionar();
		pa.listarC();
		
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