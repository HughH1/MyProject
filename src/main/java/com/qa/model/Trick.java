package com.qa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Trick implements TrickInterface {
 
	@Id
	@GeneratedValue
	private int tId;
	@Column(unique = true)
	private String trick;
	private String Desc;
	private int progress;
	private int difficulty;

	@Override
	public int getId() {
		return tId;
	}

	@Override
	public void setId(int tId) {
		this.tId = tId;
	} 


	@Override
	public String getTrick() {
		return trick;
	}


	@Override
	public void setTrick(String trick) {
		this.trick = trick;
	}


	@Override
	public String getDesc() {
		return Desc;
	}


	@Override
	public void setDesc(String desc) {
		Desc = desc;
	}


	@Override
	public int getProgress() {
		return progress;
	}

	@Override
	public void setProgress(int progress) {
		this.progress = progress;
	}


	@Override
	public int getDifficulty() {
		return difficulty;
	}

	@Override
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

}
