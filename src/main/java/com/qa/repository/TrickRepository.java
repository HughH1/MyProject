package com.qa.repository;

import java.util.List;

import com.qa.model.Trick;
  
public interface TrickRepository { 

	public Trick createTrick(Trick trick);

	public Trick findTrick(int id);

	public List<Trick> findTrickName(String trick);
	
	public Trick updateTrick(int id, Trick trick);

	public void deleteTrick(int id);

}
