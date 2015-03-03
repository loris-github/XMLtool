package gs.hero;

import java.util.List;
import java.util.Map;


public class BHeroAttribute implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private int level;
	private String name;
	private int heroid;
	private Map<Integer,Integer> equips;
	private int exp;
	private List<BHeroPosition> poses;


	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeroid() {
		return this.heroid;
	}

	public void setHeroid(int heroid) {
		this.heroid = heroid;
	}

	public Map<Integer,Integer> getEquips() {
		return this.equips;
	}

	public void setEquips(Map<Integer,Integer> equips) {
		this.equips = equips;
	}

	public int getExp() {
		return this.exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public List<BHeroPosition> getPoses() {
		return this.poses;
	}

	public void setPoses(List<BHeroPosition> poses) {
		this.poses = poses;
	}



}