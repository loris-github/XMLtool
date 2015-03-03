package contentGenerator;

import tool.JFCreater;

public class GenPackage implements ContentGenerator {

	@Override
	public void generateContent(StringBuffer fileContent, JFCreater JFC) {
		String path = JFC.getPath();
		
		fileContent.append("package ").append(path)
	       .append(SEMICOLON);

	}

}
