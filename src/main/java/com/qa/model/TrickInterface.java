package com.qa.model;

public interface TrickInterface {

	int getId();

	void setId(int tId);

	String getTrick();

	void setTrick(String trick);

	String getDesc();

	void setDesc(String desc);

	int getProgress();

	void setProgress(int progress);

	int getDifficulty();

	void setDifficulty(int difficulty);

}