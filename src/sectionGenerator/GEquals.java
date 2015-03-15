package sectionGenerator;

import sectionGenerator.generatorInterface.GenMidPartStrategy;
import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.Util;

public class GEquals extends Section {
	//生成方法声明部分 + 左大括号
	protected StringBuilder genDeclarePart(){
		
		StringBuilder declarePart = new StringBuilder();
		Util.joint(declarePart, TAB,PUBLIC,SPACE,"boolean",SPACE,"equals","Object",SPACE,"o",RRB,LB,ENTER);
		
		return declarePart;
	}
	
	//生成方法内容的上半部分
	protected StringBuilder genUpperPart(){
		
		StringBuilder upperPart = new StringBuilder();
		Util.joint(upperPart, TAB,TAB,IF,LRB,"o",SPACE,EQUAL,EQUAL,SPACE,THIS,RRB,
				SPACE,RETURN,SPACE,"true",SEMI,ENTER,
				TAB,TAB,
				IF,LRB,EXCLA,LRB,"o",SPACE,"instanceof",SPACE,beanName,RRB,RRB,
				SPACE,RETURN,SPACE,"false",SEMI,ENTER,
				TAB,TAB,
				beanName,SPACE,"e",SPACE,EQUAL,SPACE,LRB,beanName,RRB,"o",SEMI,ENTER);
		
		return upperPart;
	}
	
	//生成方法内容的中间部分
	@Override
	protected StringBuilder genMidPart(){
		
		StringBuilder midPart = new StringBuilder();
		
		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
						
			String strType = Util.getStrBeforeLeftAngleBracket(memberType);
			
			int strategyID = GenMidPartStrategy.getStrategyID (strType, GenMidPartStrategy.GEQUALS);

			genByType(midPart, strategyID, memberName, memberType);

		}
		
		return midPart;
	}
	
	private void genByType(StringBuilder midPart, int strategyID, String memberName,String memberType){
			
		//根据判断结果生中间部分

		switch(strategyID){

		case 0 :	
			Util.joint(midPart,TAB,TAB,
					IF,LRB,THIS,DOT,memberName,SPACE,EXCLA,EQUAL,SPACE,"e",DOT,memberName,RRB,SPACE,
					RETURN,SPACE,"false",SEMI,ENTER);
			break;
			
		case -1 :			
			Util.joint(midPart,TAB,TAB,
					IF,LRB,EXCLA,THIS,DOT,memberName,DOT,"equals",LRB,"e",DOT,memberName,RRB,RRB,SPACE,
					RETURN,SPACE,"fasle",SEMI,ENTER);
			break;
		}
	
	}

}
