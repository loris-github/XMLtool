package sectionGenerator;

import sectionGenerator.generatorInterface.MethodSection;
import sectionGenerator.generatorInterface.GenMidPartStrategy;
import sectionGenerator.generatorInterface.Util;
import tool.XMLBean;

public final class Constructor extends MethodSection {
	
	String[][] strategy;
	
	Constructor(XMLBean xb) {
		super(xb);
		this.strategy = GenMidPartStrategy.CONSTRUCTOR ;
	}
	
	//生成方法标题部分 + 左大括号
	protected StringBuilder genMethodTitle(){
		
		StringBuilder methodTitle = new StringBuilder();
		
		joint(methodTitle,
				TAB,PUBLIC,SPACE,beanName,SPACE,LRB,RRB,LB,
				ENTER);
		
		return methodTitle;
	}
	
	//生成方法内容的中间部分
	protected StringBuilder genMidPart(){
		
		StringBuilder midPart = new StringBuilder();
		
		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
						
			String strType = Util.getStrBeforeLeftAngleBracket(memberType);
			
			genByType(midPart, strType, memberName, memberType );

		}
		
		return midPart;
	}
		
	protected void genByType(StringBuilder midPart, String strType, String memberName,String memberType){
		
		//前半部公共部分
		joint (midPart,TAB,TAB,
				THIS,DOT,memberName,SPACE,EQUAL,SPACE,QUOTE,QUOTE,
				ENTER);
		
		//根据判断结果生中间部分
		int strategyID = GenMidPartStrategy.getStrategyID (strType,strategy);

		switch(strategyID){

		case 1 :			
			joint (midPart,QUOTE,QUOTE);
			break;
			
		case 2 :						
			joint (midPart,NEW,SPACE,PUTALL,LRB,RRB);
			break;
			
		case 3 :			
			joint (midPart,NEW,SPACE,ADDALL,LRB,RRB);
			break;	
			
		case -1 :			
			joint (midPart,NEW,SPACE,memberType,LRB,RRB);
			break;		
		}
		
		//后半部公共部分
		joint (midPart,SEMI,ENTER);
	
	}

}
