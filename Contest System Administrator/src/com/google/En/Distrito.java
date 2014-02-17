package com.google.En;

import java.util.Date;




import java.util.List;
import java.util.Vector;

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

public class Distrito {

	String id_distrito,descripcion,codigo;
	boolean habilitado;
	Entity Dis=null;
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public Distrito(){
		id_distrito="";
		descripcion="";
		codigo="";
		habilitado=true;
	}
	
	public String getId_distrito() {
		return id_distrito;
	}

	public void setId_distrito(String id_distrito) {
		this.id_distrito = id_distrito;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	
	public Distrito(String a,String b,String c){
		id_distrito=a;
		descripcion=b;
		codigo=c;
	}
	public void adicionar(String a,String b,String c) {
	
		Key id_distrito_Key = KeyFactory.createKey("Distrito", a);
		Date date = new Date();
        Entity Distrito = new Entity("Distrito", id_distrito_Key);
        Distrito.setProperty("id_distrito", a);
        Distrito.setProperty("descripcion", b);
        Distrito.setProperty("codigo", c);
        Distrito.setProperty("habilitado",true);
        Distrito.setProperty("date", date);
        datastore.put(Distrito);        
	}

	public void listarC(){
		
		Query query = new Query("Distrito").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> Distrito = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(10));
	    if (Distrito.isEmpty()) {
	    	System.out.println("  no Distritos");
	    } 
	    else {
	    	System.out.println("there districts and are ....");
	        for (int i=0;i<Distrito.size();i++) {
	        	System.out.println("--->"+Distrito.set(i, Dis).getProperties());
	        }
	    }    
	}
	
	public List<Entity> listarL(){

		Query query = new Query("Distrito").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Distrito = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults()); 
		return Distrito;	    
	}
	
	

	public Vector<Entity> listarV(){

		Query query = new Query("Distrito").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Distrito = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		Vector<Entity>v = new Vector<Entity>();
		if (Distrito.isEmpty()) {
		    System.out.println("  no Distritos");
		} 
		else {
		   for (Entity greeting : Distrito) {
		        v.add(greeting);
		    }
		 }   
		 return v;	    
	}
	
	public Entity buscar(String id_distrito){
		Entity e=null;
		Query query = new Query("Distrito").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Distrito = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		if (Distrito.isEmpty()) {
		    System.out.println("  no Distritos");
		} 
		else {
		   for (Entity greeting : Distrito) {
		        if(greeting.getProperty("id_distrito").equals(id_distrito))
		        	e=greeting;
		    }
		 }   
		return e;
	}
	public void delete(String i){
 
	    Query query = new Query("Distrito");
	    query.addFilter("id_distrito", FilterOperator.EQUAL, i);
	    System.out.println(query);
	    PreparedQuery pq = datastore.prepare(query);
	    System.out.println(query);
	    Entity Distrito = pq.asSingleEntity();
	    datastore.delete(Distrito.getKey());
	}
	
	public void update(String i,Entity e){
		
		Query query = new Query("Distrito");
	    query.addFilter("id_distrito", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Distrito = pq.asSingleEntity();
	    datastore.delete(Distrito.getKey());
	    datastore.put(e);  
	}
}
