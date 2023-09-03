package com.emedicare.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emedicare.entity.EMedicines;

@Repository
public class EmedicineDaoImpl implements EmedicineDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<EMedicines> getEMedicines() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<EMedicines> Query = currentSession.createQuery("from EMedicines", EMedicines.class);
		List<EMedicines> allMedicines = Query.getResultList();
		return allMedicines;
	}

	@Override
	public void deletebyId(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		EMedicines m = currentSession.get(EMedicines.class, id);
		currentSession.delete(m);		
	}

	@Override
	public void saveMedicine(EMedicines medicine) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(medicine);
	}
	
	@Override
	public EMedicines getMedicine(int medicineId) {
		Session currentSession = sessionFactory.getCurrentSession();
		EMedicines m = currentSession.get(EMedicines.class, medicineId);
		return m;
	}
	
	
}
