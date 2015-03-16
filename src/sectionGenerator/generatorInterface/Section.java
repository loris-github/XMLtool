package sectionGenerator.generatorInterface;

import java.util.Map;
import java.util.Set;

import tool.XMLBean;

public class Section extends Sentence {

	protected String beanName;
	protected Map<String,String> members;
	protected Set<String> memberNames;
	protected String[][] typeSortStrategy;
	protected StringBuilder content;
	
	@Override
	public void appendContent(StringBuilder content, XMLBean xb) {
		
		this.beanName = xb.getBeanName();
		this.members = xb.getMembers();
		this.memberNames = members.keySet();
		this.content = content;
		
		Util.joint (this.content,
			genDeclarePart(),
			genUpperPart(),
			genMidPart(),
			genLowerPart());
	}
	
	//方法声明部分 + 左大括号
	protected StringBuilder genDeclarePart(){
		
		return nothing;
	}
	
	//方法内容的上半部分
	protected StringBuilder genUpperPart(){
		
		return nothing;
	}
	
	//方法中间部分
	protected StringBuilder genMidPart(){
		
		StringBuilder midPart = new StringBuilder(nothing);
		
		if(null == typeSortStrategy){
			
			for(String memberName: memberNames){
				
				String memberType = members.get(memberName);

				genByMembers(midPart, memberName, memberType);
			
			}
			
		} else {
			
			for(String memberName: memberNames){
				
				String memberType = members.get(memberName);
							
				String strType = Util.getStrBeforeLeftAngleBracket(memberType);
				
				int strategyID = Util.getStrategyID (strType,typeSortStrategy);

				genByMembers(midPart, strategyID, memberName, memberType);

			}
		}

		return midPart;
	}	
	
	//方法下半部分
	protected StringBuilder genLowerPart(){
		
		return nothing;
	}
	
	//根据bean属性生成文本
	protected void genByMembers(StringBuilder midPart, int strategyID, String memberName,String memberType){
		return;
	}
	
	//根据bean属性生成文本
	protected void genByMembers(StringBuilder midPart, String memberName,String memberType){
		return;
	}

}