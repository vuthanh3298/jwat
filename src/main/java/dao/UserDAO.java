package dao;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import entity.Users;
import implement.UserImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDAO implements UserImp{
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean checkLogin(String email, String password) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String sql = "from users where email= :email and password= :password";
			Query query = session.createQuery(sql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			Users user = (Users) query.getSingleResult();
			if(user != null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public boolean insertUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		Integer id = (Integer) session.save(user);
		if(id != null) return true;
		return false;
	}
	
}
