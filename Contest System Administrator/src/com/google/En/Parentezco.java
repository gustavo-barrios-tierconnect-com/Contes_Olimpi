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

public class Parentezco {


	String id_Parentezco,descripcion;
	boolean habilitado;
	Entity U_ca=null;
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public Parentezco(){
		id_Parentezco="";
		descripcion="";
		habilitado=true;
	}

	public String getId_parentezco() {
		return id_Parentezco;
	}

	public void setId_parentezco(String id_parentezco) {
		this.id_Parentezco = id_parentezco;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Parentezco(String a , String b){
		id_Parentezco=a;
		descripcion=b;
	}
	
	public void adicionar() {
		
		Key id_Parentezco_Key = KeyFactory.createKey("Parentezco", id_Parentezco);
		Date date = new Date();
        Entity Parentezco = new Entity("Parentezco", id_Parentezco_Key);
        Parentezco.setProperty("id_Parentezco", id_Parentezco);
        Parentezco.setProperty("descripcion", descripcion);
        Parentezco.setProperty("habilitado",true);
        Parentezco.setProperty("date", date);
        datastore.put(Parentezco);
        
	}
	
	public void listarC(){
		
		Query query = new Query("Parentezco").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> Parentezco = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
	    if (Parentezco.isEmpty()) {
	    	System.out.println("  no Parentezco");
	    } 
	    else {
	    	System.out.println("there Parentezco and are ....");
	        for (int i=0;i<Parentezco.size();i++) {
	        	System.out.println("--->"+Parentezco.set(i, U_ca).getProperties());
	        }
	    }    
	}
	
	public List<Entity> listarL(){

		Query query = new Query("Parentezco").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Parentezco = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults()); 
		return Parentezco;	    
	}
	
	public Vector<Entity> listarV(){

		Query query = new Query("Parentezco").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Parentezco = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		Vector<Entity>v = new Vector<Entity>();
		if (Parentezco.isEmpty()) {
		    System.out.println("  no Parentezco");
		} 
		else {
		   for (Entity greeting : Parentezco) {
		        v.add(greeting);
		    }
		 }   
		 return v;	    
	}
	
	public Entity buscar(String id_Parentezco){
		Entity e=null;
		Query query = new Query("Parentezco").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Parentezco = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		if (Parentezco.isEmpty()) {
		    System.out.println("  no Parentezco");
		} 
		else {
		   for (Entity greeting : Parentezco) {
		        if(greeting.getProperty("id_Parentezco").equals(id_Parentezco))
		        	e=greeting;
		    }
		 }   
		return e;
	}
	
	public void delete(String i){
		 
	    Query query = new Query("Parentezco");
	    query.addFilter("id_Parentezco", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Parentezco = pq.asSingleEntity();
	    datastore.delete(Parentezco.getKey());
	}
	
	public void update(String i){
		
		Query query = new Query("Parentezco");
	    query.addFilter("id_Parentezco", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Parentezco = pq.asSingleEntity();
	    datastore.delete(Parentezco.getKey());  
	}
	
}
