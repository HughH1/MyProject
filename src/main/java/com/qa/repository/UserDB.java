package com.qa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.model.User;
  
@Transactional(value = TxType.SUPPORTS) 
public class UserDB implements UserRepository {

	@PersistenceContext(unitName = "myPU")
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	public User createUser(User user) {
		em.persist(user);
		return user;
	}
	
	public User findUser(int id) {
		User user = em.find(User.class, id);
		return user;
	}

	@Transactional(value = TxType.REQUIRED)
	public void deleteUser(int id) {
		em.remove(findUser(id));
	}

	

}