package com.vaccinemanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vaccinemanagement.entity.Citizen;

@Repository
public class VaccineDAOImpl implements VaccineDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Citizen> getCitizens() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Citizen> theQuery = currentSession.createQuery("from Citizen", Citizen.class);
		List<Citizen> citizens = theQuery.getResultList();	
		return citizens;
	}

	@Override
	public void saveCitizen(Citizen theCitizen) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCitizen);
	}

	@Override
	public Citizen getCitizen(long refId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Citizen theCitizen = currentSession.get(Citizen.class, refId);
		return theCitizen;
	}

	@Override
	public void deleteCitizen(long refId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Citizen theCitizen = currentSession.get(Citizen.class, refId);
		currentSession.delete(theCitizen);
	}

}
