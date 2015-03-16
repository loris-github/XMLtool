package sectionGenerator;

import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.TypeSortStrategy;
import sectionGenerator.generatorInterface.Util;

public class GCompareTo extends Section {
	
	public GCompareTo(){
		this.typeSortStrategy = TypeSortStrategy.TSS_CompareTo;
	}

	//方法声明部分
	@Override
	protected final StringBuilder genDeclarePart(){
		
		StringBuilder declarePart = new StringBuilder();
		
		Util.joint(declarePart,
				TAB,PUBLIC,SPACE,INT,SPACE,COMPARETO,LRB,beanName,SPACE,
				"c",RRB);
		
		return declarePart;
	}
	
	//方法上半部分
	@Override
	protected final StringBuilder genUpperPart(){
		
		StringBuilder upperPart = new StringBuilder();
		
		Util.joint(upperPart,LRB,ENTER,
				TAB,TAB,
				IF,LRB,"c",SPACE,EQUAL,EQUAL,SPACE,THIS,RRB,SPACE,RETURN,SPACE,"0",SEMI,
				TAB,TAB,
				IF,LRB,"c",SPACE,EQUAL,EQUAL,SPACE,NULL,RRB,SPACE,RETURN,SPACE,"1",SEMI,
				TAB,TAB,
				INT,SPACE,"i",SEMI);
		
		return upperPart;
	}
	
	//方法中间部分
	@Override
	protected final void genByMembers(StringBuilder midPart, int strategyID, String memberName,String memberType){
		
		//语句前半部分	
		Util.joint(midPart,TAB,TAB,"i",SPACE,EQUAL,SPACE);
		
		//语句中间部分
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
		
		//语句后半部分
		Util.joint(midPart,SPACE,IF,LRB,"i",EXCLA,EQUAL,SPACE,"0",RRB,SEMI);	
	}	
	
	//方法下半部分
	@Override
	protected final StringBuilder genLowerPart(){
		StringBuilder lowerPart = new StringBuilder();
		
		Util.joint(lowerPart,
				TAB,TAB,
				RETURN,SPACE,"0",SEMI,ENTER,TAB,RB,ENTER);
		
		return lowerPart;
	}
}
