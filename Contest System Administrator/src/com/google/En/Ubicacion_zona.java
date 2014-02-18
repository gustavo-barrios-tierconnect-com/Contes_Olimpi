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

public class Ubicacion_zona {

	String id_Ubicacion_zona,descripcion,codigo,id_ubicacion_departamento;
	boolean habilitado;
	Entity U_zo=null;
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public Ubicacion_zona(){
		id_Ubicacion_zona="";
		descripcion="";
		codigo="";
		id_ubicacion_departamento="";
		habilitado=true;
	}

	public String getId_Ubicacion_zona() {
		return id_Ubicacion_zona;
	}

	public void setId_Ubicacion_zona(String id_Ubicacion_zona) {
		this.id_Ubicacion_zona = id_Ubicacion_zona;
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
	
	public Ubicacion_zona(String a , String b, String c,String d){
		id_Ubicacion_zona=a;
		descripcion=b;
		codigo=c;
		id_ubicacion_departamento=d;
	}
	
	public void adicionar() {
		
		Key id_Ubicacion_zona_Key = KeyFactory.createKey("Ubicacion_zona", id_Ubicacion_zona);
		Date date = new Date();
        Entity Ubicacion_zona = new Entity("Ubicacion_zona", id_Ubicacion_zona_Key);
        Ubicacion_zona.setProperty("id_Ubicacion_zona", id_Ubicacion_zona);
        Ubicacion_zona.setProperty("descripcion", descripcion);
        Ubicacion_zona.setProperty("codigo", codigo);
        Ubicacion_zona.setProperty("id_Ubicacion_canton", id_ubicacion_departamento);
        Ubicacion_zona.setProperty("habilitado",true);
        Ubicacion_zona.setProperty("date", date);
        datastore.put(Ubicacion_zona);
        
	}
	
	public void listarC(){
		
		Query query = new Query("Ubicacion_zona").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> Ubicacion_zona = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
	    if (Ubicacion_zona.isEmpty()) {
	    	System.out.println("  no Ubicacion_zona");
	    } 
	    else {
	    	System.out.println("there Ubicacion_zonas and are ....");
	        for (int i=0;i<Ubicacion_zona.size();i++) {
	        	System.out.println("--->"+Ubicacion_zona.set(i, U_zo).getProperties());
	        }
	    }    
	}
	
	public List<Entity> listarL(){

		Query query = new Query("Ubicacion_zona").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Ubicacion_zona = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults()); 
		return Ubicacion_zona;	    
	}
	
	public Vector<Entity> listarV(){

		Query query = new Query("Ubicacion_zona").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Ubicacion_zona = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		Vector<Entity>v = new Vector<Entity>();
		if (Ubicacion_zona.isEmpty()) {
		    System.out.println("  no Ubicacion_zona");
		} 
		else {
		   for (Entity greeting : Ubicacion_zona) {
		        v.add(greeting);
		    }
		 }   
		 return v;	    
	}
	
	public Entity buscar(String id_Ubicacion_zona){
		Entity e=null;
		Query query = new Query("Ubicacion_zona").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Ubicacion_zona = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		if (Ubicacion_zona.isEmpty()) {
		    System.out.println("  no Ubicacion_zona");
		} 
		else {
		   for (Entity greeting : Ubicacion_zona) {
		        if(greeting.getProperty("id_Ubicacion_zona").equals(id_Ubicacion_zona))
		        	e=greeting;
		    }
		 }   
		return e;
	}
	
	public void delete(String i){
		 
	    Query query = new Query("Ubicacion_zona");
	    query.addFilter("id_Ubicacion_zona", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Ubicacion_zona = pq.asSingleEntity();
	    datastore.delete(Ubicacion_zona.getKey());
	}
	
	public void update(String i){
		
		Query query = new Query("Ubicacion_zona");
	    query.addFilter("id_Ubicacion_zona", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Ubicacion_zona = pq.asSingleEntity();
	    datastore.delete(Ubicacion_zona.getKey());  
	}
	
}

