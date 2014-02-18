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

public class Ubicacion_provincia {
	
	String id_Ubicacion_provincia,descripcion,codigo,id_ubicacion_departamento;
	boolean habilitado;
	Entity U_pro=null;
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public Ubicacion_provincia(){
		id_Ubicacion_provincia="";
		descripcion="";
		codigo="";
		id_ubicacion_departamento="";
		habilitado=true;
	}

	public String getId_Ubicacion_provincia() {
		return id_Ubicacion_provincia;
	}

	public void setId_Ubicacion_provincia(String id_Ubicacion_provincia) {
		this.id_Ubicacion_provincia = id_Ubicacion_provincia;
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

	public String getId_ubicacion_departamento() {
		return id_ubicacion_departamento;
	}

	public void setId_ubicacion_departamento(String id_ubicacion_departamento) {
		this.id_ubicacion_departamento = id_ubicacion_departamento;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public Ubicacion_provincia(String a , String b, String c,String d){
		id_Ubicacion_provincia=a;
		descripcion=b;
		codigo=c;
		id_ubicacion_departamento=d;
	}
	
	public void adicionar() {
		
		Key id_ubicacion_pais_Key = KeyFactory.createKey("Ubicacion_provincia", id_Ubicacion_provincia);
		Date date = new Date();
        Entity Ubicacion_provincia = new Entity("Ubicacion_provincia", id_ubicacion_pais_Key);
        Ubicacion_provincia.setProperty("id_Ubicacion_provincia", id_Ubicacion_provincia);
        Ubicacion_provincia.setProperty("descripcion", descripcion);
        Ubicacion_provincia.setProperty("codigo", codigo);
        Ubicacion_provincia.setProperty("id_ubicacion_departamento", id_ubicacion_departamento);
        Ubicacion_provincia.setProperty("habilitado",true);
        Ubicacion_provincia.setProperty("date", date);
        datastore.put(Ubicacion_provincia);
        
	}
	
	public void listarC(){
		
		Query query = new Query("Ubicacion_provincia").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> Ubicacion_provincia = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
	    if (Ubicacion_provincia.isEmpty()) {
	    	System.out.println("  no Ubicacion_provincia");
	    } 
	    else {
	    	System.out.println("there Ubicacion_provincias and are ....");
	        for (int i=0;i<Ubicacion_provincia.size();i++) {
	        	System.out.println("--->"+Ubicacion_provincia.set(i, U_pro).getProperties());
	        }
	    }    
	}
	
	public List<Entity> listarL(){

		Query query = new Query("Ubicacion_provincia").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Ubicacion_provincia = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults()); 
		return Ubicacion_provincia;	    
	}
	
	public Vector<Entity> listarV(){

		Query query = new Query("Ubicacion_provincia").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Ubicacion_provincia = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		Vector<Entity>v = new Vector<Entity>();
		if (Ubicacion_provincia.isEmpty()) {
		    System.out.println("  no Ubicacion_provincia");
		} 
		else {
		   for (Entity greeting : Ubicacion_provincia) {
		        v.add(greeting);
		    }
		 }   
		 return v;	    
	}
	
	public Entity buscar(String id_Ubicacion_provincia){
		Entity e=null;
		Query query = new Query("Ubicacion_provincia").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Ubicacion_provincia = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		if (Ubicacion_provincia.isEmpty()) {
		    System.out.println("  no Ubicacion_provincia");
		} 
		else {
		   for (Entity greeting : Ubicacion_provincia) {
		        if(greeting.getProperty("id_Ubicacion_provincia").equals(id_Ubicacion_provincia))
		        	e=greeting;
		    }
		 }   
		return e;
	}

	public void delete(String i){
		 
	    Query query = new Query("Ubicacion_provincia");
	    query.addFilter("id_Ubicacion_provincia", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Ubicacion_provincia = pq.asSingleEntity();
	    datastore.delete(Ubicacion_provincia.getKey());
	}
	
	public void update(String i){
		
		Query query = new Query("Ubicacion_provincia");
	    query.addFilter("id_Ubicacion_provincia", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Ubicacion_provincia = pq.asSingleEntity();
	    datastore.delete(Ubicacion_provincia.getKey());  
	}
}
