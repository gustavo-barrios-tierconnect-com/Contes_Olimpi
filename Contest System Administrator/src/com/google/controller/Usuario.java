package com.google.controller;

import java.util.Date;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.EmbeddedEntity;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

public class Usuario {
	String Username;
	String password;

	public Usuario(){
		Username="";
		password="";
	}
	
	public Usuario(String u,String p){
		Username=u;
		password=p;
	}
	public void adicionar_U() {
	
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key customerKey = KeyFactory.createKey("Usuario", Username);
        
		Date date = new Date();
        Entity Usuario = new Entity("Usuario", customerKey);
        Usuario.setProperty("Username", Username);
        Usuario.setProperty("password", password);
        Usuario.setProperty("date", date);
        
        
        Query q = new Query("Persona");
        q.addFilter("Username", FilterOperator.EQUAL, Username);
        PreparedQuery pq = datastore.prepare(q);
        Entity Persona = pq.asSingleEntity();
        
     
     // Entity employee = /*...*/;
     // Entity contactInfo = /*...*/;
     EmbeddedEntity embeddedContactInfo = new EmbeddedEntity();
     Key infoKey = Persona.getKey();
     embeddedContactInfo.setKey(infoKey);
     embeddedContactInfo.setPropertiesFrom(Persona);

     Usuario.setProperty("InfoPersona", embeddedContactInfo);
        
      //  System.out.println(Username+"<-->"+password);

        datastore.put(Usuario);
        
       // System.out.println(Usuario.getProperties());
        
	}
	
	public List<Entity> listar_U(){
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("Usuario").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> Usuario = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(10));
	    if (Usuario.isEmpty()) {
	    	System.out.println("  no Usuarios");
	        //<p>Guestbook '${fn:escapeXml(guestbookName)}' has no messages. pero porq pasa esto..???</p>
	    } else {
	       // <!--  <p>Messages in Guestbook '${fn:escapeXml(guestbookName)}'.</p> un pinche sms jeje-->
	    	System.out.println("existe Usuarios y son ....");
	        for (Entity greeting : Usuario) {
	        	System.out.println("--->"+greeting.getProperties());
	        }
	    }
	    return Usuario;	    
	}
	
	public void delete_U(String u){
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();  
	    Query query = new Query("Usuario");
		query.addFilter("Username", FilterOperator.EQUAL, u);
		PreparedQuery pq = datastore.prepare(query);
		Entity Usuario = pq.asSingleEntity();
	    datastore.delete(Usuario.getKey());
	}
	
	public void update(String Username,ModelMap model){
		
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
		
	}

}
