package sectionGenerator;

import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.TypeSortStrategy;
import sectionGenerator.generatorInterface.Util;

public class GConstructorWithArgs extends Section {
	
	public GConstructorWithArgs(){
		this.typeSortStrategy = TypeSortStrategy.TSS_ConstructorWithArgs;
	}
	
	//方法声明部分
	@Override
	protected final StringBuilder genDeclarePart(){
		
		StringBuilder declarePart = new StringBuilder();
		Util.joint(declarePart, TAB,PUBLIC,SPACE,beanName,SPACE,LRB);
		
		String strComma = nothing.toString();
		
		for(String memberName:memberNames){
			
			String memberType = members.get(memberName);
			
			Util.joint(declarePart, strComma, memberType, SPACE, memberName);
			
			strComma = COMMA;
		}
		
		Util.joint(declarePart,RRB);
		
		return declarePart;
	}
	
	//方法上半部分
	@Override
	protected final StringBuilder genUpperPart(){
		
		StringBuilder upperPart = new StringBuilder();
		Util.joint(upperPart,LB,ENTER);
		
		return upperPart;
	}
	
	//方法中间部分
	@Override
	protected final void genByMembers(StringBuilder midPart, int strategyID, String memberName,String memberType){
			
		//语句生中间部分

		switch(strategyID){
		
		// basicTypes
		// this.memberName = memberName;
		case 0 :
			Util.joint(midPart,TAB,TAB,
					THIS,DOT,memberName,SPACE,EQUAL,SPACE,memberName,SEMI,ENTER);
			
			break;
			
		// String
		// this.memberName = (memberName != null ? memberName : "");
		case 1 :
			Util.joint(midPart,TAB,TAB,
					THIS,DOT,memberName,SPACE,EQUAL,SPACE,LRB,memberName,SPACE,EXCLA,EQUAL,
					SPACE,NULL,SPACE,QUSET,SPACE,memberName,SPACE,COLON,SPACE,QUOTE,QUOTE,RRB,SEMI,ENTER);
			break;
		
		// Map, HashMap
		// this.memberName = new HashMap(); if(null != memberName) this.memberName.putAll(memberName);
		case 2 :
			Util.joint(midPart,TAB,TAB,
					THIS,DOT,memberName,SPACE,EQUAL,SPACE,NEW,SPACE,HASHMAP,LRB,RRB,SEMI,
					SPACE,IF,LRB,NULL,SPACE,EXCLA,EQUAL,SPACE,memberName,RRB,SPACE,THIS,DOT,memberName,DOT,PUTALL,
					LRB,memberName,RRB,SEMI,ENTER);
			break;
			
		// List, ArrayList
		// this.memberName = new ArrayList(); if(null != memberName) this.memberName.addAll(memberName);
		case 3 :
			Util.joint(midPart,TAB,TAB,
					THIS,DOT,memberName,SPACE,EQUAL,SPACE,NEW,SPACE,ARRAYLIST,LRB,RRB,SEMI,
					SPACE,IF,LRB,NULL,SPACE,EXCLA,EQUAL,SPACE,memberName,RRB,SPACE,THIS,DOT,memberName,DOT,ADDALL,
					LRB,memberName,RRB,SEMI,ENTER);
			break;
			
		// Set, HashSet
		// this.memberName = new HashSet(); if(null != memberName) this.memberName.addAll(memberName);
		case 4 :
			Util.joint(midPart,TAB,TAB,
					THIS,DOT,memberName,SPACE,EQUAL,SPACE,NEW,SPACE,HASHSET,LRB,RRB,SEMI,
					SPACE,IF,LRB,NULL,SPACE,EXCLA,EQUAL,SPACE,memberName,RRB,SPACE,THIS,DOT,memberName,DOT,ADDALL,
					LRB,memberName,RRB,SEMI,ENTER);
			break;
		
		// OtherTypes
		// this.memberName = (null != memberName ? memberType.clone() : new memberType());
		case -1 :			
			Util.joint(midPart,TAB,TAB,
					THIS,DOT,memberName,SPACE,EQUAL,SPACE,LRB,
					NULL,SPACE,EXCLA,EQUAL,SPACE,memberName,SPACE,QUSET,SPACE,memberType,DOT,"clone",LRB,RRB,
					SPACE,COLON,SPACE,NEW,SPACE,memberType,LRB,RRB,RRB,SEMI,ENTER);
			break;
		}	
	}
	
	//方法下半部分
	@Override
	protected final StringBuilder genLowerPart(){
		
		StringBuilder lowerPart = new StringBuilder();
		Util.joint(lowerPart,TAB,RB,ENTER);
		
		return lowerPart;
	}
}
