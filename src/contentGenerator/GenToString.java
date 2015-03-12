package contentGenerator;

import java.util.Map;
import java.util.Set;

import tool.XMLBean;

public class GenToString implements ContentGenerator {

	@Override
	public void generateContent(StringBuffer fileContent, XMLBean xb) {
		
		Map<String,String> members = xb.getMembers();
		Set<String> memberNames = members.keySet();

		fileContent.append(TAB).append(PUBLIC).append(SPACE)
	       .append("String").append(SPACE).append("toString()")
	       .append(SPACE).append("{").append(ENTER);
		
		fileContent.append(TAB).append(TAB)
		.append("StringBuffer").append(SPACE).append("s").append(SPACE).append("=").append(SPACE)
		.append("new").append(SPACE).append("StringBuffer()").append(SEMICOLON).append(ENTER);
		
		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
			
			String strType = ContentKit.getStrBeforeLeftAngleBracket(memberType);
			
			genByType(strType,memberName,memberType,fileContent);
			
		} 
		
		fileContent.append(TAB).append(TAB)
		.append("return s.append(\"}\").toString()").append(SEMICOLON).append(ENTER)
		.append(TAB).append("}").append(ENTER);

	}
	
	private void genByType(String strType,String memberName,String memberType,StringBuffer fileContent){
		
		if(ContentKit.isCollectionType(strType)) {
			
			fileContent.append(TAB).append(TAB)
			.append("contentGenerator.ContentKit.append(s,").append(SPACE).append("this.").append(memberName)
			.append(")").append(SEMICOLON).append(ENTER);

		} else {
			
			fileContent.append(TAB).append(TAB)
			.append("s.append(this.").append(memberName).append(").append(\",\")")
			.append(SEMICOLON).append(ENTER);
		}
	}

}
