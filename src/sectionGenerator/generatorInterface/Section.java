package sectionGenerator.generatorInterface;

import java.util.Map;
import java.util.Set;

import tool.XMLBean;

public abstract class Section extends Segment {
	
	protected String beanName;
	protected Map<String,String> members;
	protected Set<String> memberNames;
	protected StringBuilder content;

	protected Section(XMLBean xb){		
		this.beanName = xb.getBeanName();
		this.members = xb.getMembers();
		this.memberNames = members.keySet();
		this.content = new StringBuilder();		
	}
	
	protected abstract void appendToContent(StringBuilder content);
}