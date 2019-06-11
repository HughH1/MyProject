package com.qa.repository;

import com.qa.model.Trick;
  
public interface TrickRepository { 

	public Trick createTrick(Trick trick);

	public Trick findTrick(int id);

	public Trick updateTrickName(int id, Trick name);

	public Trick updateDesc(int id, Trick desc);

	public Trick updateProgress(int id, Trick progress);

	public Trick updateDifficulty(int id, Trick rating);

	public void deleteTrick(int id);

}
