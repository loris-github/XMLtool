package tool;

import java.util.HashMap;
import java.util.Map;

public class XMLBean {
	
	private String beanName;
	private Map<String,String> members = new HashMap<String,String>();
	
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
	
}
