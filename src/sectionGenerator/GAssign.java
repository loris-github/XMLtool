package sectionGenerator;

import sectionGenerator.generatorInterface.GenMidPartStrategy;
import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.Util;

public class GAssign extends Section {
	//生成方法声明部分 + 左大括号
	protected StringBuilder genDeclarePart(){
		
		StringBuilder declarePart= new StringBuilder();
		
		Util.joint(declarePart, TAB,PUBLIC,SPACE,"void",SPACE,"assign",LRB,beanName,SPACE,"a",RRB,
				SPACE,LB,ENTER);
		
		return declarePart;
	}
	
	//生成方法内容的上半部分
	protected StringBuilder genUpperPart(){
		
		StringBuilder upperPart= new StringBuilder();
		
		Util.joint(upperPart, TAB,TAB,IF,LRB,"a",SPACE,EQUAL,EQUAL,SPACE,THIS,RRB,SPACE,RETURN,SEMI,ENTER,
				TAB,TAB,IF,LRB,"a",SPACE,EQUAL,EQUAL,SPACE,NULL,SPACE,LB,"reset",LRB,RRB,SEMI,SPACE,RETURN,
				SEMI,RB,ENTER);
		
		return upperPart;
	}
	
	//生成方法内容的中间部分
	@Override
	protected StringBuilder genMidPart(){
		
		StringBuilder midPart = new StringBuilder();
		
		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
						
			String strType = Util.getStrBeforeLeftAngleBracket(memberType);
			
			int strategyID = GenMidPartStrategy.getStrategyID (strType, GenMidPartStrategy.GASSIGN);

			genByType(midPart, strategyID, memberName, memberType);

		}
		
		return midPart;
	}
	
	private void genByType(StringBuilder midPart, int strategyID, String memberName,String memberType){
		
		//语句前半部分
		Util.joint(midPart,TAB,TAB,THIS,DOT,memberName);
		
		//根据判断结果生中间部分
		
		switch(strategyID){

		case 0 :			
			Util.joint(midPart,SPACE,EQUAL,SPACE,"a",DOT,memberName);
			
			break;
			
		case 1 :			
			Util.joint(midPart,SPACE,EQUAL,SPACE,LRB,"a",DOT,memberName,SPACE
					,EXCLA,EQUAL,SPACE,NULL,SPACE,QUSET,SPACE,"a",DOT,memberName,
					SPACE,COLON,SPACE,QUOTE,QUOTE);
			
			break;
		
		case 2 :					
			Util.joint(midPart,DOT,"clear",LRB,RRB,SEMI,SPACE,IF,LRB,"a",DOT,memberName,SPACE,
					EXCLA,EQUAL,SPACE,NULL,RRB,SPACE,THIS,DOT,memberName,DOT,"methodName","a",DOT,
					memberName,RRB);
			
			break;	
			
		case 3 :			
			Util.joint(midPart,DOT,"clear",LRB,RRB,SEMI,SPACE,IF,LRB,"a",DOT,memberName,SPACE,
					EXCLA,EQUAL,SPACE,NULL,RRB,SPACE,THIS,DOT,memberName,DOT,"methodName","a",DOT,
					memberName,RRB);

			break;
			
		case -1 :		
			Util.joint(midPart,DOT,"assign",LRB,"a",DOT,memberName,RRB);
			
			break;			
		}
		
		//语句前半部分
		Util.joint(midPart,SEMI,ENTER);

	}	
	
	//生成方法内容的下半部分
	protected StringBuilder genLowerPart(){
		StringBuilder lowerPart = new StringBuilder();
		
		Util.joint(lowerPart,
				TAB,TAB,RB,ENTER);
		
		return lowerPart;
	}
}
