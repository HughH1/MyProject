package com.qa.repository;

import java.util.List;

import com.qa.model.Trick;
import com.qa.model.TrickInterface;
  
public interface TrickRepository { 

	public TrickInterface createTrick(TrickInterface trick);

	public TrickInterface findTrick(int id);

	public List<Trick> findTrickName(String trick);
	
	public TrickInterface updateTrick(int id, TrickInterface trick);

	public void deleteTrick(int id);

}
