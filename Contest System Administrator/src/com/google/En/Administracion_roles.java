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

public class Administracion_roles {

	String id_Administracion_roles,descripcion_corta,descripcion;
	boolean habilitado;
	Entity A_r=null;
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public Administracion_roles(){
		id_Administracion_roles="";
		descripcion_corta="";
		descripcion="";
		habilitado=true;
	}

	public String getId_Administracion_roles() {
		return id_Administracion_roles;
	}

	public void setId_Administracion_roles(String id_Administracion_roles) {
		this.id_Administracion_roles = id_Administracion_roles;
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
	
	public Administracion_roles(String a , String b, String c){
		id_Administracion_roles=a;
		descripcion_corta=b;
		descripcion=c;
	}
	
	public void adicionar() {
		
		Key id_Administracion_roles_Key = KeyFactory.createKey("Administracion_roles", id_Administracion_roles);
		Date date = new Date();
        Entity Administracion_roles = new Entity("Administracion_roles", id_Administracion_roles_Key);
        Administracion_roles.setProperty("id_Administracion_roles", id_Administracion_roles);
        Administracion_roles.setProperty("descripcion_corta", descripcion_corta);
        Administracion_roles.setProperty("descripcion", descripcion);
        Administracion_roles.setProperty("habilitado",true);
        Administracion_roles.setProperty("date", date);
        datastore.put(Administracion_roles);
        
	}
	
	public void listarC(){
		
		Query query = new Query("Administracion_roles").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> Administracion_roles = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
	    if (Administracion_roles.isEmpty()) {
	    	System.out.println("  no Administracion_roles");
	    } 
	    else {
	    	System.out.println("there Administracion_roles and are ....");
	        for (int i=0;i<Administracion_roles.size();i++) {
	        	System.out.println("--->"+Administracion_roles.set(i, A_r).getProperties());
	        }
	    }    
	}
	
	public List<Entity> listarL(){

		Query query = new Query("Administracion_roles").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Administracion_roles = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults()); 
		return Administracion_roles;	    
	}
	
	public Vector<Entity> listarV(){

		Query query = new Query("Administracion_roles").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Administracion_roles = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		Vector<Entity>v = new Vector<Entity>();
		if (Administracion_roles.isEmpty()) {
		    System.out.println("  no Administracion_roles");
		} 
		else {
		   for (Entity greeting : Administracion_roles) {
		        v.add(greeting);
		    }
		 }   
		 return v;	    
	}
	
	public Entity buscar(String id_Administracion_roles){
		Entity e=null;
		Query query = new Query("Administracion_roles").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Administracion_roles = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		if (Administracion_roles.isEmpty()) {
		    System.out.println("  no Administracion_permisos");
		} 
		else {
		   for (Entity greeting : Administracion_roles) {
		        if(greeting.getProperty("id_Administracion_roles").equals(id_Administracion_roles))
		        	e=greeting;
		    }
		 }   
		return e;
	}
	
	public void delete(String i){
		 
	    Query query = new Query("Administracion_roles");
	    query.addFilter("id_Administracion_roles", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Administracion_roles = pq.asSingleEntity();
	    datastore.delete(Administracion_roles.getKey());
	}
		
	public void update(String i){
		
		Query query = new Query("Administracion_roles");
	    query.addFilter("id_Administracion_roles", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Administracion_roles = pq.asSingleEntity();
	    datastore.delete(Administracion_roles.getKey());  
	}
	
}
