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

public class ubicacion_departamento {

	String id_ubicacion_departamento,descripcion,codigo,id_ubicacion_pais;
	boolean habilitado;
	Entity U_d=null;
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public ubicacion_departamento(){
		id_ubicacion_departamento="";
		descripcion="";
		codigo="";
		id_ubicacion_pais="";
		habilitado=true;
	}

	public String getId_ubicacion_departamento() {
		return id_ubicacion_departamento;
	}

	public void setId_ubicacion_departamento(String id_ubicacion_departamento) {
		this.id_ubicacion_departamento = id_ubicacion_departamento;
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

	public String getId_ubicacion_pais() {
		return id_ubicacion_pais;
	}

	public void setId_ubicacion_pais(String id_ubicacion_pais) {
		this.id_ubicacion_pais = id_ubicacion_pais;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public ubicacion_departamento(String a , String b, String c,String d){
		id_ubicacion_departamento=a;
		descripcion=b;
		codigo=c;
		id_ubicacion_pais=d;
		habilitado=true;
	}
	
	public void adicionar() {
		
		Key id_ubicacion_pais_Key = KeyFactory.createKey("ubicacion_departamento", id_ubicacion_departamento);
		Date date = new Date();
        Entity ubicacion_departamento = new Entity("ubicacion_departamento", id_ubicacion_pais_Key);
        ubicacion_departamento.setProperty("id_ubicacion_departamento", id_ubicacion_departamento);
        ubicacion_departamento.setProperty("descripcion", descripcion);
        ubicacion_departamento.setProperty("codigo", codigo);
        ubicacion_departamento.setProperty("id_ubicacion_pais", id_ubicacion_pais);
        ubicacion_departamento.setProperty("habilitado",true);
        ubicacion_departamento.setProperty("date", date);
        datastore.put(ubicacion_departamento);
        
	}
	
	public void listarC(){
		
		Query query = new Query("ubicacion_departamento").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> ubicacion_departamento = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
	    if (ubicacion_departamento.isEmpty()) {
	    	System.out.println("  no ubicacion_departamento");
	    } 
	    else {
	    	System.out.println("there ubicacion_departamentos and are ....");
	        for (int i=0;i<ubicacion_departamento.size();i++) {
	        	System.out.println("--->"+ubicacion_departamento.set(i, U_d).getProperties());
	        }
	    }    
	}
	
	public List<Entity> listarL(){

		Query query = new Query("ubicacion_departamento").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> ubicacion_departamento = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults()); 
		return ubicacion_departamento;	    
	}
	
	public Vector<Entity> listarV(){

		Query query = new Query("ubicacion_departamento").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> ubicacion_departamento = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		Vector<Entity>v = new Vector<Entity>();
		if (ubicacion_departamento.isEmpty()) {
		    System.out.println("  no ubicacion_departamentos");
		} 
		else {
		   for (Entity greeting : ubicacion_departamento) {
		        v.add(greeting);
		    }
		 }   
		 return v;	    
	}
	
	public Entity buscar(String id_ubicacion_departamento){
		Entity e=null;
		Query query = new Query("ubicacion_departamento").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> ubicacion_departamento = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		if (ubicacion_departamento.isEmpty()) {
		    System.out.println("  no ubicacion_departamento");
		} 
		else {
		   for (Entity greeting : ubicacion_departamento) {
		        if(greeting.getProperty("id_ubicacion_departamento").equals(id_ubicacion_departamento))
		        	e=greeting;
		    }
		 }   
		return e;
	}
	
	public void delete(String i){
		 
	    Query query = new Query("ubicacion_departamento");
	    query.addFilter("id_ubicacion_departamento", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity ubicacion_departamento = pq.asSingleEntity();
	    datastore.delete(ubicacion_departamento.getKey());
	}
	
	public void update(String i){
		
		Query query = new Query("ubicacion_departamento");
	    query.addFilter("id_ubicacion_departamento", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity ubicacion_departamento = pq.asSingleEntity();
	    datastore.delete(ubicacion_departamento.getKey());  
	}
	
}
