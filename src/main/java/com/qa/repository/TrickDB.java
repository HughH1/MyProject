package com.qa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.model.Trick;
import com.qa.model.TrickInterface;

@Transactional(value = TxType.SUPPORTS)
public class TrickDB implements TrickRepository {

	@PersistenceContext(unitName = "myPU")
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	public TrickInterface createTrick(TrickInterface trick) {
		em.persist(trick);
		return trick;
	}

	public TrickInterface findTrick(int id) {
		TrickInterface trick = em.find(Trick.class, id);
		return trick;
	}

	public List<Trick> findTrickName(String trickName) {
		TypedQuery<Trick> query = em.createQuery("Select tri from Trick tri where trick='" + trickName + "'", Trick.class);
		List<Trick> list = query.getResultList();
		return list;
	}

	@Transactional(value = TxType.REQUIRED)
	public TrickInterface updateTrick(int id, TrickInterface newTrick) {
		TrickInterface trick = em.find(Trick.class, id);
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
