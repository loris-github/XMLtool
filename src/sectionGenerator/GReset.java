package sectionGenerator;

import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.TypeSortStrategy;
import sectionGenerator.generatorInterface.Util;

public class GReset extends Section {
	
	public GReset(){
		this.typeSortStrategy = TypeSortStrategy.TSS_Reset;
	}
	
	//方法声明部分
	@Override
	protected final StringBuilder genDeclarePart(){
		
		StringBuilder declarePart = new StringBuilder();
		Util.joint(declarePart, TAB,_public,SPACE,_void,SPACE,_reset,LRB,RRB);
		
		return declarePart;
	}
	
	//方法上半部分
	@Override
	protected final StringBuilder genUpperPart(){
		
		StringBuilder upperPart = new StringBuilder();
		
		Util.joint(upperPart,LB,ENTER,ENTER);
		
		return upperPart;
	}

	//方法中间部分
	@Override
	protected final void genByMembers(StringBuilder midPart, int strategyID, String memberName,String memberType){
			
		//语句中间部分
		switch(strategyID){
		
		// byte, short, int, long, float, double, char
		// memberName = "0";
		case 0 :
			Util.joint(midPart,TAB,TAB,memberName,SPACE,EQUAL,SPACE,_0,SEMI,ENTER);			
			break;
		
		// boolean
		// memberName = false;	
		case 1 :
			Util.joint(midPart,TAB,TAB,memberName,SPACE,EQUAL,SPACE,_false,SEMI,ENTER);
			break;	
			
		// String
		// memberName = "";	
		case 2 :
			Util.joint(midPart,TAB,TAB,memberName,SPACE,EQUAL,SPACE,QUOTE,QUOTE,SEMI,ENTER);
			break;
		
		// 	Map, List, Set, HashMap, ArrayList, HashSet
		// this.memberName.clear();	
		case 3 :			
			Util.joint(midPart,TAB,TAB,_this,DOT,memberName,DOT,_clear,LRB,RRB,SEMI,ENTER);
			break;	
		
		// OtherTypes
		// this.memberName = null;	
		case -1 :			
			Util.joint(midPart,TAB,TAB,_this,DOT,memberName,SPACE,EQUAL,SPACE,_null,SEMI,ENTER);
			break;
		}	
	}
	
	//方法下半部分
	@Override
	protected final StringBuilder genLowerPart(){
		StringBuilder lowerPart = new StringBuilder();
		
		Util.joint(lowerPart,TAB,RB,ENTER,ENTER);
		
		return lowerPart;
	}
}
