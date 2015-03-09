package gs.army;

public class BArmyAttribute implements Comparable<BArmyAttribute>, java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private int level;
	private int armyid;
	private String name;
	private int exp;

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getArmyid() {
		return this.armyid;
	}

	public void setArmyid(int armyid) {
		this.armyid = armyid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExp() {
		return this.exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public BArmyAttribute () {
		this.name = "";
	}

	public BArmyAttribute (int level,int armyid,String name,int exp) {
		this.level = level;
		this.armyid = armyid;
		this.name = (name != null ? name : "");
		this.exp = exp;
	}

	public BArmyAttribute clone() {
		return new BArmyAttribute(level,armyid,name,exp);
	}

	public void reset() {
		level = 0;
		armyid = 0;
		name = "";
		exp = 0;
	}

	public int hashCode() {
		int h = (int)serialVersionUID;
		h = h * 31 + 1 + this.level;
		h = h * 31 + 1 + this.armyid;
		h = h * 31 + 1 + this.name.hashCode();
		h = h * 31 + 1 + this.exp;
		return h;
	}

	public void assign(BArmyAttribute a) {
		if(a == this) return;
		if(a == null) {reset(); return;}
		this.level = a.level;
		this.armyid = a.armyid;
		this.name = (a.name != null ? a.name : "");
		this.exp = a.exp;
	}

	public boolean equals(Object o)
{
		if(o == this) return true;
		if(!(o instanceof BArmyAttribute)) return false;
		BArmyAttribute e = (BArmyAttribute)o;
		if(this.level != e.level) return false;
		if(this.armyid != e.armyid) return false;
		if(!this.name.equals(e.name)) return false;
		if(this.exp != e.exp) return false;
		return true;
	}

	public int compareTo(BArmyAttribute c) {
		if(c == this) return 0;
		if(c == null) return 1;
		int i;
		i = this.level - c.level; if(i!= 0) return i;
		i = this.armyid - c.armyid; if(i!= 0) return i;
		i = this.name.compareTo(c.name); if(i!= 0) return i;
		i = this.exp - c.exp; if(i!= 0) return i;
		return 0;
	}
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append(this.level).append(",");
		s.append(this.armyid).append(",");
		s.append(this.name).append(",");
		s.append(this.exp).append(",");
		return s.append("}").toString();
	}
}