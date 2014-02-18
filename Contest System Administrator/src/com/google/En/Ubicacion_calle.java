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

public class Ubicacion_calle {
	
	String id_Ubicacion_calle,descripcion,codigo,id_Ubicacion_zona;
	boolean habilitado;
	Entity U_ca=null;
	
	public DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public Ubicacion_calle(){
		id_Ubicacion_calle="";
		descripcion="";
		codigo="";
		id_Ubicacion_zona="";
		habilitado=true;
	}

	public String getId_Ubicacion_calle() {
		return id_Ubicacion_calle;
	}

	public void setId_Ubicacion_calle(String id_Ubicacion_calle) {
		this.id_Ubicacion_calle = id_Ubicacion_calle;
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

	public String getId_Ubicacion_zona() {
		return id_Ubicacion_zona;
	}

	public void setId_Ubicacion_zona(String id_Ubicacion_zona) {
		this.id_Ubicacion_zona = id_Ubicacion_zona;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public Ubicacion_calle(String a , String b, String c,String d){
		id_Ubicacion_calle=a;
		descripcion=b;
		codigo=c;
		id_Ubicacion_zona=d;
	}
	
	public void adicionar() {
		
		Key id_Ubicacion_calle_Key = KeyFactory.createKey("Ubicacion_calle", id_Ubicacion_calle);
		Date date = new Date();
        Entity Ubicacion_calle = new Entity("Ubicacion_calle", id_Ubicacion_calle_Key);
        Ubicacion_calle.setProperty("id_Ubicacion_calle", id_Ubicacion_calle);
        Ubicacion_calle.setProperty("descripcion", descripcion);
        Ubicacion_calle.setProperty("codigo", codigo);
        Ubicacion_calle.setProperty("id_Ubicacion_zona", id_Ubicacion_zona);
        Ubicacion_calle.setProperty("habilitado",true);
        Ubicacion_calle.setProperty("date", date);
        datastore.put(Ubicacion_calle);
        
	}
	
	public void listarC(){
		
		Query query = new Query("Ubicacion_calle").addSort("date", Query.SortDirection.DESCENDING);
	    List<Entity> Ubicacion_calle = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
	    if (Ubicacion_calle.isEmpty()) {
	    	System.out.println("  no Ubicacion_calle");
	    } 
	    else {
	    	System.out.println("there Ubicacion_calles and are ....");
	        for (int i=0;i<Ubicacion_calle.size();i++) {
	        	System.out.println("--->"+Ubicacion_calle.set(i, U_ca).getProperties());
	        }
	    }    
	}
	
	public List<Entity> listarL(){

		Query query = new Query("Ubicacion_calle").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Ubicacion_calle = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults()); 
		return Ubicacion_calle;	    
	}
	
	public Vector<Entity> listarV(){

		Query query = new Query("Ubicacion_calle").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Ubicacion_calle = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		Vector<Entity>v = new Vector<Entity>();
		if (Ubicacion_calle.isEmpty()) {
		    System.out.println("  no Ubicacion_calle");
		} 
		else {
		   for (Entity greeting : Ubicacion_calle) {
		        v.add(greeting);
		    }
		 }   
		 return v;	    
	}
	
	public Entity buscar(String id_Ubicacion_calle){
		Entity e=null;
		Query query = new Query("Ubicacion_calle").addSort("date", Query.SortDirection.DESCENDING);
		List<Entity> Ubicacion_calle = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		if (Ubicacion_calle.isEmpty()) {
		    System.out.println("  no Ubicacion_calle");
		} 
		else {
		   for (Entity greeting : Ubicacion_calle) {
		        if(greeting.getProperty("id_Ubicacion_calle").equals(id_Ubicacion_calle))
		        	e=greeting;
		    }
		 }   
		return e;
	}
	
	public void delete(String i){
		 
	    Query query = new Query("Ubicacion_calle");
	    query.addFilter("id_Ubicacion_calle", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Ubicacion_calle = pq.asSingleEntity();
	    datastore.delete(Ubicacion_calle.getKey());
	}
	
	public void update(String i){
		
		Query query = new Query("Ubicacion_calle");
	    query.addFilter("id_Ubicacion_calle", FilterOperator.EQUAL, i);
	    PreparedQuery pq = datastore.prepare(query);
	    Entity Ubicacion_calle = pq.asSingleEntity();
	    datastore.delete(Ubicacion_calle.getKey());  
	}
	
}
