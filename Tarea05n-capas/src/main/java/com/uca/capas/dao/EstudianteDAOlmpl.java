package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Estudiante;

@Repository
public class EstudianteDAOlmpl implements EstudianteDao{
	

	@PersistenceContext(unitName="estudiante")
	private EntityManager entityManager;

	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.estudiante");
		Query query = entityManager.createNativeQuery(sb.toString(),Estudiante.class);
		List <Estudiante> resulset = query.getResultList();
		
		return resulset;
	}

	@Transactional
	public void insert(Estudiante estudiante) throws DataAccessException {
		entityManager.merge(estudiante);
	}
}
