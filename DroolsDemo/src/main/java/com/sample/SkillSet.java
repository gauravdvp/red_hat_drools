package com.sample;

public class SkillSet {
	private String primarySkill;
	private String secondarySkill;

	public String getPrimarySkill() {
		return primarySkill;
	}

	public SkillSet(String primarySkill, String secondarySkill) {
		this.primarySkill = primarySkill;
		this.secondarySkill = secondarySkill;
		// TODO Auto-generated constructor stub
	}

	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}

	public String getSecondarySkill() {
		return secondarySkill;
	}

	public void setSecondarySkill(String secondarySkill) {
		this.secondarySkill = secondarySkill;
	}

	@Override
	public String toString() {
		return "SkillSet [primarySkill=" + primarySkill + ", secondarySkill=" + secondarySkill + "]";
	}

}
