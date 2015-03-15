package sectionGenerator;

import sectionGenerator.generatorInterface.GenMidPartStrategy;
import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.Util;

public class GToString extends Section {
	//生成方法声明部分 + 左大括号
	protected StringBuilder genDeclarePart(){
		
		StringBuilder declarePart = new StringBuilder();
		
		Util.joint(declarePart, TAB,TAB,PUBLIC,SPACE,
				"String",SPACE,"toString",LRB,RRB,SPACE,LB,ENTER);

		return declarePart;
	}
	
	//生成方法内容的上半部分
	protected StringBuilder genUpperPart(){
		
		StringBuilder upperPart = new StringBuilder();
		
		Util.joint(upperPart, TAB,TAB,"StringBuffer",SPACE,"s",SPACE,EQUAL,SPACE,"new",
				SPACE,"StringBuffer",LRB,RRB,SEMI,ENTER);
		
		return upperPart;
	}
	
	//生成方法内容的中间部分
	@Override
	protected StringBuilder genMidPart(){
		
		StringBuilder midPart = new StringBuilder();
		
		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
						
			String strType = Util.getStrBeforeLeftAngleBracket(memberType);
			
			int strategyID = GenMidPartStrategy.getStrategyID (strType, GenMidPartStrategy.GTOSTRING);

			genByType(midPart, strategyID, memberName, memberType);

		}
		
		return midPart;
	}
	
	private void genByType(StringBuilder midPart, int strategyID, String memberName,String memberType){

		//生成语句前半部分	
		Util.joint(midPart,TAB,TAB);		
		
		//根据判断结果生中间部分

		switch(strategyID){

		case 0 :
			Util.joint(midPart,"Util",DOT,"append",LRB,"s",COMMA,SPACE,THIS,DOT,memberName,
					RRB);
			break;
			
		case -1 :			
			Util.joint(midPart,"s",DOT,"append",LRB,THIS,DOT,memberName,RRB,DOT,"append",
					LRB,QUOTE,COMMA,QUOTE,RRB);
			break;
		}
	
		//生成语句后半部分
			Util.joint(midPart,SEMI,ENTER);
		
	}
	
	//生成方法内容的下半部分
	protected StringBuilder genLowerPart(){
		
		StringBuilder lowerPart = new StringBuilder();
		
		Util.joint(lowerPart, TAB,TAB,"RETURN",SPACE,"s",DOT,"append",LRB,QUOTE,RB,QUOTE,RRB,
				DOT,"toString",LRB,RRB,SEMI,ENTER,TAB,RB,ENTER);

		return lowerPart;
	}
}
