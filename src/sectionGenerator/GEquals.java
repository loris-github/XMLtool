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
		Util.joint(declarePart, TAB,_public,SPACE,_boolean,SPACE,_equals,LRB,_Object,SPACE,_o,RRB);
		
		return declarePart;
	}
	
	//方法上半部分
	@Override
	protected final StringBuilder genUpperPart(){
		
		// if(o == this) return true;
		// if(!(o instanceof beanName)) return false;
		// beanName e = (beanName)o ;
		StringBuilder upperPart = new StringBuilder();
		Util.joint(upperPart,LB,ENTER,ENTER,TAB,TAB,_if,LRB,_o,SPACE,EQUAL,EQUAL,SPACE,_this,RRB,
				SPACE,_return,SPACE,_true,SEMI,ENTER,
				TAB,TAB,
				_if,LRB,EXCLA,LRB,_o,SPACE,_instanceof,SPACE,beanName,RRB,RRB,
				SPACE,_return,SPACE,_false,SEMI,ENTER,
				TAB,TAB,
				beanName,SPACE,_e,SPACE,EQUAL,SPACE,LRB,beanName,RRB,_o,SEMI,ENTER,ENTER);
		
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
					_if,LRB,_this,DOT,memberName,SPACE,EXCLA,EQUAL,SPACE,_e,DOT,memberName,RRB,SPACE,
					_return,SPACE,_false,SEMI,ENTER);
			break;
		
		// OtherTypes
		// if(!this.memberName.equals(e.memberName)) return false;
		case -1 :			
			Util.joint(midPart,TAB,TAB,
					_if,LRB,EXCLA,_this,DOT,memberName,DOT,_equals,LRB,_e,DOT,memberName,RRB,RRB,SPACE,
					_return,SPACE,_false,SEMI,ENTER);
			break;
		}
	
	}
	
	//方法下半部分
	@Override
	protected final StringBuilder genLowerPart(){
		
		StringBuilder lowerPart = new StringBuilder();
		Util.joint(lowerPart,ENTER,TAB,TAB,_return,SPACE,_true,SEMI,ENTER,TAB,RB,ENTER,ENTER);
		
		return lowerPart;
	}

}
