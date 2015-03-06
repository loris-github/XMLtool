package gs.hero;

public class BHeroPosition implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private float posX;
	private float posY;
	private float posZ;
	private int heroid;

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

	public int getHeroid() {
		return this.heroid;
	}

	public void setHeroid(int heroid) {
		this.heroid = heroid;
	}

	public BHeroPosition () {
	}

	public BHeroPosition (float posX,float posY,float posZ,int heroid) {
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.heroid = heroid;
	}

	public BHeroPosition clone() {
		return new BHeroPosition(posX,posY,posZ,heroid);
	}

	public void reset() {
		posX = 0;
		posY = 0;
		posZ = 0;
		heroid = 0;
	}

}