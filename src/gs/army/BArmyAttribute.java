package gs.army;

public class BArmyAttribute implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private int level;

	private int armyid;

	private String name;

	private int exp;

	public int getLevel(){
		return this.level;
	}

	public void setLevel(int level){
		this.level=level;
	}

	public int getArmyid(){
		return this.armyid;
	}

	public void setArmyid(int armyid){
		this.armyid=armyid;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name=name;
	}

	public int getExp(){
		return this.exp;
	}

	public void setExp(int exp){
		this.exp=exp;
	}

}