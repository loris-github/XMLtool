package sectionGenerator;

import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.Util;

public class GGetSet extends Section{
	
	protected final void genByMembers(StringBuilder midPart, String memberName,String memberType){
		
		GenGet(midPart,memberName,memberType);
		
		GenSet(midPart,memberName,memberType);
		
	}
	
	// create method get;	
	private final void GenGet(StringBuilder content,String memberName,String memberType){

		Util.joint(content,TAB,PUBLIC,SPACE,memberType,SPACE,"get");
		
		content.append(Character.toUpperCase(memberName.charAt(0)));
		
		Util.joint(content,memberName.substring(1),LRB,RRB,LB,ENTER,
				TAB,TAB,
				RETURN,SPACE,THIS,DOT,memberName,SEMI,ENTER,
				TAB,RB,ENTER);

	}
				
	// create method set;	
	private final void GenSet(StringBuilder content,String memberName,String memberType){
		
		Util.joint(content,TAB,PUBLIC,SPACE,"void",SPACE,"set");
		
		content.append(Character.toUpperCase(memberName.charAt(0)));
		
		Util.joint(content,memberName.substring(1),LRB,memberType,SPACE,memberName,RRB,LB,ENTER,
				TAB,TAB,THIS,DOT,memberName,SPACE,EQUAL,SPACE,memberName,SEMI,ENTER,
				TAB,RB,ENTER);		
	}
	
}
