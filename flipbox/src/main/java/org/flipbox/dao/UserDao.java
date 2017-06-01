package org.flipbox.dao;

import java.util.List;


import org.flipbox.models.UserFlipbox;

public interface UserDao {
	List<UserFlipbox> getAllUser();
	UserFlipbox saveOrUpdate(UserFlipbox user);
	UserFlipbox login(String username, String password);
	List<UserFlipbox> getAllUserByIdMahasiswa(int id);
	UserFlipbox findUserById(int id);
	
}
