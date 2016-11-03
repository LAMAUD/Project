package fr.treeptik.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class StructureDeDonnees {

	private List<String> listEx;
	private Set<String> setEx;
	private Map<String, String> mapEx;
	private Properties propEx;

	public StructureDeDonnees() {
		super();
	}

	public List<String> getListEx() {
		return listEx;
	}

	public void setListEx(List<String> listEx) {
		this.listEx = listEx;
	}

	public Set<String> getSetEx() {
		return setEx;
	}

	public void setSetEx(Set<String> setEx) {
		this.setEx = setEx;
	}

	public Map<String, String> getMapEx() {
		return mapEx;
	}

	public void setMapEx(Map<String, String> mapEx) {
		this.mapEx = mapEx;
	}

	public Properties getPropEx() {
		return propEx;
	}

	public void setPropEx(Properties propEx) {
		this.propEx = propEx;
	}

	@Override
	public String toString() {
		return "StructureDeDonnees [listEx=" + listEx + ", setEx=" + setEx
				+ ", mapEx=" + mapEx + ", propEx=" + propEx + "]";
	}

}
