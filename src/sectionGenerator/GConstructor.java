package sectionGenerator;

import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.TypeSortStrategy;
import sectionGenerator.generatorInterface.Util;

public final class GConstructor extends Section {
	
	public GConstructor (){
		this.typeSortStrategy = TypeSortStrategy.TSS_Constructor;
	}
	
	//方法声明部分
	@Override
	protected final StringBuilder genDeclarePart(){
		
		StringBuilder declarePart = new StringBuilder();
		
		Util.joint (declarePart,
			TAB,_public,SPACE,beanName,SPACE,LRB,RRB);
		
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

		// basicTypes
		case 0 :
			return;
		
		// String
		// this.memberName = "";
		case 1 : 
			Util.joint (midPart,TAB,TAB,
					_this,DOT,memberName,SPACE,EQUAL,SPACE,QUOTE,QUOTE,SEMI,
					ENTER);
			break;
		
		// Map
		// this.memberName = new HashMap();
		case 2 :			
			Util.joint (midPart,TAB,TAB,
					_this,DOT,memberName,SPACE,EQUAL,SPACE,_new,SPACE,_HashMap,LRB,RRB,SEMI,
					ENTER);
			break;	
			
		// List
		// this.memberName = new ArrayList();
		case 3 :			
			Util.joint (midPart,TAB,TAB,
					_this,DOT,memberName,SPACE,EQUAL,SPACE,_new,SPACE,_ArrayList,LRB,RRB,SEMI,
					ENTER);
			break;
		
		// Set
		// this.memberName = new HashSet();
		case 4 :			
			Util.joint (midPart,TAB,TAB,
					_this,DOT,memberName,SPACE,EQUAL,SPACE,_new,SPACE,_HashSet,LRB,RRB,SEMI,
					ENTER);
			break;
			
		// OtherTypes
		// this.memberName = new memberType();
		case -1 :			
			Util.joint (midPart,TAB,TAB,
					_this,DOT,memberName,SPACE,EQUAL,SPACE,_new,SPACE,memberType,LRB,RRB,SEMI,
					ENTER);
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
