package sectionGenerator;

import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.TypeSortStrategy;
import sectionGenerator.generatorInterface.Util;

public class GToString extends Section {
	
	public GToString(){
		this.typeSortStrategy = TypeSortStrategy.TSS_ToString;
	}
	
	//方法声明部分
	@Override
	protected final StringBuilder genDeclarePart(){
		
		StringBuilder declarePart = new StringBuilder();
		
		Util.joint(declarePart, TAB,TAB,PUBLIC,SPACE,
				"String",SPACE,"toString",LRB,RRB);

		return declarePart;
	}
	
	//方法上半部分
	@Override
	protected final StringBuilder genUpperPart(){
		
		StringBuilder upperPart = new StringBuilder();
		
		Util.joint(upperPart,LB,ENTER,TAB,TAB,"StringBuffer",SPACE,"s",SPACE,EQUAL,SPACE,"new",
				SPACE,"StringBuffer",LRB,RRB,SEMI,ENTER);
		
		return upperPart;
	}
	
	//方法中间部分
	@Override
	protected final void genByMembers(StringBuilder midPart, int strategyID, String memberName,String memberType){

		//语句前半部分	
		Util.joint(midPart,TAB,TAB);		
		
		//语句中间部分
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
	
		//语句后半部分
			Util.joint(midPart,SEMI,ENTER);
		
	}
	
	//方法下半部分
	@Override
	protected final StringBuilder genLowerPart(){
		
		StringBuilder lowerPart = new StringBuilder();
		
		Util.joint(lowerPart, TAB,TAB,"RETURN",SPACE,"s",DOT,"append",LRB,QUOTE,RB,QUOTE,RRB,
				DOT,"toString",LRB,RRB,SEMI,ENTER,TAB,RB,ENTER);

		return lowerPart;
	}
}
