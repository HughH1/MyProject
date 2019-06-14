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

	public Trick findTrick(int id) {
		Trick trick = em.find(Trick.class, id);
		return trick;
	}

	@Transactional(value = TxType.REQUIRED)
	public Trick updateTrick(int id, Trick newTrick) {
		Trick trick = em.find(Trick.class, id);
		trick.setTrick(newTrick.getTrick());
		trick.setDesc(newTrick.getDesc());
		trick.setProgress(newTrick.getProgress());
		trick.setDifficulty(newTrick.getDifficulty());
		return trick;
	}

	@Transactional(value = TxType.REQUIRED)
	public void deleteTrick(int id) {
		em.remove(findTrick(id));
	}

}
