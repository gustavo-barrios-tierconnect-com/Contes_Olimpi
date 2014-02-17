package com.google.controller;

import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
public class Persona {
	String Username;
	String nombre;
	String apellido_paterno;
	String apellido_materno;
	String ci;
	String fecha_nacimiento;
	String genero;
	
	public Persona(){
		Username="";
		nombre="";
		apellido_paterno="";
		apellido_materno="";
		ci="";
		fecha_nacimiento="";
		genero="";
	}
	public Persona(String u,String a,String b,String c,String d,String e,String f){
		Username=u;
		nombre=a;
		apellido_paterno=b;
		apellido_materno=c;
		ci=d;
		fecha_nacimiento=e;
		genero=f;
	}
	public void adicionar(){
		
		
		Key des = KeyFactory.createKey("Persona", nombre);
        
		Date date = new Date();
        Entity Persona = new Entity("Persona", des);
        Persona.setProperty("Username",Username );
        Persona.setProperty("nombre",nombre );
        Persona.setProperty("apellido_paterno",apellido_paterno );
        Persona.setProperty("apellido_materno", apellido_materno);
        Persona.setProperty("ci", ci);
        Persona.setProperty("fecha_nacimiento",fecha_nacimiento );
        Persona.setProperty("genero",genero );
        Persona.setProperty("date", date);
        
        
      //  System.out.println(nombre+" "+apellido_paterno+""+apellido_materno+" "+ci+" "+fecha_nacimiento+" "+genero);
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(Persona);
	}
	
	public List<Entity> listar(){
		System.out.println("entra aki");
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("Persona").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> Persona = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(10));
	    if (Persona.isEmpty()) {
	    	System.out.println("  no Usuarios");
	        //<p>Guestbook '${fn:escapeXml(guestbookName)}' has no messages. pero porq pasa esto..???</p>
	    } else {
	       // <!--  <p>Messages in Guestbook '${fn:escapeXml(guestbookName)}'.</p> un pinche sms jeje-->
	    	System.out.println("existe Usuarios y son ....");
	        for (Entity greeting : Persona) {
	        	System.out.println("--->"+greeting.getProperties());
	        }
	    }
	   return Persona;	    
	}
	
	public void delete_U(String nombre){
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();  
	    Query query = new Query("Persona");
		query.addFilter("nombre", FilterOperator.EQUAL, nombre);
		PreparedQuery pq = datastore.prepare(query);
		Entity Persona = pq.asSingleEntity();
	    datastore.delete(Persona.getKey());
	}
	
	/*public void update(String Username,ModelMap model){
		
		System.out.println("entra a update....");
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("Usuario");
		query.addFilter("Username", FilterOperator.EQUAL, Username);
		PreparedQuery pq = datastore.prepare(query);
		Entity e = pq.asSingleEntity();
		model.addAttribute("Usuario",  e);
		
	}
	public void update1(String Username,String password,HttpServletRequest request){
		
		System.out.println("entra al 2 update.....");
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		 
		
		String originalName =  request.getParameter("originalName");
		
		Query query = new Query("Usuario");
		query.addFilter("Username", FilterOperator.EQUAL, originalName);
		PreparedQuery pq = datastore.prepare(query);
		Entity Usuario = pq.asSingleEntity();
		
		Usuario.setProperty("Username", Username);
		Usuario.setProperty("password", password);
		Usuario.setProperty("date", new Date());

        datastore.put(Usuario);
        
        //return to list
		
	}*/
}
