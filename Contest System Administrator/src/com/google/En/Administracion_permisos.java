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

public class Administracion_permisos {
	
	String id_Administracion_permisos,descripcion_corta,descripcion;
	boolean habilitado;
	Entity A_p=null;
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public Administracion_permisos(){
		id_Administracion_permisos="";
		descripcion_corta="";
		descripcion="";
		habilitado=true;
	}

	public String getId_Administracion_permisos() {
		return id_Administracion_permisos;
	}

	public void setId_Administracion_permisos(String id_Administracion_permisos) {
		this.id_Administracion_permisos = id_Administracion_permisos;
	}

	public String getDescripcion_corta() {
		return descripcion_corta;
	}

	public void setDescripcion_corta(String descripcion_corta) {
		this.descripcion_corta = descripcion_corta;
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
	
	public Administracion_permisos(String a , String b, String c){
		id_Administracion_permisos=a;
		descripcion_corta=b;
		descripcion=c;
	}
	
	public void adicionar() {
		
		Key id_Administracion_permisos_Key = KeyFactory.createKey("Administracion_permisos", id_Administracion_permisos);
		Date date = new Date();
        Entity Administracion_permisos = new Entity("Administracion_permisos", id_Administracion_permisos_Key);
        Administracion_permisos.setProperty("id_Administracion_permisos", id_Administracion_permisos);
        Administracion_permisos.setProperty("descripcion_corta", descripcion_corta);
        Administracion_permisos.setProperty("descripcion", descripcion);
        Administracion_permisos.setProperty("habilitado",true);
        Administracion_permisos.setProperty("date", date);
        datastore.put(Administracion_permisos);
        
	}
	
	public void listarC(){
		
		Query query = new Query("Administracion_permisos").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> Administracion_permisos = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
	    if (Administracion_permisos.isEmpty()) {
	    	System.out.println("  no Administracion_permisos");
	    } 
	    else {
	    	System.out.println("there Administracion_permisos and are ....");
	        for (int i=0;i<Administracion_permisos.size();i++) {
	        	System.out.println("--->"+Administracion_permisos.set(i, A_p).getProperties());
	        }
	    }    
	}
	
	public List<Entity> listarL(){

		Query query = new Query("Administracion_permisos").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Administracion_permisos = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults()); 
		return Administracion_permisos;	    
	}
	
	public Vector<Entity> listarV(){

		Query query = new Query("Administracion_permisos").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Administracion_permisos = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		Vector<Entity>v = new Vector<Entity>();
		if (Administracion_permisos.isEmpty()) {
		    System.out.println("  no Administracion_permisos");
		} 
		else {
		   for (Entity greeting : Administracion_permisos) {
		        v.add(greeting);
		    }
		 }   
		 return v;	    
	}
	
	public Entity buscar(String id_Administracion_permisos){
		Entity e=null;
		Query query = new Query("Administracion_permisos").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Administracion_permisos = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		if (Administracion_permisos.isEmpty()) {
		    System.out.println("  no Administracion_permisos");
		} 
		else {
		   for (Entity greeting : Administracion_permisos) {
		        if(greeting.getProperty("id_Administracion_permisos").equals(id_Administracion_permisos))
		        	e=greeting;
		    }
		 }   
		return e;
	}
	
	public void delete(String i){
		 
	    Query query = new Query("Administracion_permisos");
	    query.addFilter("id_Administracion_permisos", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Administracion_permisos = pq.asSingleEntity();
	    datastore.delete(Administracion_permisos.getKey());
	}
	
	public void update(String i){
		
		Query query = new Query("Ubicacion_calle");
	    query.addFilter("id_Administracion_permisos", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Administracion_permisos = pq.asSingleEntity();
	    datastore.delete(Administracion_permisos.getKey());  
	}
	
}
