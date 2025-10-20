package org.practicoJPA.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.practicoJPA.IRepositories.IEstudianteRepository;
import org.practicoJPA.dto.EstudianteDTO;
import org.practicoJPA.entities.Estudiante;

public class EstudianteRepository implements IEstudianteRepository {

	private EntityManager em;
	
	
	public EstudianteRepository(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void insertEstudiante(Estudiante e) {
		this.getEntityManager().persist(e);
		
	}

	@Override
	public List<EstudianteDTO> getEstudiantes() {
		List<EstudianteDTO> l = this.getEntityManager().createQuery("SELECT new org.practicoJPA.dto.EstudianteDTO(" +
		        "e.DNI,CONCAT(e.nombre, ' ', e.apellido), e.edad, e.genero, e.ciudad, e.lu) " +
		        "FROM Estudiante e ORDER BY e.apellido", EstudianteDTO.class).getResultList();		
		return l;
	}

	@Override
	public EstudianteDTO getEstudianteByLU(Long LU) {
		EstudianteDTO l = new EstudianteDTO();
		try {
		TypedQuery<EstudianteDTO> q = this.getEntityManager().createQuery("SELECT new org.practicoJPA.dto.EstudianteDTO(" +
		        "e.DNI,CONCAT(e.nombre, ' ', e.apellido), e.edad, e.genero, e.ciudad, e.lu) " +
		        "FROM Estudiante e WHERE e.lu = :LU", EstudianteDTO.class);		
		q.setParameter("LU", LU);
		l = q.getSingleResult();		
		}
		catch(NoResultException e) {
			return l;
		}
		return l;
	}

	@Override
	public List<EstudianteDTO> getEstudiantesByGender(String genero) {
		TypedQuery<EstudianteDTO> l = this.getEntityManager().createQuery("SELECT new org.practicoJPA.dto.EstudianteDTO(" +
		        "e.DNI,CONCAT(e.nombre, ' ', e.apellido), e.edad, e.genero, e.ciudad, e.lu) " +
		        "FROM Estudiante e WHERE e.genero = :genero", EstudianteDTO.class).setParameter("genero", genero);
		return l.getResultList();
	}

	@Override
	public List<EstudianteDTO> getEstudiantesByCarreraAndCiudad(String carrera, String ciudad) {
	    TypedQuery<EstudianteDTO> query = this.getEntityManager().createQuery(
	        "SELECT new org.practicoJPA.dto.EstudianteDTO(" +
	        "e.DNI, CONCAT(e.nombre, ' ', e.apellido), e.edad, e.genero, e.ciudad, e.lu) " +
	        "FROM Estudiante e " +
	        "JOIN e.carreras ec " +
	        "JOIN ec.carrera c " +
	        "WHERE LOWER(c.nombrecarrera) = LOWER(:carrera) " +
	        "AND LOWER(e.ciudad) = LOWER(:ciudad)",
	        EstudianteDTO.class
	    );
	    query.setParameter("carrera", carrera);
	    query.setParameter("ciudad", ciudad);
	    return query.getResultList();
	}
	
	public List<EstudianteDTO> test(String carrera) {
		TypedQuery<EstudianteDTO> l = this.getEntityManager().createQuery("SELECT new org.practicoJPA.dto.EstudianteDTO(" +
		        "e.DNI,CONCAT(e.nombre, ' ', e.apellido), e.edad, e.genero, e.ciudad, e.lu) " +
		        "FROM Estudiante e  JOIN e.carreras ec  JOIN ec.carrera c WHERE c.nombrecarrera = :carrera", EstudianteDTO.class);
		l.setParameter("carrera", carrera);
		return l.getResultList();
	}

	private EntityManager getEntityManager() {
		return this.em;
	}
}
