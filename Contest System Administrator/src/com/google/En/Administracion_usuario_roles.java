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

public class Administracion_usuario_roles {

	String id_Administracion_usuario_roles,id_Administracion_roles,id_Administracion_Usuario;
	boolean habilitado;
	Entity A_ur=null;
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public Administracion_usuario_roles(){
		id_Administracion_usuario_roles="";
		id_Administracion_Usuario="";
		id_Administracion_roles="";
		habilitado=true;
	}

	public String getId_Administracion_usuario_roles() {
		return id_Administracion_usuario_roles;
	}

	public void setId_Administracion_usuario_roles(
			String id_Administracion_usuario_roles) {
		this.id_Administracion_usuario_roles = id_Administracion_usuario_roles;
	}

	public String getId_Administracion_roles() {
		return id_Administracion_roles;
	}

	public void setId_Administracion_roles(String id_Administracion_roles) {
		this.id_Administracion_roles = id_Administracion_roles;
	}

	public String getId_Administracion_Usuario() {
		return id_Administracion_Usuario;
	}

	public void setId_Administracion_Usuario(String id_Administracion_Usuario) {
		this.id_Administracion_Usuario = id_Administracion_Usuario;
	}

	public DatastoreService getDatastore() {
		return datastore;
	}

	public void setDatastore(DatastoreService datastore) {
		this.datastore = datastore;
	}	
	
	
	public Administracion_usuario_roles(String a , String b, String c){
		id_Administracion_usuario_roles=a;
		id_Administracion_Usuario=b;
		id_Administracion_roles=c;
	}
	
	public void adicionar() {
		
		Key id_Administracion_usuario_roles_Key = KeyFactory.createKey("Administracion_usuario_roles", id_Administracion_usuario_roles);
		Date date = new Date();
        Entity Administracion_usuario_roles = new Entity("Administracion_usuario_roles", id_Administracion_usuario_roles_Key);
        Administracion_usuario_roles.setProperty("id_Administracion_usuario_roles", id_Administracion_usuario_roles);
        Administracion_usuario_roles.setProperty("id_Administracion_Usuario",id_Administracion_Usuario);
        Administracion_usuario_roles.setProperty("id_Administracion_roles", id_Administracion_roles);
        Administracion_usuario_roles.setProperty("habilitado",true);
        Administracion_usuario_roles.setProperty("date", date);
        datastore.put(Administracion_usuario_roles);
        
	}
	
	public void listarC(){
		
		Query query = new Query("Administracion_usuario_roles").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> Administracion_usuario_roles = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
	    if (Administracion_usuario_roles.isEmpty()) {
	    	System.out.println("  no Administracion_usuario_roles");
	    } 
	    else {
	    	System.out.println("there Administracion_usuario_roles and are ....");
	        for (int i=0;i<Administracion_usuario_roles.size();i++) {
	        	System.out.println("--->"+Administracion_usuario_roles.set(i, A_ur).getProperties());
	        }
	    }    
	}
	
	public List<Entity> listarL(){

		Query query = new Query("Administracion_usuario_roles").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Administracion_usuario_roles = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults()); 
		return Administracion_usuario_roles;	    
	}
	
	public Vector<Entity> listarV(){

		Query query = new Query("Administracion_usuario_roles").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Administracion_usuario_roles = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		Vector<Entity>v = new Vector<Entity>();
		if (Administracion_usuario_roles.isEmpty()) {
		    System.out.println("  no Administracion_usuario_roles");
		} 
		else {
		   for (Entity greeting : Administracion_usuario_roles) {
		        v.add(greeting);
		    }
		 }   
		 return v;	    
	}
	
	public Entity buscar(String id_Administracion_usuario_roles){
		Entity e=null;
		Query query = new Query("Administracion_usuario_roles").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Administracion_usuario_roles = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		if (Administracion_usuario_roles.isEmpty()) {
		    System.out.println("  no Administracion_usuario_roles");
		} 
		else {
		   for (Entity greeting : Administracion_usuario_roles) {
		        if(greeting.getProperty("id_Administracion_usuario_roles").equals(id_Administracion_usuario_roles))
		        	e=greeting;
		    }
		 }   
		return e;
	}
	
	public void delete(String i){
		 
	    Query query = new Query("Administracion_usuario_roles");
	    query.addFilter("id_Administracion_usuario_roles", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Administracion_usuario_roles = pq.asSingleEntity();
	    datastore.delete(Administracion_usuario_roles.getKey());
	}
	
	public void update(String i){
		
		Query query = new Query("Administracion_usuario_roles");
	    query.addFilter("id_Administracion_usuario_roles", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Administracion_usuario_roles = pq.asSingleEntity();
	    datastore.delete(Administracion_usuario_roles.getKey());  
	}
	
	
	
}
