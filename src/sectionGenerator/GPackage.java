package sectionGenerator;

import sectionGenerator.generatorInterface.Sentence;
import sectionGenerator.generatorInterface.Util;
import tool.XMLBean;

public class GPackage extends Sentence{

	@Override
	public void appendContent(StringBuilder content, XMLBean xb) {
		
		String path = xb.getPath();
		
		Util.joint(content, "package",SPACE,path,SEMI,ENTER,ENTER);		
	}
}
