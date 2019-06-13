package com.qa.repository;

import com.qa.model.Trick;
  
public interface TrickRepository { 

	public Trick createTrick(Trick trick);

	public Trick findTrick(int id);

	public void updateTrick(int id, Trick trick);

	public void deleteTrick(int id);

}
