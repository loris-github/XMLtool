package sectionGenerator;

import sectionGenerator.generatorInterface.GenMidPartStrategy;
import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.Util;

public class GEquals extends Section {
	//生成方法声明部分 + 左大括号
	protected StringBuilder genDeclarePart(){
		return nothing;
	}
	
	//生成方法内容的上半部分
	protected StringBuilder genUpperPart(){
		return nothing;
	}
	
	//生成方法内容的中间部分
	@Override
	protected StringBuilder genMidPart(){
		
		StringBuilder midPart = new StringBuilder();
		
		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
						
			String strType = Util.getStrBeforeLeftAngleBracket(memberType);
			
			int strategyID = GenMidPartStrategy.getStrategyID (strType, );

			genByType(midPart, strategyID, memberName, memberType);

		}
		
		return midPart;
	}
	
	private void genByType(StringBuilder midPart, int strategyID, String memberName,String memberType){
			
		//根据判断结果生中间部分

		switch(strategyID){

		case 0 :			
			break;
			
		case 1 :
			
			break;
		
		case 2 :			
			
			break;	
			
		case 3 :			
			
			break;
			
		case 4 :			
			
			break;
			
		case -1 :			
			
			break;
		}
	
	}
	
	//生成方法内容的下半部分
	protected StringBuilder genLowerPart(){
		return nothing;
	}
}
