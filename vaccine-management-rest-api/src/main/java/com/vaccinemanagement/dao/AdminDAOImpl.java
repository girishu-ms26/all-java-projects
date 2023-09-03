package com.vaccinemanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vaccinemanagement.entity.Adminsapi;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean login(String username, String password) {
		Session currentSession = sessionFactory.getCurrentSession();
		boolean status = false;
		Query<Adminsapi> theQuery = currentSession.createQuery("select A from Adminsapi A where username=:username");
		theQuery.setParameter("username",username);
		List<Adminsapi> list = theQuery.getResultList();
		
		if ((list != null) && (list.size() > 0)) {
			status= true;
		}
		return status;
	}

	@Override
	public boolean register(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Adminsapi> getAdmins() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Adminsapi> theQuery = currentSession.createQuery("from Admin", Adminsapi.class);
		List<Adminsapi> Admins = theQuery.getResultList();	
		return Admins;
	}

}
