package sectionGenerator;

import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.TypeSortStrategy;
import sectionGenerator.generatorInterface.Util;

public class GAssign extends Section {
	
	public GAssign (){
		this.typeSortStrategy = TypeSortStrategy.TSS_Assign;
	} 
	
	//方法声明部分
	@Override	
	protected final StringBuilder genDeclarePart(){
		
		StringBuilder declarePart= new StringBuilder();
		
		Util.joint(declarePart, TAB,PUBLIC,SPACE,"void",SPACE,"assign",LRB,beanName,SPACE,"a",RRB);
		
		return declarePart;
	}
	
	//方法上半部分
	@Override
	protected final StringBuilder genUpperPart(){
		
		StringBuilder upperPart= new StringBuilder();
		
		Util.joint(upperPart,LB,ENTER,TAB,TAB,
				IF,LRB,"a",SPACE,EQUAL,EQUAL,SPACE,THIS,RRB,SPACE,RETURN,SEMI,ENTER,
				TAB,TAB,
				IF,LRB,"a",SPACE,EQUAL,EQUAL,SPACE,NULL,RRB,SPACE,LB,"reset",LRB,RRB,SEMI,SPACE,RETURN,SEMI,RB,ENTER);
		
		return upperPart;
	}
	
	//方法中间部分
	@Override
	protected final void genByMembers(StringBuilder midPart, int strategyID, String memberName,String memberType){
		
		//语句前半部分
		Util.joint(midPart,TAB,TAB,THIS,DOT,memberName);
		
		//语句中间部分		
		switch(strategyID){
		
		// basicType
		// this.memberName = a.memberName;
		case 0 :			
			Util.joint(midPart,SPACE,EQUAL,SPACE,"a",DOT,memberName);
			
			break;
		
		// String
		// this.memberName = (null != a.memberName ? a.memberName : "");
		case 1 :			
			Util.joint(midPart,SPACE,EQUAL,SPACE,LRB,NULL,SPACE,
					EXCLA,EQUAL,SPACE,"a",DOT,memberName,SPACE,QUSET,SPACE,"a",DOT,memberName,
					SPACE,COLON,SPACE,QUOTE,QUOTE,RRB,SEMI);
			break;
		
		// Map, HashMap
		// this.memberName.clear(); if(null != a.memberName) this.memberName.putAll(a.memberName);
		case 2 :					
			Util.joint(midPart,DOT,"clear",LRB,RRB,SEMI,SPACE,IF,LRB,NULL,SPACE,
					EXCLA,EQUAL,SPACE,"a",DOT,memberName,RRB,SPACE,THIS,DOT,memberName,DOT,"putAll",LRB,"a",DOT,
					memberName,RRB);			
			break;	
		
		// List, ArrayList, Set, HashSet
		// this.memberName.clear(); if(null != a.memberName) this.memberName.addAll(a.memberName);
		case 3 :			
			Util.joint(midPart,DOT,"clear",LRB,RRB,SEMI,SPACE,IF,LRB,NULL,SPACE,
					EXCLA,EQUAL,SPACE,"a",DOT,memberName,RRB,SPACE,THIS,DOT,memberName,DOT,"addAll",LRB,"a",DOT,
					memberName,RRB);
			break;
		
		// OtherTypes	
		// this.memberName.assign(a.memberName);	
		case -1 :		
			Util.joint(midPart,DOT,"assign",LRB,"a",DOT,memberName,RRB);			
			break;			
		}
		
		//语句后半部分
		Util.joint(midPart,SEMI,ENTER);
	}
	
	//方法下半部分
	@Override
	protected final StringBuilder genLowerPart(){
		StringBuilder lowerPart = new StringBuilder();
		
		Util.joint(lowerPart,TAB,RB,ENTER);
		
		return lowerPart;
	}
}
