package implement;

import entity.Users;

public interface UserImp {
	boolean checkLogin(String email, String password);
	boolean insertUser(Users user);
}
