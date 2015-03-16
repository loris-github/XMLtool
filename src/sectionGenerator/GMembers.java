package sectionGenerator;

import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.Util;

public class GMembers extends Section{
	
	protected final void genByMembers(StringBuilder midPart, String memberName,String memberType){
		Util.joint(midPart, TAB,PRIVATE,SPACE,memberType,SPACE,memberName,SEMI,ENTER);
	}

}
