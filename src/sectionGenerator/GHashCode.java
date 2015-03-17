package sectionGenerator;

import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.TypeSortStrategy;
import sectionGenerator.generatorInterface.Util;

public class GHashCode extends Section {
	
	public GHashCode(){
		this.typeSortStrategy = TypeSortStrategy.TSS_HashCode;
	}
	
	//方法声明部分
	@Override
	protected final StringBuilder genDeclarePart(){
		
		StringBuilder declarePart = new StringBuilder();
		Util.joint(declarePart, TAB,_public,SPACE,_int,SPACE,_hashCode,LRB,RRB);
		
		return declarePart;
	}
	
	//方法上半部分
	@Override
	protected final StringBuilder genUpperPart(){
		
		StringBuilder upperPart = new StringBuilder();
		
		// int h = (int)serialVersionUID;
		Util.joint(upperPart,LB,ENTER,ENTER,TAB,TAB,
				_int,SPACE,_h,SPACE,EQUAL,SPACE,LRB,_int,RRB,_serialVersionUID,SEMI,ENTER,ENTER);
		
		return upperPart;
	}

	//方法中间部分
	@Override
	protected final void genByMembers(StringBuilder midPart, int strategyID, String memberName,String memberType){
			
		//语句中间部分

		switch(strategyID){
		
		// byte, short, int, long, float, double, char, boolean
		// h = h * 31 + 1 + (int)this.memberName;
		case 0 :
			Util.joint(midPart, TAB,TAB,
					_h,SPACE,EQUAL,SPACE,
					_h,SPACE,ASTERISK,SPACE,_31,SPACE,PLUS,SPACE,_1,SPACE,
					PLUS,SPACE,LRB,_int,RRB,_this,DOT,memberName,SEMI,ENTER);			
			break;
		
		// OtherTypes
		// h = h * 31 + 1 + this.memberName.hashCode();
		case -1 :
			Util.joint(midPart, TAB,TAB,
					_h,SPACE,EQUAL,SPACE,
					_h,SPACE,ASTERISK,SPACE,_31,SPACE,PLUS,SPACE,_1,SPACE,
					PLUS,SPACE,_this,DOT,memberName,DOT,_hashCode,LRB,RRB,SEMI,ENTER);	
			break;
		}	
	}	
	
	//方法下半部分
	@Override
	protected final StringBuilder genLowerPart(){
		
		StringBuilder lowerPart = new StringBuilder();
		Util.joint(lowerPart,TAB,TAB,_return,SPACE,_h,SEMI,ENTER,TAB,RB,ENTER,ENTER);
		
		return lowerPart;
	}
}
