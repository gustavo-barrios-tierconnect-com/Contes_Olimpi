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
public class ubicacion_pais {

	String id_ubicacion_pais,descripcion,codigo;
	boolean habilitado;
	Entity U_p=null;
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public ubicacion_pais(){
		id_ubicacion_pais="";
		descripcion="";
		codigo="";
		habilitado=true;
	}

	public String getId_ubicacion_pais() {
		return id_ubicacion_pais;
	}

	public void setId_ubicacion_pais(String id_ubicacion_pais) {
		this.id_ubicacion_pais = id_ubicacion_pais;
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
	
	public ubicacion_pais(String a , String b, String c){
		id_ubicacion_pais=a;
		descripcion=b;
		codigo=c;
	}
	
	public void adicionar() {
		
		Key id_ubicacion_pais_Key = KeyFactory.createKey("ubicacion_pais", id_ubicacion_pais);
		Date date = new Date();
        Entity ubicacion_pais = new Entity("ubicacion_pais", id_ubicacion_pais_Key);
        ubicacion_pais.setProperty("id_ubicacion_pais", id_ubicacion_pais);
        ubicacion_pais.setProperty("descripcion", descripcion);
        ubicacion_pais.setProperty("codigo", codigo);
        ubicacion_pais.setProperty("habilitado",true);
        ubicacion_pais.setProperty("date", date);
        datastore.put(ubicacion_pais);        
	}
	
	public void listarC(){
		
		Query query = new Query("ubicacion_pais").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> ubicacion_pais = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
	    if (ubicacion_pais.isEmpty()) {
	    	System.out.println("  no ubicacion_pais");
	    } 
	    else {
	    	System.out.println("there ubicacion_paises and are ....");
	        for (int i=0;i<ubicacion_pais.size();i++) {
	        	System.out.println("--->"+ubicacion_pais.set(i, U_p).getProperties());
	        }
	    }    
	}
	
	public List<Entity> listarL(){

		Query query = new Query("ubicacion_pais").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> ubicacion_pais = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults()); 
		return ubicacion_pais;	    
	}
	
	public Vector<Entity> listarV(){

		Query query = new Query("ubicacion_pais").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> ubicacion_pais = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		Vector<Entity>v = new Vector<Entity>();
		if (ubicacion_pais.isEmpty()) {
		    System.out.println("  no ubicacion_pais");
		} 
		else {
		   for (Entity greeting : ubicacion_pais) {
		        v.add(greeting);
		    }
		 }   
		 return v;	    
	}
	
	public Entity buscar(String id_ubicacion_pais){
		Entity e=null;
		Query query = new Query("ubicacion_pais").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> ubicacion_pais = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		if (ubicacion_pais.isEmpty()) {
		    System.out.println("  no UE_area");
		} 
		else {
		   for (Entity greeting : ubicacion_pais) {
		        if(greeting.getProperty("id_ubicacion_pais").equals(id_ubicacion_pais))
		        	e=greeting;
		    }
		 }   
		return e;
	}
	
	public void delete(String i){
		 
	    Query query = new Query("ubicacion_pais");
	    query.addFilter("id_ubicacion_pais", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity ubicacion_pais = pq.asSingleEntity();
	    datastore.delete(ubicacion_pais.getKey());
	}
	
	public void update(String i){
		
		Query query = new Query("ubicacion_pais");
	    query.addFilter("id_ubicacion_pais", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity ubicacion_pais = pq.asSingleEntity();
	    datastore.delete(ubicacion_pais.getKey());  
	}
	
	
}
