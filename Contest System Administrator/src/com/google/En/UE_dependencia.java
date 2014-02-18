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

public class UE_dependencia {
	
	String id_UE_dependencia,descripcion;
	boolean habilitado;
	Entity UE_de=null;
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public UE_dependencia(){
		id_UE_dependencia="";
		descripcion="";
		habilitado=true;
	}

	public String getId_UE_dependencia() {
		return id_UE_dependencia;
	}

	public void setId_UE_dependencia(String id_UE_dependencia) {
		this.id_UE_dependencia = id_UE_dependencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public UE_dependencia(String a , String b){
		id_UE_dependencia=a;
		descripcion=b;
	}
	
	public void adicionar() {
		
		Key id_UE_dependencia_Key = KeyFactory.createKey("UE_dependencia", id_UE_dependencia);
		Date date = new Date();
        Entity UE_dependencia = new Entity("UE_dependencia", id_UE_dependencia_Key);
        UE_dependencia.setProperty("id_UE_dependencia", id_UE_dependencia);
        UE_dependencia.setProperty("descripcion", descripcion);
        UE_dependencia.setProperty("habilitado",true);
        UE_dependencia.setProperty("date", date);
        datastore.put(UE_dependencia);        
	}
	
	public void listarC(){
		
		Query query = new Query("UE_dependencia").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> UE_dependencia = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
	    if (UE_dependencia.isEmpty()) {
	    	System.out.println("  no UE_dependencia");
	    } 
	    else {
	    	System.out.println("there UE_dependencias and are ....");
	        for (int i=0;i<UE_dependencia.size();i++) {
	        	System.out.println("--->"+UE_dependencia.set(i, UE_de).getProperties());
	        }
	    }    
	}
	
	public List<Entity> listarL(){

		Query query = new Query("UE_dependencia").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> UE_dependencia = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults()); 
		return UE_dependencia;	    
	}
	
	public Vector<Entity> listarV(){

		Query query = new Query("UE_dependencia").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> UE_dependencia = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		Vector<Entity>v = new Vector<Entity>();
		if (UE_dependencia.isEmpty()) {
		    System.out.println("  no Distritos");
		} 
		else {
		   for (Entity greeting : UE_dependencia) {
		        v.add(greeting);
		    }
		 }   
		 return v;	    
	}
	
	public Entity buscar(String id_UE_dependencia){
		Entity e=null;
		Query query = new Query("UE_dependencia").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> UE_dependencia = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		if (UE_dependencia.isEmpty()) {
		    System.out.println("  no UE_dependencia");
		} 
		else {
		   for (Entity greeting : UE_dependencia) {
		        if(greeting.getProperty("id_UE_dependencia").equals(id_UE_dependencia))
		        	e=greeting;
		    }
		 }   
		return e;
	}
	
	public void delete(String i){
		 
	    Query query = new Query("UE_dependencia");
	    query.addFilter("id_UE_dependencia", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity UE_dependencia = pq.asSingleEntity();
	    datastore.delete(UE_dependencia.getKey());
	}
	
	public void update(String i){
		
		Query query = new Query("UE_dependencia");
	    query.addFilter("id_UE_dependencia", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity UE_dependencia = pq.asSingleEntity();
	    datastore.delete(UE_dependencia.getKey());  
	}
	
}
