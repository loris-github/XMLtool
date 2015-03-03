package gs.army;



public class BArmyPosition implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private float posX;
	private float posY;
	private float posZ;
	private int armyid;


	public float getPosX() {
		return this.posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return this.posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public float getPosZ() {
		return this.posZ;
	}

	public void setPosZ(float posZ) {
		this.posZ = posZ;
	}

	public int getArmyid() {
		return this.armyid;
	}

	public void setArmyid(int armyid) {
		this.armyid = armyid;
	}



}