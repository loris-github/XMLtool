package sectionGenerator;

import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.Util;

public class GClone extends Section {
	
	//方法声明部分
	@Override
	protected final StringBuilder genDeclarePart(){
		
		StringBuilder declarePart = new StringBuilder();
		Util.joint(declarePart, TAB,_public,SPACE,beanName,SPACE,_clone,LRB,RRB);
		
		return declarePart;
	}
	
	//方法上半部分
	@Override
	protected final StringBuilder genUpperPart(){
		
		StringBuilder upperPart = new  StringBuilder();
		Util.joint(upperPart,LB,ENTER,ENTER,TAB,TAB,_return,SPACE,_new,SPACE,beanName,LRB);
		
		
		return upperPart;
	}	
	
	//方法中间部分
	@Override
	protected final StringBuilder genMidPart(){
		
		StringBuilder midPart = new StringBuilder();
		String strComma = nothing.toString();
		
		for(String memberName: memberNames){
			
			Util.joint(midPart, strComma, memberName);
			
			strComma = COMMA;

		}
		
		return midPart;
	}
		
	//方法下半部分
	@Override
	protected final StringBuilder genLowerPart(){
		StringBuilder lowerPart =  new StringBuilder();
		Util.joint(lowerPart, RRB,SEMI,ENTER,TAB,RB,ENTER,ENTER);
		
		return lowerPart;
	}
}
