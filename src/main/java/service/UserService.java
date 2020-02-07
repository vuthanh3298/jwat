package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDAO;
import entity.Users;
import implement.UserImp;

@Service
public class UserService implements UserImp {
	@Autowired
	UserDAO userDao;
	
	public boolean checkLogin(String email, String password) {
		return userDao.checkLogin(email, password);
	}
	
	public boolean insertUser(Users user) {
		return userDao.insertUser(user);
	}
	
}
