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

public class UE_turno {

	String id_UE_turno,descripcion;
	boolean habilitado;
	Entity UE_tu=null;
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public UE_turno(){
		id_UE_turno="";
		descripcion="";
		habilitado=true;
	}

	public String getId_UE_turno() {
		return id_UE_turno;
	}

	public void setId_UE_turno(String id_UE_turno) {
		this.id_UE_turno = id_UE_turno;
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
	
	public UE_turno(String a , String b){
		id_UE_turno=a;
		descripcion=b;
	}
	
	public void adicionar() {
		
		Key id_UE_turno_Key = KeyFactory.createKey("UE_turno", id_UE_turno);
		Date date = new Date();
        Entity UE_turno = new Entity("UE_turno", id_UE_turno_Key);
        UE_turno.setProperty("id_UE_turno", id_UE_turno);
        UE_turno.setProperty("descripcion", descripcion);
        UE_turno.setProperty("habilitado",true);
        UE_turno.setProperty("date", date);
        datastore.put(UE_turno);        
	}
	
	public void listarC(){
		
		Query query = new Query("UE_turno").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> UE_turno = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
	    if (UE_turno.isEmpty()) {
	    	System.out.println("  no UE_turno");
	    } 
	    else {
	    	System.out.println("there UE_turnos and are ....");
	        for (int i=0;i<UE_turno.size();i++) {
	        	System.out.println("--->"+UE_turno.set(i, UE_tu).getProperties());
	        }
	    }    
	}
	
	public List<Entity> listarL(){

		Query query = new Query("UE_turno").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> UE_turno = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults()); 
		return UE_turno;	    
	}
	
	public Vector<Entity> listarV(){

		Query query = new Query("UE_turno").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> UE_turno = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		Vector<Entity>v = new Vector<Entity>();
		if (UE_turno.isEmpty()) {
		    System.out.println("  no Distritos");
		} 
		else {
		   for (Entity greeting : UE_turno) {
		        v.add(greeting);
		    }
		 }   
		 return v;	    
	}
	
	public Entity buscar(String id_UE_turno){
		Entity e=null;
		Query query = new Query("UE_turno").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> UE_turno = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		if (UE_turno.isEmpty()) {
		    System.out.println("  no UE_turno");
		} 
		else {
		   for (Entity greeting : UE_turno) {
		        if(greeting.getProperty("id_UE_turno").equals(id_UE_turno))
		        	e=greeting;
		    }
		 }   
		return e;
	}
	
	public void delete(String i){
		 
	    Query query = new Query("UE_turno");
	    query.addFilter("id_UE_turno", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity UE_turno = pq.asSingleEntity();
	    datastore.delete(UE_turno.getKey());
	}
	
	public void update(String i){
		
		Query query = new Query("UE_turno");
	    query.addFilter("id_UE_turno", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity UE_turno = pq.asSingleEntity();
	    datastore.delete(UE_turno.getKey());  
	}

	
}
