package org.practicoJPA.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estudiante {
	@Id
	@Column(name="DNI")
	private Long DNI;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String apellido;
	@Column(nullable=false)
	private int Edad;
	@Column(nullable=false)
	private String genero;
	@Column(nullable=false)
	private String Ciudad;
	@Column(nullable=false)
	private Long LU;
	
	public Estudiante() {
		
	}
	
	

	public Estudiante(Long dNI, String nombre, String apellido, int edad, String genero, String ciudad, Long lU) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.Edad = edad;
		this.genero = genero;
		this.Ciudad = ciudad;
		this.LU = lU;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public Long getLU() {
		return LU;
	}

	public void setLU(Long lU) {
		LU = lU;
	}

	public Long getDNI() {
		return DNI;
	}

	@Override
	public String toString() {
		return "Estudiante [DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido + ", Edad=" + Edad
				+ ", genero=" + genero + ", Ciudad=" + Ciudad + ", LU=" + LU + "]";
	}

}
