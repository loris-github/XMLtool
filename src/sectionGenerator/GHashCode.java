package sectionGenerator;

import sectionGenerator.generatorInterface.GenMidPartStrategy;
import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.Util;

public class GHashCode extends Section {
	//生成方法声明部分 + 左大括号
	protected StringBuilder genDeclarePart(){
		
		StringBuilder declarePart = new StringBuilder();
		Util.joint(declarePart, TAB,PUBLIC,SPACE,"int",SPACE,"hashCode",LRB,RRB,SPACE,LB,ENTER);
		
		return declarePart;
	}
	
	//生成方法内容的上半部分
	protected StringBuilder genUpperPart(){
		
		StringBuilder upperPart = new StringBuilder();
		
		Util.joint(upperPart,TAB,TAB,
				"int",SPACE,"h",SPACE,EQUAL,SPACE,LRB,"int",RRB,"serialVersionUID",SEMI,ENTER);
		
		return upperPart;
	}
	
	//生成方法内容的中间部分
	@Override
	protected StringBuilder genMidPart(){
		
		StringBuilder midPart = new StringBuilder();
		
		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
						
			String strType = Util.getStrBeforeLeftAngleBracket(memberType);
			
			int strategyID = GenMidPartStrategy.getStrategyID (strType, GenMidPartStrategy.GHASHCODE);

			genByType(midPart, strategyID, memberName, memberType);

		}
		
		return midPart;
	}
	
	private void genByType(StringBuilder midPart, int strategyID, String memberName,String memberType){
			
		//根据判断结果生中间部分

		switch(strategyID){

		case 0 :
			Util.joint(midPart, TAB,TAB,
					"h",SPACE,EQUAL,SPACE,
					"h",SPACE,ASTERISK,SPACE,"31",SPACE,"+",SPACE,"1",SPACE,
					"+",SPACE,LRB,"int",RRB,THIS,DOT,memberName,SEMI,ENTER);			
			break;
			
		case -1 :
			Util.joint(midPart, TAB,TAB,
					"h",SPACE,EQUAL,SPACE,
					"h",SPACE,ASTERISK,SPACE,"31",SPACE,"+",SPACE,"1",SPACE,
					"+",SPACE,THIS,DOT,memberName,DOT,"hashCode",LRB,RRB,SEMI,ENTER);	
			break;
		}
	
	}	
	
	//生成方法内容的下半部分
	protected StringBuilder genLowerPart(){
		StringBuilder lowerPart = new StringBuilder();
		Util.joint(lowerPart,TAB,TAB,RETURN,SPACE,"h",SEMI,ENTER,
				TAB,RB,ENTER,ENTER);
		
		return lowerPart;
	}
}
