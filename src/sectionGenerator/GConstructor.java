package sectionGenerator;

import sectionGenerator.generatorInterface.GenMidPartStrategy;
import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.Util;

public final class GConstructor extends Section {
	
	//生成方法标题部分 + 左大括号
	@Override
	protected StringBuilder genDeclarePart(){
		
		StringBuilder declarePart = new StringBuilder();
		
		Util.joint (declarePart,
			TAB,PUBLIC,SPACE,beanName,SPACE,LRB,RRB,LB,
			ENTER);
		
		return declarePart;
	}
	
	//生成方法内容的中间部分
	@Override
	protected StringBuilder genMidPart(){
		
		StringBuilder midPart = new StringBuilder();
		
		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
						
			String strType = Util.getStrBeforeLeftAngleBracket(memberType);
			
			int strategyID = GenMidPartStrategy.getStrategyID (strType, GenMidPartStrategy.GCONSTRUCTOR);

			genByType(midPart, strategyID, memberName, memberType);

		}
		
		return midPart;
	}
	
	private void genByType(StringBuilder midPart, int strategyID, String memberName,String memberType){
			
		//根据判断结果生中间部分

		switch(strategyID){

		case 0 :			
			return;
			
		case 1 :
			Util.joint (midPart,TAB,TAB,
					THIS,DOT,memberName,SPACE,EQUAL,SPACE,QUOTE,QUOTE,SEMI,
					ENTER);
			break;
		
		case 2 :			
			Util.joint (midPart,TAB,TAB,
					THIS,DOT,memberName,SPACE,EQUAL,SPACE,NEW,SPACE,HASHMAP,LRB,RRB,SEMI,
					ENTER);
			break;	
			
		case 3 :			
			Util.joint (midPart,TAB,TAB,
					THIS,DOT,memberName,SPACE,EQUAL,SPACE,NEW,SPACE,ARRAYLIST,LRB,RRB,SEMI,
					ENTER);
			break;
			
		case 4 :			
			Util.joint (midPart,TAB,TAB,
					THIS,DOT,memberName,SPACE,EQUAL,SPACE,NEW,SPACE,HASHSET,LRB,RRB,SEMI,
					ENTER);
			break;
			
		case -1 :			
			Util.joint (midPart,TAB,TAB,
					THIS,DOT,memberName,SPACE,EQUAL,SPACE,NEW,SPACE,memberType,LRB,RRB,SEMI,
					ENTER);
			break;
		}
	
	}

}
