package sectionGenerator.generatorInterface;

import java.util.Map;
import java.util.Set;

import tool.XMLBean;

public abstract class Section extends Sentence {
	
	protected String beanName;
	protected Map<String,String> members;
	protected Set<String> memberNames;
	
	protected Section(XMLBean xb){
		
		this.beanName = xb.getBeanName();
		this.members = xb.getMembers();
		this.memberNames = members.keySet();
		
	}
	
	// 添加内容块
	public static void getSection(StringBuilder title,StringBuilder block){
		
		title.append(TAB).append(LB).append(ENTER)
				.append(block).append(ENTER)
				.append(TAB).append(RB);
	}
	
	protected abstract void appendToContent(StringBuilder content);
}
