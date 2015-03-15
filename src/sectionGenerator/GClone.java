package sectionGenerator;

import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.Util;

public class GClone extends Section {
	//生成方法声明部分 + 左大括号
	protected StringBuilder genDeclarePart(){
		
		StringBuilder declarePart = new StringBuilder();
		Util.joint(declarePart, TAB,PUBLIC,SPACE,beanName,SPACE,"clone",LRB,RRB,LB,ENTER);
		
		return declarePart;
	}
	
	//生成方法内容的上半部分
	protected StringBuilder genUpperPart(){
		
		StringBuilder upperPart = new  StringBuilder();
		Util.joint(upperPart,TAB,TAB,RETURN,SPACE,"new",SPACE,beanName,LRB);
		
		
		return upperPart;
	}
	
	//生成方法内容的中间部分
	@Override
	protected StringBuilder genMidPart(){
		
		StringBuilder midPart = new StringBuilder();
		String strComma = nothing.toString();
		
		for(String memberName: memberNames){
			
			Util.joint(midPart, strComma, memberName);
			
			strComma = COMMA;

		}
		
		return midPart;
	}
	
	//生成方法内容的下半部分
	protected StringBuilder genLowerPart(){
		StringBuilder lowerPart =  new StringBuilder();
		Util.joint(lowerPart, RRB,SEMI,ENTER,TAB,RB,ENTER,ENTER);
		
		return lowerPart;
	}
}
