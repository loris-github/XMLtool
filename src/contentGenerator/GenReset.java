package contentGenerator;

import java.util.Map;
import java.util.Set;

import tool.XMLBean;

public class GenReset implements ContentGenerator {

	@Override
	public void generateContent(StringBuffer fileContent, XMLBean xb) {
		
		Map<String,String> members = xb.getMembers();
		Set<String> memberNames = members.keySet();
		
		fileContent.append(TAB).append(PUBLIC).append(SPACE)
	       .append("void").append(SPACE).append("reset()")
	       .append(SPACE).append("{").append(ENTER);
		
		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
			
			String strType = ContentKit.getStrBeforeLeftAngleBracket(memberType);
			
			genByType(strType,memberName,memberType,fileContent);
			
		} 	
		
		fileContent.append(TAB).append("}")
	       .append(ENTER).append(ENTER);

	}
	
	private void genByType(String strType,String memberName,String memberType,StringBuffer fileContent){
		
		if(ContentKit.isBasicType(strType)) {
			
			String value = "0";
			
			if("boolean".equals(strType)) value = "flase";
			
			fileContent.append(TAB).append(TAB)
			.append(memberName).append(SPACE)
			.append("=").append(SPACE).append(value).append(SEMICOLON).append(ENTER);
			
		} else if("String".equals(strType)){
			
			fileContent.append(TAB).append(TAB)
			.append(memberName).append(SPACE)
			.append("=").append(SPACE).append("\"\"").append(SEMICOLON).append(ENTER);

		} else if(ContentKit.isCollectionType(strType)) {
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(".clear()").append(SEMICOLON).append(ENTER);
			
		} else{
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(" = null")
			.append(SEMICOLON).append(ENTER);
			
		}
		
	}
	
}
