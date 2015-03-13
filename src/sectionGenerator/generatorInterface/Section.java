package sectionGenerator.generatorInterface;

import java.util.Map;
import java.util.Set;
import tool.XMLBean;

public abstract class Section extends Sentence {

	protected String beanName;
	protected Map<String,String> members;
	protected Set<String> memberNames;
	protected StringBuilder content;

	@Override
	public void appendContent(StringBuilder content, XMLBean xb) {
		
		this.beanName = xb.getBeanName();
		this.members = xb.getMembers();
		this.memberNames = members.keySet();
		this.content = new StringBuilder();
		
		Util.joint (content,
			genDeclarePart(),
			genUpperPart(),
			genMidPart(),
			genLowerPart(),
			TAB,LB,ENTER);
	}
	
	//生成方法声明部分 + 左大括号
	protected StringBuilder genDeclarePart(){
		return nothing;
	}
	
	//生成方法内容的上半部分
	protected StringBuilder genUpperPart(){
		return nothing;
	}
	
	//生成方法内容的中间部分
	protected StringBuilder genMidPart(){
		return nothing;
	}	
	
	//生成方法内容的下半部分
	protected StringBuilder genLowerPart(){
		return nothing;
	}

}