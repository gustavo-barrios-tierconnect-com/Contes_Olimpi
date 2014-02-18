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

public class Ubicacion_seccion {
	
	String id_Ubicacion_seccion,descripcion,codigo,id_Ubicacion_provincia;
	boolean habilitado;
	Entity U_se=null;
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public Ubicacion_seccion(){
		id_Ubicacion_seccion="";
		descripcion="";
		codigo="";
		id_Ubicacion_provincia="";
		habilitado=true;
	}

	public String getId_Ubicacion_seccion() {
		return id_Ubicacion_seccion;
	}

	public void setId_Ubicacion_seccion(String id_Ubicacion_seccion) {
		this.id_Ubicacion_seccion = id_Ubicacion_seccion;
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

	public String getId_Ubicacion_provincia() {
		return id_Ubicacion_provincia;
	}

	public void setId_Ubicacion_provincia(String id_Ubicacion_provincia) {
		this.id_Ubicacion_provincia = id_Ubicacion_provincia;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public Ubicacion_seccion(String a , String b, String c,String d){
		id_Ubicacion_seccion=a;
		descripcion=b;
		codigo=c;
		id_Ubicacion_provincia=d;
	}
	
	public void adicionar() {
		
		Key id_Ubicacion_seccion_Key = KeyFactory.createKey("Ubicacion_seccion", id_Ubicacion_seccion);
		Date date = new Date();
        Entity Ubicacion_seccion = new Entity("Ubicacion_seccion", id_Ubicacion_seccion_Key);
        Ubicacion_seccion.setProperty("id_Ubicacion_seccion", id_Ubicacion_seccion);
        Ubicacion_seccion.setProperty("descripcion", descripcion);
        Ubicacion_seccion.setProperty("codigo", codigo);
        Ubicacion_seccion.setProperty("id_Ubicacion_provincia", id_Ubicacion_provincia);
        Ubicacion_seccion.setProperty("habilitado",true);
        Ubicacion_seccion.setProperty("date", date);
        datastore.put(Ubicacion_seccion);
        
	}
	
	public void listarC(){
		
		Query query = new Query("Ubicacion_seccion").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> Ubicacion_seccion = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
	    if (Ubicacion_seccion.isEmpty()) {
	    	System.out.println("  no Ubicacion_seccion");
	    } 
	    else {
	    	System.out.println("there Ubicacion_secciones and are ....");
	        for (int i=0;i<Ubicacion_seccion.size();i++) {
	        	System.out.println("--->"+Ubicacion_seccion.set(i, U_se).getProperties());
	        }
	    }    
	}
	
	public List<Entity> listarL(){

		Query query = new Query("Ubicacion_seccion").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Ubicacion_seccion = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults()); 
		return Ubicacion_seccion;	    
	}
	
	public Vector<Entity> listarV(){

		Query query = new Query("Ubicacion_seccion").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Ubicacion_seccion = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		Vector<Entity>v = new Vector<Entity>();
		if (Ubicacion_seccion.isEmpty()) {
		    System.out.println("  no Ubicacion_seccion");
		} 
		else {
		   for (Entity greeting : Ubicacion_seccion) {
		        v.add(greeting);
		    }
		 }   
		 return v;	    
	}
	
	public Entity buscar(String id_Ubicacion_seccion){
		Entity e=null;
		Query query = new Query("Ubicacion_seccion").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Ubicacion_seccion = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		if (Ubicacion_seccion.isEmpty()) {
		    System.out.println("  no Ubicacion_seccion");
		} 
		else {
		   for (Entity greeting : Ubicacion_seccion) {
		        if(greeting.getProperty("id_Ubicacion_seccion").equals(id_Ubicacion_seccion))
		        	e=greeting;
		    }
		 }   
		return e;
	}
	
	public void delete(String i){
		 
	    Query query = new Query("Ubicacion_seccion");
	    query.addFilter("id_Ubicacion_seccion", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Ubicacion_seccion = pq.asSingleEntity();
	    datastore.delete(Ubicacion_seccion.getKey());
	}
	
	public void update(String i){
		
		Query query = new Query("Ubicacion_seccion");
	    query.addFilter("id_Ubicacion_seccion", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Ubicacion_seccion = pq.asSingleEntity();
	    datastore.delete(Ubicacion_seccion.getKey());  
	}
	
}
