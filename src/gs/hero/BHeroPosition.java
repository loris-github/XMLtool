package gs.hero;

public class BHeroPosition implements Comparable<BHeroPosition>, java.io.Serializable {

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

	public int hashCode() {
		int h = (int)serialVersionUID;
		h = h * 31 + 1 + (int)this.posX;
		h = h * 31 + 1 + (int)this.posY;
		h = h * 31 + 1 + (int)this.posZ;
		h = h * 31 + 1 + this.heroid;
		return h;
	}

	public void assign(BHeroPosition a) {
		if(a == this) return;
		if(a == null) {reset(); return;}
		this.posX = a.posX;
		this.posY = a.posY;
		this.posZ = a.posZ;
		this.heroid = a.heroid;
	}

	public boolean equals(Object o)
{
		if(o == this) return true;
		if(!(o instanceof BHeroPosition)) return false;
		BHeroPosition e = (BHeroPosition)o;
		if(this.posX != e.posX) return false;
		if(this.posY != e.posY) return false;
		if(this.posZ != e.posZ) return false;
		if(this.heroid != e.heroid) return false;
		return true;
	}

	public int compareTo(BHeroPosition c) {
		if(c == this) return 0;
		if(c == null) return 1;
		int i;
		i = Float.compare(this.posX, c.posX);; if(i!= 0) return i;
		i = Float.compare(this.posY, c.posY);; if(i!= 0) return i;
		i = Float.compare(this.posZ, c.posZ);; if(i!= 0) return i;
		i = this.heroid - c.heroid; if(i!= 0) return i;
		return 0;
	}
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append(this.posX).append(",");
		s.append(this.posY).append(",");
		s.append(this.posZ).append(",");
		s.append(this.heroid).append(",");
		return s.append("}").toString();
	}
}