package sectionGenerator;

import sectionGenerator.generatorInterface.Sentence;
import sectionGenerator.generatorInterface.Util;
import tool.XMLBean;

public class GClassDeclaration extends Sentence{

	@Override
	public void appendContent(StringBuilder content, XMLBean xb) {
		
		String beanName = xb.getBeanName();
		
		String className = Character.toUpperCase(beanName.charAt(0))
			      + beanName.substring(1);
		
		Util.joint(content, PUBLIC,SPACE,"class",SPACE,className,SPACE,
				"implements",SPACE,"Comparable",LAB,beanName,RAB,COMMA,SPACE,
				"java",DOT,"io",DOT,"Serializable",SPACE,LB,ENTER,ENTER,
				TAB,PRIVATE,SPACE,"static",SPACE,"final",SPACE,"long",SPACE,
				"serialVersionUID",SPACE,EQUAL,SPACE,"1L",SEMI,ENTER,ENTER);		
	}

}
