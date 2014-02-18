package com.google.En;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;











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

public class ubicacion_localidad {
	
	String id_ubicacion_localidad,descripcion,codigo,id_Ubicacion_canton;
	boolean habilitado;
	Entity U_lo=null;
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public ubicacion_localidad(){
		id_ubicacion_localidad="";
		descripcion="";
		codigo="";
		id_Ubicacion_canton="";
		habilitado=true;
	}

	public String getId_ubicacion_localidad() {
		return id_ubicacion_localidad;
	}

	public void setId_ubicacion_localidad(String id_ubicacion_localidad) {
		this.id_ubicacion_localidad = id_ubicacion_localidad;
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

	public String getId_Ubicacion_canton() {
		return id_Ubicacion_canton;
	}

	public void setId_Ubicacion_canton(String id_Ubicacion_canton) {
		this.id_Ubicacion_canton = id_Ubicacion_canton;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public ubicacion_localidad(String a , String b, String c,String d){
		id_ubicacion_localidad=a;
		descripcion=b;
		codigo=c;
		id_Ubicacion_canton=d;
	}
	
	public void adicionar() {
		
		Key id_ubicacion_localidad_Key = KeyFactory.createKey("ubicacion_localidad", id_Ubicacion_canton);
		Date date = new Date();
        Entity ubicacion_localidad = new Entity("ubicacion_localidad", id_ubicacion_localidad_Key);
        ubicacion_localidad.setProperty("id_ubicacion_localidad", id_ubicacion_localidad);
        ubicacion_localidad.setProperty("descripcion", descripcion);
        ubicacion_localidad.setProperty("codigo", codigo);
        ubicacion_localidad.setProperty("id_Ubicacion_canton", id_Ubicacion_canton);
        ubicacion_localidad.setProperty("habilitado",true);
        ubicacion_localidad.setProperty("date", date);
        datastore.put(ubicacion_localidad);
        
	}
	
	public void listarC(){
		
		Query query = new Query("ubicacion_localidad").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> ubicacion_localidad = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
	    if (ubicacion_localidad.isEmpty()) {
	    	System.out.println("  no ubicacion_localidad");
	    } 
	    else {
	    	System.out.println("there ubicacion_localidades and are ....");
	        for (int i=0;i<ubicacion_localidad.size();i++) {
	        	System.out.println("--->"+ubicacion_localidad.set(i, U_lo).getProperties());
	        }
	    }    
	}
	
	public List<Entity> listarL(){

		Query query = new Query("ubicacion_localidad").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> ubicacion_localidad = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults()); 
		return ubicacion_localidad;	    
	}
	
	public Vector<Entity> listarV(){

		Query query = new Query("ubicacion_localidad").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> ubicacion_localidad = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		Vector<Entity>v = new Vector<Entity>();
		if (ubicacion_localidad.isEmpty()) {
		    System.out.println("  no ubicacion_localidad");
		} 
		else {
		   for (Entity greeting : ubicacion_localidad) {
		        v.add(greeting);
		    }
		 }   
		 return v;	    
	}
	
	public Entity buscar(String id_ubicacion_localidad){
		Entity e=null;
		Query query = new Query("ubicacion_localidad").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> ubicacion_localidad = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		if (ubicacion_localidad.isEmpty()) {
		    System.out.println("  no ubicacion_localidad");
		} 
		else {
		   for (Entity greeting : ubicacion_localidad) {
		        if(greeting.getProperty("id_ubicacion_localidad").equals(id_ubicacion_localidad))
		        	e=greeting;
		    }
		 }   
		return e;
	}
	
	public void delete(String i){
		 
	    Query query = new Query("ubicacion_localidad");
	    query.addFilter("id_ubicacion_localidad", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity ubicacion_localidad = pq.asSingleEntity();
	    datastore.delete(ubicacion_localidad.getKey());
	}
	
	public void update(String i){
		
		Query query = new Query("ubicacion_localidad");
	    query.addFilter("id_ubicacion_localidad", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity ubicacion_localidad = pq.asSingleEntity();
	    datastore.delete(ubicacion_localidad.getKey());  
	}
	
}
