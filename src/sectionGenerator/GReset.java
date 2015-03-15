package sectionGenerator;

import sectionGenerator.generatorInterface.GenMidPartStrategy;
import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.Util;

public class GReset extends Section {
	//生成方法声明部分 + 左大括号
	protected StringBuilder genDeclarePart(){
		
		StringBuilder declarePart = new StringBuilder();
		Util.joint(declarePart, TAB,PUBLIC,SPACE,"void",SPACE,"reset",LRB,RRB,SPACE,LB,ENTER);
		
		return declarePart;
	}

	//生成方法内容的中间部分
	@Override
	protected StringBuilder genMidPart(){
		
		StringBuilder midPart = new StringBuilder();
		
		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
						
			String strType = Util.getStrBeforeLeftAngleBracket(memberType);
			
			int strategyID = GenMidPartStrategy.getStrategyID (strType, GenMidPartStrategy.GRESET);

			genByType(midPart, strategyID, memberName, memberType);

		}
		
		return midPart;
	}
	
	private void genByType(StringBuilder midPart, int strategyID, String memberName,String memberType){
			
		//根据判断结果生中间部分

		switch(strategyID){

		case 0 :
			Util.joint(midPart,TAB,TAB,memberName,SPACE,EQUAL,SPACE,"0",SEMI,ENTER);
			break;
			
		case 1 :
			Util.joint(midPart,TAB,TAB,memberName,SPACE,EQUAL,SPACE,QUOTE,QUOTE,SEMI,ENTER);
			break;
		
		case 2 :			
			Util.joint(midPart,TAB,TAB,THIS,DOT,memberName,DOT,"clear",LRB,RRB,SEMI,ENTER);
			break;	
			
		case -1 :			
			Util.joint(midPart,TAB,TAB,THIS,DOT,memberName,SPACE,EQUAL,SPACE,NULL,SEMI,ENTER);
			break;
		}
	
	}	
	
	//生成方法内容的下半部分
	protected StringBuilder genLowerPart(){
		
		StringBuilder lowerPart = new StringBuilder();
		
		Util.joint(lowerPart,TAB,RB,ENTER,ENTER);
				
		return lowerPart;
	}
}
