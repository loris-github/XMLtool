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

	public int hashCode() {
		int h = (int)serialVersionUID;
		h = h * 31 + 1 + this.level;
		h = h * 31 + 1 + this.name.hashCode();
		h = h * 31 + 1 + this.heroid;
		h = h * 31 + 1 + this.equips.hashCode();
		h = h * 31 + 1 + this.exp;
		h = h * 31 + 1 + this.poses.hashCode();
		return h;
	}

	public void assign(BHeroAttribute a) {
		if(a == this) return;
		if(a == null) {reset(); return;}
		this.level = a.level;
		this.name = (a.name != null ? a.name : "");
		this.heroid = a.heroid;
		this.equips.clear(); if(a.equips != null) this.equips.putAll(a.equips);
		this.exp = a.exp;
		this.poses.clear(); if(a.poses != null) this.poses.addAll(a.poses);
	}

	public boolean equals(Object o)
{
		if(o == this) return true;
		if(!(o instanceof BHeroAttribute)) return false;
		BHeroAttribute e = (BHeroAttribute)o;
		if(this.level != e.level) return false;
		if(!this.name.equals(e.name)) return false;
		if(this.heroid != e.heroid) return false;
		if(!this.equips.equals(e.equips)) return false;
		if(this.exp != e.exp) return false;
		if(!this.poses.equals(e.poses)) return false;
		return true;
	}

	public int compare(BHeroAttribute c) {
		if(c == this) return 0;
		if(c == null) return 1;
		int i;
		i = this.level - c.level; if(i!= 0) return i;
		i = this.name.compareTo(c.name); if(i!= 0) return i;
		i = this.heroid - c.heroid; if(i!= 0) return i;
		i = contentGenerator.ContentKit.compareTo(this.equips,c.equips); if(i!= 0) return i;
		i = this.exp - c.exp; if(i!= 0) return i;
		i = contentGenerator.ContentKit.compareTo(this.poses,c.poses); if(i!= 0) return i;
		return 0;
	}
}