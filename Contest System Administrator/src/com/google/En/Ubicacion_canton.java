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

public class Ubicacion_canton {
	
	String id_Ubicacion_canton,descripcion,codigo,id_Ubicacion_seccion;
	boolean habilitado;
	Entity U_ca=null;
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public Ubicacion_canton(){
		id_Ubicacion_canton="";
		descripcion="";
		codigo="";
		id_Ubicacion_seccion="";
		habilitado=true;
	}

	public String getId_Ubicacion_canton() {
		return id_Ubicacion_canton;
	}

	public void setId_Ubicacion_canton(String id_Ubicacion_canton) {
		this.id_Ubicacion_canton = id_Ubicacion_canton;
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

	public String getId_Ubicacion_seccion() {
		return id_Ubicacion_seccion;
	}

	public void setId_Ubicacion_seccion(String id_Ubicacion_seccion) {
		this.id_Ubicacion_seccion = id_Ubicacion_seccion;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public Ubicacion_canton(String a , String b, String c,String d){
		id_Ubicacion_canton=a;
		descripcion=b;
		codigo=c;
		id_Ubicacion_seccion=d;
	}
	
	public void adicionar() {
		
		Key id_Ubicacion_seccion_Key = KeyFactory.createKey("Ubicacion_canton", id_Ubicacion_canton);
		Date date = new Date();
        Entity Ubicacion_canton = new Entity("Ubicacion_canton", id_Ubicacion_seccion_Key);
        Ubicacion_canton.setProperty("id_Ubicacion_canton", id_Ubicacion_canton);
        Ubicacion_canton.setProperty("descripcion", descripcion);
        Ubicacion_canton.setProperty("codigo", codigo);
        Ubicacion_canton.setProperty("id_Ubicacion_provincia", id_Ubicacion_seccion);
        Ubicacion_canton.setProperty("habilitado",true);
        Ubicacion_canton.setProperty("date", date);
        datastore.put(Ubicacion_canton);
        
	}
	
	public void listarC(){
		
		Query query = new Query("Ubicacion_canton").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> Ubicacion_canton = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
	    if (Ubicacion_canton.isEmpty()) {
	    	System.out.println("  no Ubicacion_canton");
	    } 
	    else {
	    	System.out.println("there Ubicacion_cantones and are ....");
	        for (int i=0;i<Ubicacion_canton.size();i++) {
	        	System.out.println("--->"+Ubicacion_canton.set(i, U_ca).getProperties());
	        }
	    }    
	}
	
	public List<Entity> listarL(){

		Query query = new Query("Ubicacion_canton").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Ubicacion_canton = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults()); 
		return Ubicacion_canton;	    
	}
	
	public Vector<Entity> listarV(){

		Query query = new Query("Ubicacion_canton").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Ubicacion_canton = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		Vector<Entity>v = new Vector<Entity>();
		if (Ubicacion_canton.isEmpty()) {
		    System.out.println("  no Ubicacion_canton");
		} 
		else {
		   for (Entity greeting : Ubicacion_canton) {
		        v.add(greeting);
		    }
		 }   
		 return v;	    
	}
	
	public Entity buscar(String id_Ubicacion_canton){
		Entity e=null;
		Query query = new Query("Ubicacion_canton").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Ubicacion_canton = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		if (Ubicacion_canton.isEmpty()) {
		    System.out.println("  no Ubicacion_canton");
		} 
		else {
		   for (Entity greeting : Ubicacion_canton) {
		        if(greeting.getProperty("id_Ubicacion_canton").equals(id_Ubicacion_canton))
		        	e=greeting;
		    }
		 }   
		return e;
	}
	
	public void delete(String i){
		 
	    Query query = new Query("Ubicacion_canton");
	    query.addFilter("id_Ubicacion_canton", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Ubicacion_canton = pq.asSingleEntity();
	    datastore.delete(Ubicacion_canton.getKey());
	}
	
	public void update(String i){
		
		Query query = new Query("Ubicacion_canton");
	    query.addFilter("id_Ubicacion_canton", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Ubicacion_canton = pq.asSingleEntity();
	    datastore.delete(Ubicacion_canton.getKey());  
	}
	
}
