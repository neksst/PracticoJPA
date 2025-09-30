package org.practicoJPA.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carrera {

	@Id
	@Column(name="ID")
	private Long id;
	@Column(nullable = false)
	private String Carrera;

	public Carrera() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Carrera(Long id, String carrera) {
		super();
		this.id = id;
		this.Carrera = carrera;
	}



	public String getCarrera() {
		return Carrera;
	}

	public void setCarrera(String carrera) {
		Carrera = carrera;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Carrera [id=" + id + ", Carrera=" + Carrera + "]";
	}

}
