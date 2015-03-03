package contentGenerator;

import tool.XMLBean;

public interface ContentGenerator {

	public static final String PRIVATE = "private";
	public static final String PUBLIC = "public";
	public static final String SPACE = " ";
	public static final String ENTER = "\n";
	public static final String TAB = "\t";
	public static final String SEMICOLON = ";";
	
	void generateContent(StringBuffer fileContent, XMLBean xb);
}
