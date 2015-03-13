package sectionGenerator;

import sectionGenerator.generatorInterface.GenMidPartStrategy;
import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.Util;

public class GCompareTo extends Section {
	//生成方法声明部分 + 左大括号
	protected StringBuilder genDeclarePart(){
		
		StringBuilder declarePart = new StringBuilder();
		
		Util.joint(declarePart,
				TAB,PUBLIC,SPACE,INT,SPACE,COMPARETO,LRB,beanName,SPACE,
				"c",RRB,SPACE,LB,ENTER);
		
		return declarePart;
	}
	
	//生成方法内容的上半部分
	protected StringBuilder genUpperPart(){
		
		StringBuilder upperPart = new StringBuilder();
		
		Util.joint(upperPart,
				TAB,TAB,
				IF,LRB,"c",SPACE,EQUAL,EQUAL,SPACE,THIS,RRB,SPACE,RETURN,SPACE,"0",SEMI,
				TAB,TAB,
				IF,LRB,"c",SPACE,EQUAL,EQUAL,SPACE,NULL,RRB,SPACE,RETURN,SPACE,"1",SEMI,
				TAB,TAB,
				INT,SPACE,"i",SEMI);
		
		return upperPart;
	}
	
	//生成方法内容的中间部分
	@Override
	protected StringBuilder genMidPart(){
		
		StringBuilder midPart = new StringBuilder();
		
		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
						
			String strType = Util.getStrBeforeLeftAngleBracket(memberType);
			
			int strategyID = GenMidPartStrategy.getStrategyID (strType, GenMidPartStrategy.COMPARETO);

			genByType(midPart, strategyID, memberName, memberType);
		}
		
		return midPart;
	}
	
	private void genByType(StringBuilder midPart, int strategyID, String memberName,String memberType){
		
		//方法前半部分		
		Util.joint(midPart,TAB,TAB,"i",SPACE,EQUAL,SPACE);
		
		//根据判断结果生中间部分
		switch(strategyID){

		case 0 :			
			Util.joint(midPart,FLOAT,DOT,COMPARE,LRB,THIS,DOT,memberName,COMMA,
					SPACE,"c",DOT,memberName,RRB,SEMI);
			break;
			
		case 1 :
			Util.joint(midPart,DOUBLE,DOT,COMPARE,LRB,THIS,DOT,memberName,COMMA,
					SPACE,"c",DOT,memberName,RRB,SEMI);
			break;
		
		case 2 :			
			Util.joint(midPart,LONG,DOT,"signum",LRB,THIS,DOT,memberName,COMMA,
					SPACE,"c",DOT,memberName,RRB,SEMI);
			break;	
			
		case 3 :
			Util.joint(midPart,THIS,DOT,memberName,SPACE,"-",SPACE,"c",DOT,memberName,SEMI);
			break;
			
		case 4 :			
			Util.joint(midPart,"Util",LRB,THIS,DOT,memberName,COMMA,
					"c",DOT,memberName,RRB,SEMI);
			break;
			
		case -1 :			
			Util.joint(midPart,THIS,DOT,memberName,DOT,COMPARETO,LRB,
					"c",DOT,memberName,RRB,SEMI);
			break;
		}
		
		//方法后半部分
		Util.joint(midPart,SPACE,IF,LRB,"i",EXCLA,EQUAL,SPACE,"0",RRB,SEMI);	
	}	
	
	//生成方法内容的下半部分
	protected StringBuilder genLowerPart(){
		StringBuilder lowerPart = new StringBuilder();
		
		Util.joint(lowerPart,
				TAB,TAB,
				RETURN,SPACE,"0",SEMI,ENTER,TAB,RB,
				ENTER);
		
		return lowerPart;
	}
}
