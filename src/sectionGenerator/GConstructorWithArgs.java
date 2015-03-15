package sectionGenerator;

import sectionGenerator.generatorInterface.GenMidPartStrategy;
import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.Util;

public class GConstructorWithArgs extends Section {
	//生成方法声明部分 + 左大括号
	protected StringBuilder genDeclarePart(){
		
		StringBuilder declarePart = new StringBuilder();
		Util.joint(declarePart, TAB,PUBLIC,SPACE,beanName,SPACE,LRB);
		
		String strComma = nothing.toString();
		
		for(String memberName:memberNames){
			
			String memberType = members.get(memberNames);
			Util.joint(declarePart, strComma,memberType,SPACE,memberName);
			
			strComma = COMMA;
		}
		
		Util.joint(declarePart,RRB,LB,ENTER);
		
		return declarePart;
	}
	
	//生成方法内容的上半部分
	protected StringBuilder genUpperPart(){
		return nothing;
	}
	
	//生成方法内容的中间部分
	@Override
	protected StringBuilder genMidPart(){
		
		StringBuilder midPart = new StringBuilder();
		
		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
						
			String strType = Util.getStrBeforeLeftAngleBracket(memberType);
			
			int strategyID = GenMidPartStrategy.getStrategyID (strType, GenMidPartStrategy.GCONSTRUCTORWITHARGS);

			genByType(midPart, strategyID, memberName, memberType);

		}
		
		return midPart;
	}
	
	private void genByType(StringBuilder midPart, int strategyID, String memberName,String memberType){
			
		//根据判断结果生中间部分

		switch(strategyID){

		case 0 :
			Util.joint(midPart,TAB,TAB,
					THIS,DOT,memberName,SPACE,EQUAL,SPACE,memberName,SEMI,ENTER);
			
			break;
			
		case 1 :
			Util.joint(midPart,TAB,TAB,
					THIS,DOT,memberName,SPACE,EQUAL,SPACE,LRB,memberName,SPACE,EXCLA,EQUAL,
					SPACE,NULL,SPACE,QUSET,SPACE,memberName,SPACE,COLON,SPACE,QUOTE,QUOTE,SEMI,ENTER);
			break;
		
		case 2 :			//map
			Util.joint(midPart,TAB,TAB,
					THIS,DOT,memberName,SPACE,EQUAL,SPACE,"new",SPACE,HASHMAP,LRB,RRB,SEMI,
					SPACE,IF,LRB,NULL,SPACE,EXCLA,EQUAL,SPACE,memberName,RRB,SPACE,THIS,DOT,memberName,DOT,PUTALL,
					LRB,memberName,RRB,SEMI,ENTER);
			break;	
			
		case 3 :			//list
			Util.joint(midPart,TAB,TAB,
					THIS,DOT,memberName,SPACE,EQUAL,SPACE,"new",SPACE,ARRAYLIST,LRB,RRB,SEMI,
					SPACE,IF,LRB,NULL,SPACE,EXCLA,EQUAL,SPACE,memberName,RRB,SPACE,THIS,DOT,memberName,DOT,ADDALL,
					LRB,memberName,RRB,SEMI,ENTER);
			break;
			
		case 4 :			//set
			Util.joint(midPart,TAB,TAB,
					THIS,DOT,memberName,SPACE,EQUAL,SPACE,"new",SPACE,HASHSET,LRB,RRB,SEMI,
					SPACE,IF,LRB,NULL,SPACE,EXCLA,EQUAL,SPACE,memberName,RRB,SPACE,THIS,DOT,memberName,DOT,ADDALL,
					LRB,memberName,RRB,SEMI,ENTER);
			break;
			
		case -1 :			
			Util.joint(midPart,TAB,TAB,
					THIS,DOT,memberName,SPACE,EQUAL,SPACE,LRB,
					memberName,SPACE,EXCLA,EQUAL,SPACE,NULL,SPACE,QUSET,SPACE,memberType,DOT,"clone",LRB,RRB,
					SPACE,COLON,SPACE,"new",SPACE,memberType,LRB,RRB,RRB,SEMI,ENTER);
			break;
		}
	
	}
	
	//生成方法内容的下半部分
	protected StringBuilder genLowerPart(){
		StringBuilder lowerPart = new StringBuilder();
		Util.joint(lowerPart, TAB,RB,ENTER,ENTER);
		
		return lowerPart;
	}
}
