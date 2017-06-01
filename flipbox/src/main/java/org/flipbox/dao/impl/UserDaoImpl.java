package org.flipbox.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.flipbox.dao.UserDao;
import org.flipbox.models.UserFlipbox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserDaoImpl implements UserDao {

	private EntityManagerFactory entityManagerFactory;

	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public List<UserFlipbox> getAllUser() {
		EntityManager em = entityManagerFactory.createEntityManager();
		return em.createQuery("from UserFlipbox", UserFlipbox.class).getResultList();
		
	}

	@Override
	public UserFlipbox saveOrUpdate(UserFlipbox user) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		UserFlipbox saved = em.merge(user);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public UserFlipbox login(String username, String password) {
		List<UserFlipbox> allUser = getAllUser();
		UserFlipbox userFind = null;		
		for (UserFlipbox user : allUser) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				userFind = user;
				break;
			}
		}
		return userFind;
	}

	@Override
	public List<UserFlipbox> getAllUserByIdMahasiswa(int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		return em.createQuery("from User where id="+id, UserFlipbox.class).getResultList();
	}

	@Override
	public UserFlipbox findUserById(int id) {

		EntityManager em = entityManagerFactory.createEntityManager();		
		return em.find(UserFlipbox.class, id);
	}
}
