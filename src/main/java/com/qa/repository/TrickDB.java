package com.qa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.model.Trick;
  
@Transactional(value = TxType.SUPPORTS)
public class TrickDB implements TrickRepository {
	
	@PersistenceContext(unitName = "myPU")
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	public Trick createTrick(Trick trick) {
		em.persist(trick); 
		return trick;
	}

	@Transactional(value = TxType.REQUIRED)
	public Trick findTrick(int id) {
		Trick trick = em.find(Trick.class, id);
		return trick;
	}

	@Transactional(value = TxType.REQUIRED)
	public void updateTrick(int id, Trick trick) {
		trick = em.find(Trick.class, id);
		trick.setTrick(trick.getTrick());
		trick.setDesc(trick.getDesc());
		trick.setProgress(trick.getProgress());
		trick.setDifficulty(trick.getDifficulty());
	}
	
	
	@Transactional(value = TxType.REQUIRED)
	public void deleteTrick(int id) {
		em.remove(findTrick(id));
	}

}
