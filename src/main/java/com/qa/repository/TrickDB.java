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
	public Trick updateTrickName(int id, Trick name) {
		Trick trickName = em.find(Trick.class, id);
		trickName.setTrick(name.getTrick());
		return trickName;
	}

	@Transactional(value = TxType.REQUIRED)
	public Trick updateDesc(int id, Trick desc) {
		Trick trickDesc = em.find(Trick.class, id);
		trickDesc.setDesc(desc.getDesc());
		return trickDesc;
	}

	@Transactional(value = TxType.REQUIRED)
	public Trick updateProgress(int id, Trick rating) {
		Trick trickProgress = em.find(Trick.class, id);
		trickProgress.setProgress(rating.getProgress());
		return trickProgress;
	}

	@Transactional(value = TxType.REQUIRED)
	public Trick updateDifficulty(int id, Trick rating) {
		Trick trickDifficulty = em.find(Trick.class, id);
		trickDifficulty.setDifficulty(rating.getDifficulty());
		return trickDifficulty;
	}

	@Transactional(value = TxType.REQUIRED)
	public void deleteTrick(int id) {
		em.remove(findTrick(id));
	}

}
