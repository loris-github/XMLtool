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
				TAB,_public,SPACE,_int,SPACE,_compareTo,LRB,beanName,SPACE,_c,RRB);
		
		return declarePart;
	}
	
	//方法上半部分
	@Override
	protected final StringBuilder genUpperPart(){
		
		StringBuilder upperPart = new StringBuilder();
		
		// if(c == this) return 0;
		// if(c == null) return	1;
		// int i;
		Util.joint(upperPart,LB,ENTER,ENTER,
				TAB,TAB,
				_if,LRB,_c,SPACE,EQUAL,EQUAL,SPACE,_this,RRB,SPACE,_return,SPACE,_0,SEMI,ENTER,
				TAB,TAB,
				_if,LRB,_c,SPACE,EQUAL,EQUAL,SPACE,_null,RRB,SPACE,_return,SPACE,_1,SEMI,ENTER,
				TAB,TAB,
				_int,SPACE,_i,SEMI,ENTER,ENTER);
		
		return upperPart;
	}
	
	//方法中间部分
	@Override
	protected final void genByMembers(StringBuilder midPart, int strategyID, String memberName,String memberType){
		
		//语句前半部分	
		Util.joint(midPart,TAB,TAB,_i,SPACE,EQUAL,SPACE);
		
		//语句中间部分
		switch(strategyID){
		
		// float
		// i = Float.compare(this.memberName, c.memberName);
		case 0 :			
			Util.joint(midPart,_Float,DOT,_compare,LRB,_this,DOT,memberName,COMMA,
					SPACE,_c,DOT,memberName,RRB,SEMI);
			break;
		
		// double	
		// i = Double.compare(this.memberName, c.memberName);
		case 1 :
			Util.joint(midPart,_Double,DOT,_compare,LRB,_this,DOT,memberName,COMMA,
					SPACE,_c,DOT,memberName,RRB,SEMI);
			break;
		
		// long
		//	i = Long.signum(this.memberName, c.membername);
		case 2 :			
			Util.joint(midPart,_Long,DOT,_signum,LRB,_this,DOT,memberName,COMMA,
					SPACE,_c,DOT,memberName,RRB,SEMI);
			break;	
		
		// byte, short, int, char, boolean
		// i = this.memberName - c.member	
		case 3 :
			Util.joint(midPart,_this,DOT,memberName,SPACE,MINUS,SPACE,_c,DOT,memberName,SEMI);
			break;
		
		// Map, HashMap, List, ArrayList, Set, HashSet
		// i = Util.compare(this.memberName, c.memberName);
		case 4 :			
			Util.joint(midPart,_Util,DOT,_compareTo,LRB,_this,DOT,memberName,COMMA,
					_c,DOT,memberName,RRB,SEMI);
			break;
		
		// OtherTypes
		// i = this.memberName.compareTo(c.memberName);	
		case -1 :			
			Util.joint(midPart,_this,DOT,memberName,DOT,_compareTo,LRB,
					_c,DOT,memberName,RRB,SEMI);
			break;
		}
		
		//语句后半部分
		// if(i != 0 ) return i;
		Util.joint(midPart,SPACE,_if,LRB,_i,EXCLA,EQUAL,SPACE,_0,RRB,SPACE,_return,SPACE,_i,SEMI,ENTER);	
	}	
	
	//方法下半部分
	@Override
	protected final StringBuilder genLowerPart(){
		StringBuilder lowerPart = new StringBuilder();
		
		Util.joint(lowerPart,
				ENTER,TAB,TAB,
				_return,SPACE,_0,SEMI,ENTER,TAB,RB,ENTER,ENTER);
		
		return lowerPart;
	}
}
