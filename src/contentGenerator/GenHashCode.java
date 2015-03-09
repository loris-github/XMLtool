package contentGenerator;

import java.util.Map;
import java.util.Set;

import tool.XMLBean;

public class GenHashCode implements ContentGenerator {

	@Override
	public void generateContent(StringBuffer fileContent, XMLBean xb) {
		
		Map<String,String> members = xb.getMembers();
		Set<String> memberNames = members.keySet();
		
		
		fileContent.append(TAB).append(PUBLIC).append(SPACE)
	       .append("int").append(SPACE).append("hashCode()")
	       .append(SPACE).append("{").append(ENTER);
		
		fileContent.append(TAB).append(TAB).append("int h = (int)serialVersionUID;").append(ENTER);
		
		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
			
			String strType = ContentKit.getStrBeforeLeftAngleBracket(memberType);
			
			genByType(strType,memberName,memberType,fileContent);
			
		} 	
		
		fileContent.append(TAB).append(TAB).append("return h;").append(ENTER)
			.append(TAB).append("}").append(ENTER).append(ENTER);

	}

	private void genByType(String strType,String memberName,String memberType,StringBuffer fileContent){
		
		if(ContentKit.isBasicType(strType)) {
			
			String value = "";
			
			if("long".equals(strType) || "float".equals(strType) ||"double".equals(strType)) value = "(int)";
			
			fileContent.append(TAB).append(TAB)
			.append("h = h * 31 + 1 + ").append(value).append("this.").append(memberName)
			.append(SEMICOLON).append(ENTER);			
			
		} else{
			
			fileContent.append(TAB).append(TAB)
			.append("h = h * 31 + 1 + this.").append(memberName)
			.append(".hashCode()").append(SEMICOLON).append(ENTER);	
			
		}
		
	}

}
