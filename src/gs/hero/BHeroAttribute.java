package gs.hero;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

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

	public BHeroAttribute () {
		this.name = "";
		this.equips = new HashMap();
		this.poses = new ArrayList();
	}

	public BHeroAttribute (int level,String name,int heroid,Map<Integer,Integer> equips,int exp,List<BHeroPosition> poses) {
		this.level = level;
		this.name = (name != null ? name : "");
		this.heroid = heroid;
		this.equips = new HashMap(); if(null != equips) this.equips.putAll(equips);
		this.exp = exp;
		this.poses = new ArrayList(); if(null != poses) this.poses.addAll(poses);
	}

	public BHeroAttribute clone() {
		return new BHeroAttribute(level,name,heroid,equips,exp,poses);
	}

	public void reset() {
		level = 0;
		name = "";
		heroid = 0;
		this.equips.clear();
		exp = 0;
		this.poses.clear();
	}

}