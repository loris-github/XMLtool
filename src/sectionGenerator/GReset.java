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
		Util.joint(declarePart, TAB,PUBLIC,SPACE,"void",SPACE,"reset",LRB,RRB);
		
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
			
		//语句中间部分
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
	
	//方法下半部分
	@Override
	protected final StringBuilder genLowerPart(){
		StringBuilder lowerPart = new StringBuilder();
		
		Util.joint(lowerPart,TAB,RB,ENTER);
		
		return lowerPart;
	}
}
