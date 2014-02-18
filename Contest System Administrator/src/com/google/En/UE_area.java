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
public class UE_area {

	String id_UE_area,descripcion;
	boolean habilitado;
	Entity UE_ar=null;
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public UE_area(){
		id_UE_area="";
		descripcion="";
		habilitado=true;
	}

	public String getId_UE_area() {
		return id_UE_area;
	}

	public void setId_UE_area(String id_UE_area) {
		this.id_UE_area = id_UE_area;
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
	
	public UE_area(String a , String b){
		id_UE_area=a;
		descripcion=b;
	}
	
	public void adicionar() {
		
		Key id_id_UE_area_Key = KeyFactory.createKey("UE_area", id_UE_area);
		Date date = new Date();
        Entity UE_area = new Entity("UE_area", id_id_UE_area_Key);
        UE_area.setProperty("id_UE_area", id_UE_area);
        UE_area.setProperty("descripcion", descripcion);
        UE_area.setProperty("habilitado",true);
        UE_area.setProperty("date", date);
        datastore.put(UE_area);        
	}
	
	public void listarC(){
		
		Query query = new Query("UE_area").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> UE_area = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
	    if (UE_area.isEmpty()) {
	    	System.out.println("  no UE_area");
	    } 
	    else {
	    	System.out.println("there UE_areas and are ....");
	        for (int i=0;i<UE_area.size();i++) {
	        	System.out.println("--->"+UE_area.set(i, UE_ar).getProperties());
	        }
	    }    
	}
	
	public List<Entity> listarL(){

		Query query = new Query("UE_area").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> UE_area = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults()); 
		return UE_area;	    
	}
	
	public Vector<Entity> listarV(){

		Query query = new Query("UE_area").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> UE_area = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		Vector<Entity>v = new Vector<Entity>();
		if (UE_area.isEmpty()) {
		    System.out.println("  no UE_area");
		} 
		else {
		   for (Entity greeting : UE_area) {
		        v.add(greeting);
		    }
		 }   
		 return v;	    
	}
	
	public Entity buscar(String id_UE_area){
		Entity e=null;
		Query query = new Query("UE_area").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> UE_area = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		if (UE_area.isEmpty()) {
		    System.out.println("  no UE_area");
		} 
		else {
		   for (Entity greeting : UE_area) {
		        if(greeting.getProperty("id_UE_area").equals(id_UE_area))
		        	e=greeting;
		    }
		 }   
		return e;
	}
	
	public void delete(String i){
		 
	    Query query = new Query("UE_area");
	    query.addFilter("id_UE_area", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity UE_area = pq.asSingleEntity();
	    datastore.delete(UE_area.getKey());
	}
	
	public void update(String i){
		
		Query query = new Query("UE_area");
	    query.addFilter("id_UE_area", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity UE_area = pq.asSingleEntity();
	    datastore.delete(UE_area.getKey());  
	}
	
	
}
