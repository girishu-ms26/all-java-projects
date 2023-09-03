package com.emedicare.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emedicare.entity.ECart;
import com.emedicare.entity.EMedicines;

@Repository
public class EuserDaoImpl implements EuserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private EmedicineDao emedicineDao;

	@Override
	public boolean authUser(String username, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false","scott","tiger");
			Statement st1 = con.createStatement();
			ResultSet rs = st1.executeQuery("SELECT * FROM EUsers");			
			while(rs.next()) {
				if(rs.getString(6).equals(username)) {
					if(rs.getString(7).equals(password)) {
						return true;
					}
				}
			}
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		return false;
	}
	@Override
	public List<ECart> getCartItems(){
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ECart> Query = currentSession.createQuery("from ECart", ECart.class);
		List<ECart> allCartItems = Query.getResultList();
		return allCartItems;
	}
	@Override
	public void savetoCart(int medicineId) {
		Session currentSession = sessionFactory.getCurrentSession();
		EMedicines m = emedicineDao.getMedicine(medicineId);
		ECart c = new ECart();
		c.setMedicineid(m.getMedicineid());
		c.setMedicine_name(m.getMedicine_name());
		c.setPrice(m.getPrice());
		c.setDescription(m.getDescription());
		currentSession.saveOrUpdate(c);
	}
	@Override
	public void deleteFromCart(int medicineId) {
		Session currentSession = sessionFactory.getCurrentSession();
		ECart c = currentSession.get(ECart.class, medicineId);
		currentSession.delete(c);
	}

}
