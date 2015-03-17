package sectionGenerator;

import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.Util;

public class GMembers extends Section{
	
	protected final void genByMembers(StringBuilder midPart, String memberName,String memberType){
		Util.joint(midPart, TAB,_private,SPACE,memberType,SPACE,memberName,SEMI,ENTER);
	}
	
	//方法下半部分
		protected StringBuilder genLowerPart(){
			
			StringBuilder lowerPart = new StringBuilder();
			
			Util.joint(lowerPart,ENTER);
			
			return lowerPart;
		}
}
