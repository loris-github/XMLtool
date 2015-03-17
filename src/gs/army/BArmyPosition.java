package gs.army;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class BArmyPosition implements Comparable<BArmyPosition>,Cloneable,java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private float posX;
	private float posY;
	private float posZ;
	private int armyid;

	public float getPosX(){
		return this.posX;
	}

	public void setPosX(float posX){
		this.posX = posX;
	}

	public float getPosY(){
		return this.posY;
	}

	public void setPosY(float posY){
		this.posY = posY;
	}

	public float getPosZ(){
		return this.posZ;
	}

	public void setPosZ(float posZ){
		this.posZ = posZ;
	}

	public int getArmyid(){
		return this.armyid;
	}

	public void setArmyid(int armyid){
		this.armyid = armyid;
	}

	public BArmyPosition (){

	}

	public BArmyPosition (float posX,float posY,float posZ,int armyid){

		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.armyid = armyid;
	}

	public BArmyPosition clone(){

		return new BArmyPosition(posX,posY,posZ,armyid);
	}

	public void reset(){

		posX = 0;
		posY = 0;
		posZ = 0;
		armyid = 0;
	}

	public int hashCode(){

		int h = (int)serialVersionUID;

		h = h * 31 + 1 + (int)this.posX;
		h = h * 31 + 1 + (int)this.posY;
		h = h * 31 + 1 + (int)this.posZ;
		h = h * 31 + 1 + (int)this.armyid;
		return h;
	}

	public void assign(BArmyPosition a){

		if(a == this) return;
		if(a == null) {reset(); return;}

		this.posX = a.posX;
		this.posY = a.posY;
		this.posZ = a.posZ;
		this.armyid = a.armyid;
	}

	public boolean equals(Object o){

		if(o == this) return true;
		if(!(o instanceof BArmyPosition)) return false;
		BArmyPosition e = (BArmyPosition)o;

		if(this.posX != e.posX) return false;
		if(this.posY != e.posY) return false;
		if(this.posZ != e.posZ) return false;
		if(this.armyid != e.armyid) return false;

		return true;
	}

	public int compareTo(BArmyPosition c){

		if(c == this) return 0;
		if(c == null) return 1;
		int i;

		i = Float.compare(this.posX, c.posX); if(i!= 0) return i;
		i = Float.compare(this.posY, c.posY); if(i!= 0) return i;
		i = Float.compare(this.posZ, c.posZ); if(i!= 0) return i;
		i = this.armyid - c.armyid; if(i!= 0) return i;

		return 0;
	}

	public String toString(){

		StringBuilder s = new StringBuilder();

		s.append(this.posX).append(",");
		s.append(this.posY).append(",");
		s.append(this.posZ).append(",");
		s.append(this.armyid).append(",");

		return s.append("}").toString();
	}

}