package contentGenerator;

import tool.XMLBean;

public class GenPackage implements ContentGenerator {

	@Override
	public void generateContent(StringBuffer fileContent, XMLBean xb) {
		String path = xb.getPath();
		
		fileContent.append("package ").append(path)
	       .append(SEMICOLON).append(ENTER).append(ENTER);

	}

}
