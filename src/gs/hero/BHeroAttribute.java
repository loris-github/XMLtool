package gs.hero;

public class BHeroAttribute implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private int level;

	private String name;

	private int heroid;

	private int exp;

	public int getLevel(){
		return this.level;
	}

	public void setLevel(int level){
		this.level=level;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name=name;
	}

	public int getHeroid(){
		return this.heroid;
	}

	public void setHeroid(int heroid){
		this.heroid=heroid;
	}

	public int getExp(){
		return this.exp;
	}

	public void setExp(int exp){
		this.exp=exp;
	}

}