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

public class Administracion_roles_permisos {

	String id_Administracion_roles_permisos,id_Administracion_roles,id_Administracion_permisos;
	boolean habilitado;
	Entity A_r=null;
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public Administracion_roles_permisos(){
		id_Administracion_roles_permisos="";
		id_Administracion_roles="";
		id_Administracion_permisos="";
		habilitado=true;
	}

	public String getId_Administracion_roles_permisos() {
		return id_Administracion_roles_permisos;
	}

	public void setId_Administracion_roles_permisos(
			String id_Administracion_roles_permisos) {
		this.id_Administracion_roles_permisos = id_Administracion_roles_permisos;
	}

	public String getId_Administracion_roles() {
		return id_Administracion_roles;
	}

	public void setId_Administracion_roles(String id_Administracion_roles) {
		this.id_Administracion_roles = id_Administracion_roles;
	}

	public String getId_Administracion_permisos() {
		return id_Administracion_permisos;
	}

	public void setId_Administracion_permisos(String id_Administracion_permisos) {
		this.id_Administracion_permisos = id_Administracion_permisos;
	}
	
	public Administracion_roles_permisos(String a , String b, String c){
		id_Administracion_roles_permisos=a;
		id_Administracion_roles=b;
		id_Administracion_permisos=c;
	}
	
	public void adicionar() {
		
		Key id_Administracion_roles_permisos_Key = KeyFactory.createKey("Administracion_roles_permisos", id_Administracion_roles_permisos);
		Date date = new Date();
        Entity Administracion_roles_permisos = new Entity("Administracion_roles_permisos", id_Administracion_roles_permisos_Key);
        Administracion_roles_permisos.setProperty("id_Administracion_roles_permisos", id_Administracion_roles_permisos);
        Administracion_roles_permisos.setProperty("id_Administracion_roles", id_Administracion_roles);
        Administracion_roles_permisos.setProperty("id_Administracion_permisos", id_Administracion_permisos);
        Administracion_roles_permisos.setProperty("habilitado",true);
        Administracion_roles_permisos.setProperty("date", date);
        datastore.put(Administracion_roles_permisos);
        
	}
	
	public void listarC(){
		
		Query query = new Query("Administracion_roles_permisos").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> Administracion_roles_permisos = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
	    if (Administracion_roles_permisos.isEmpty()) {
	    	System.out.println("  no Administracion_roles_permisos");
	    } 
	    else {
	    	System.out.println("there Administracion_roles_permisos and are ....");
	        for (int i=0;i<Administracion_roles_permisos.size();i++) {
	        	System.out.println("--->"+Administracion_roles_permisos.set(i, A_r).getProperties());
	        }
	    }    
	}
	
	public List<Entity> listarL(){

		Query query = new Query("Administracion_roles_permisos").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Administracion_roles_permisos = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults()); 
		return Administracion_roles_permisos;	    
	}
	
	public Vector<Entity> listarV(){

		Query query = new Query("Administracion_roles_permisos").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Administracion_roles_permisos = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		Vector<Entity>v = new Vector<Entity>();
		if (Administracion_roles_permisos.isEmpty()) {
		    System.out.println("  no Administracion_roles_permisos");
		} 
		else {
		   for (Entity greeting : Administracion_roles_permisos) {
		        v.add(greeting);
		    }
		 }   
		 return v;	    
	}
	
	public Entity buscar(String id_Administracion_roles_permisos){
		Entity e=null;
		Query query = new Query("Administracion_roles_permisos").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Administracion_roles_permisos = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		if (Administracion_roles_permisos.isEmpty()) {
		    System.out.println("  no Administracion_permisos");
		} 
		else {
		   for (Entity greeting : Administracion_roles_permisos) {
		        if(greeting.getProperty("id_Administracion_roles_permisos").equals(id_Administracion_roles_permisos))
		        	e=greeting;
		    }
		 }   
		return e;
	}
	
	public void delete(String i){
		 
	    Query query = new Query("Administracion_roles_permisos");
	    query.addFilter("id_Administracion_roles_permisos", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Administracion_roles_permisos = pq.asSingleEntity();
	    datastore.delete(Administracion_roles_permisos.getKey());
	}
	
	public void update(String i){
		
		Query query = new Query("Administracion_roles_permisos");
	    query.addFilter("id_Administracion_roles_permisos", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Administracion_roles_permisos = pq.asSingleEntity();
	    datastore.delete(Administracion_roles_permisos.getKey());  
	}
	
}
