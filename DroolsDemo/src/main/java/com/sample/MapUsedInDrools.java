package com.sample;

import java.util.List;
import java.util.Map;

public class MapUsedInDrools {
	private Map<String, List<String>> empWithSkillSet;
	public Map<String, List<String>> getEmpWithSkillSet() {
		return empWithSkillSet;
	}
	public void setEmpWithSkillSet(Map<String, List<String>> empWithSkillSet) {
		this.empWithSkillSet = empWithSkillSet;
	}
	public MapUsedInDrools(Map<String, List<String>> empWithSkillSet) {
		this.empWithSkillSet = empWithSkillSet;
	}

}
