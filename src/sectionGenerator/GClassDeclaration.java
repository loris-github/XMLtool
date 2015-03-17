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
		
		Util.joint(content, _public,SPACE,_class,SPACE,className,SPACE,
				_implements,SPACE,_Comparable,LAB,beanName,RAB,COMMA,_Cloneable,COMMA,
				_Serializable,SPACE,LB,ENTER,ENTER,
				TAB,_private,SPACE,_static,SPACE,_final,SPACE,_long,SPACE,
				_serialVersionUID,SPACE,EQUAL,SPACE,_1L,SEMI,ENTER,ENTER);		
	}

}
