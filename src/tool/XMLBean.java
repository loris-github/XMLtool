package tool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class XMLBean {
	
	private String path;
	private String beanName;
	private Map<String,String> members = new HashMap<String,String>();
		
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	public Map<String,String> getMembers(){
		return this.members;
	}
	
	public void addMember(String attrName,String attrType) {
		this.members.put(attrName, attrType);
	}
    
	private String getMapString(){
		StringBuffer str = new StringBuffer();
		
		Set<String> keys=members.keySet();
		
		for(String s: keys) {			
		 str.append(s + " : "+ members.get(s)+ "\r\n");		 
		}

		return str.toString();
	}
	
	@Override
	public String toString() {
		return
				"packageName=" + this.path + "\r\n" +
				 "beanName=" + this.beanName + "\r\n" +
				   "members : " + "\r\n" +
				   getMapString() +"====================";
	}

}
