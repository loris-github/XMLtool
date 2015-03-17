package sectionGenerator;

import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.TypeSortStrategy;
import sectionGenerator.generatorInterface.Util;

public class GEquals extends Section {
	
	public GEquals(){
		this.typeSortStrategy = TypeSortStrategy.TSS_Equals;
	}
		
	//方法声明部分
	@Override
	protected final StringBuilder genDeclarePart(){
		
		StringBuilder declarePart = new StringBuilder();
		Util.joint(declarePart, TAB,PUBLIC,SPACE,"boolean",SPACE,"equals",LRB,"Object",SPACE,"o",RRB);
		
		return declarePart;
	}
	
	//方法上半部分
	@Override
	protected final StringBuilder genUpperPart(){
		
		// if(o == this) return true;
		// if(!(o instanceof beanName)) return false;
		// beanName e = (beanName)o ;
		StringBuilder upperPart = new StringBuilder();
		Util.joint(upperPart,LB,ENTER,TAB,TAB,IF,LRB,"o",SPACE,EQUAL,EQUAL,SPACE,THIS,RRB,
				SPACE,RETURN,SPACE,"true",SEMI,ENTER,
				TAB,TAB,
				IF,LRB,EXCLA,LRB,"o",SPACE,"instanceof",SPACE,beanName,RRB,RRB,
				SPACE,RETURN,SPACE,"false",SEMI,ENTER,
				TAB,TAB,
				beanName,SPACE,"e",SPACE,EQUAL,SPACE,LRB,beanName,RRB,"o",SEMI,ENTER);
		
		return upperPart;
	}
	
	//方法中间部分
	@Override
	protected final void genByMembers(StringBuilder midPart, int strategyID, String memberName,String memberType){
			
		//语句中间部分
		switch(strategyID){
		
		// byte, short, int, long, float, double, char, boolean
		// if(this.memberName != e.memberName) return false; 
		case 0 :	
			Util.joint(midPart,TAB,TAB,
					IF,LRB,THIS,DOT,memberName,SPACE,EXCLA,EQUAL,SPACE,"e",DOT,memberName,RRB,SPACE,
					RETURN,SPACE,"false",SEMI,ENTER);
			break;
		
		// OtherTypes
		// if(!this.memberName.equals(e.memberName)) return false;
		case -1 :			
			Util.joint(midPart,TAB,TAB,
					IF,LRB,EXCLA,THIS,DOT,memberName,DOT,"equals",LRB,"e",DOT,memberName,RRB,RRB,SPACE,
					RETURN,SPACE,"false",SEMI,ENTER);
			break;
		}
	
	}
	
	//方法下半部分
	@Override
	protected final StringBuilder genLowerPart(){
		
		StringBuilder lowerPart = new StringBuilder();
		Util.joint(lowerPart,TAB,TAB,RETURN,SPACE,"true",SEMI,ENTER,TAB,RB,ENTER,ENTER);
		
		return lowerPart;
	}

}
