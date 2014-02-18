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

public class Evaluacion {

	String id_Evaluacion,descripcion,gestion,periodo,fecha_inicio,fecha_final;
	boolean habilitado;
	Entity ev=null;
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public Evaluacion(){
		id_Evaluacion="";
		descripcion="";
		gestion="";
		periodo="";
		fecha_inicio="";
		fecha_final="";
		habilitado=true;
	}

	public String getId_Evaluacion() {
		return id_Evaluacion;
	}

	public void setId_Evaluacion(String id_Evaluacion) {
		this.id_Evaluacion = id_Evaluacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getGestion() {
		return gestion;
	}

	public void setGestion(String gestion) {
		this.gestion = gestion;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_final() {
		return fecha_final;
	}

	public void setFecha_final(String fecha_final) {
		this.fecha_final = fecha_final;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public Evaluacion(String a , String b, String c,String d,String e,String f){
		id_Evaluacion=a;
		descripcion=b;
		gestion=c;
		periodo=d;
		fecha_inicio=e;
		fecha_final=f;
	}
	
	public void adicionar() {
		
		Key id_Evaluacion_Key = KeyFactory.createKey("Evaluacion", id_Evaluacion);
		Date date = new Date();
        Entity Evaluacion = new Entity("Evaluacion", id_Evaluacion_Key);
        Evaluacion.setProperty("id_Evaluacion", id_Evaluacion);
        Evaluacion.setProperty("descripcion", descripcion);
        Evaluacion.setProperty("gestion", gestion);
        Evaluacion.setProperty("periodo", periodo);
        Evaluacion.setProperty("fecha_inicio", fecha_inicio);
        Evaluacion.setProperty("fecha_final", fecha_final);
        Evaluacion.setProperty("habilitado",true);
        Evaluacion.setProperty("date", date);
        datastore.put(Evaluacion);
        
	}
	
	public void listarC(){
		
		Query query = new Query("Evaluacion").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> Evaluacion = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
	    if (Evaluacion.isEmpty()) {
	    	System.out.println("  no Evaluacion");
	    } 
	    else {
	    	System.out.println("there Evaluaciones and are ....");
	        for (int i=0;i<Evaluacion.size();i++) {
	        	System.out.println("--->"+Evaluacion.set(i,ev).getProperties());
	        }
	    }    
	}
	
	public List<Entity> listarL(){

		Query query = new Query("Evaluacion").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Evaluacion = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults()); 
		return Evaluacion;	    
	}

	public Vector<Entity> listarV(){

		Query query = new Query("Evaluacion").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Evaluacion = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		Vector<Entity>v = new Vector<Entity>();
		if (Evaluacion.isEmpty()) {
		    System.out.println("  no Ubicacion_calle");
		} 
		else {
		   for (Entity greeting : Evaluacion) {
		        v.add(greeting);
		    }
		 }   
		 return v;	    
	}	
	
	public Entity buscar(String id_Evaluacion){
		Entity e=null;
		Query query = new Query("Evaluacion").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Evaluacion = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		if (Evaluacion.isEmpty()) {
		    System.out.println("  no Evaluacion");
		} 
		else {
		   for (Entity greeting : Evaluacion) {
		        if(greeting.getProperty("id_Evaluacion").equals(id_Evaluacion))
		        	e=greeting;
		    }
		 }   
		return e;
	}
	
	public void delete(String i){
		 
	    Query query = new Query("Evaluacion");
	    query.addFilter("id_Evaluacion", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Evaluacion = pq.asSingleEntity();
	    datastore.delete(Evaluacion.getKey());
	}
	
	public void update(String i){
		
		Query query = new Query("Evaluacion");
	    query.addFilter("id_Evaluacion", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Evaluacion = pq.asSingleEntity();
	    datastore.delete(Evaluacion.getKey());  
	}

}
