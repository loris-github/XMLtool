package contentGenerator;

import java.util.Map;
import java.util.Set;

import tool.XMLBean;

public class GenConstructorWithParameters implements ContentGenerator {

	@Override
	public void generateContent(StringBuffer fileContent, XMLBean xb) {
		
		String beanName = xb.getBeanName();
		Map<String,String> members = xb.getMembers();
		Set<String> memberNames = members.keySet();

		fileContent.append(TAB)
	       .append(PUBLIC)
	       .append(SPACE)
	       .append(beanName)
	       .append(SPACE)
	       .append("(");
		
		// 生成参数
		String strComma = "";
		
		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
			
			fileContent.append(strComma).append(SPACE).append(memberType).append(SPACE).append(memberName);
			
			strComma = ",";
			
		} 
		
		fileContent.append(")").append(" {").append(ENTER);

		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
			
			String strType = ContentKit.getStrBeforeLeftAngleBracket(memberType, memberType);
			
			genByType(strType,memberName,memberType,fileContent);
			
		} 	
		
		fileContent.append(TAB).append("}")
	       .append(ENTER).append(ENTER);

	}
	
	private void genByType(String strType,String memberName,String memberType,StringBuffer fileContent){
		
		if(ContentKit.isBasicType(strType)) {
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE)
			.append("=").append(SPACE).append(memberName).append(SEMICOLON).append(ENTER);				
			
		} else if("String".equals(strType)) {
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE)
			.append("=").append(SPACE).append("(").append(memberName).append(SPACE)
			.append("!=").append(SPACE).append("null").append(SPACE).append("?").append(SPACE)
			.append(memberName).append(SPACE).append(":").append(SPACE).append("\"\")").append(SEMICOLON).append(ENTER);
		
		} else if("Map".equals(strType) || "Set".equals(strType)) {	
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE)
			.append("=").append(SPACE).append("new").append(SPACE).append("Hash").append(memberType).append(SPACE)
			.append("()").append(SEMICOLON).append(SPACE).append("if(").append(memberName).append(SPACE).append("!=")
			.append(SPACE).append("null)").append(SPACE).append("this.").append(memberName)
			.append(".addAll(").append(memberName).append(")").append(SEMICOLON).append(ENTER);

		} else if("List".equals(strType)) {	
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE)
			.append("=").append(SPACE).append("new").append(SPACE).append("Array").append(memberType).append(SPACE)
			.append("()").append(SEMICOLON).append(SPACE).append("if(").append(memberName).append(SPACE).append("!=")
			.append(SPACE).append("null)").append(SPACE).append("this.").append(memberName)
			.append(".addAll(").append(memberName).append(")").append(SEMICOLON).append(ENTER);

		} else if(ContentKit.isSubsetsOfListSetMap(strType)) { 
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE)
			.append("=").append(SPACE).append("new").append(SPACE).append(memberType).append(SPACE)
			.append("()").append(SEMICOLON).append(SPACE).append("if(").append(memberName).append(SPACE).append("!=")
			.append(SPACE).append("null)").append(SPACE).append("this.").append(memberName)
			.append(".addAll(").append(memberName).append(")").append(SEMICOLON).append(ENTER);

		} else { 
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE)
			.append("=").append(SPACE).append("(").append(memberName).append(SPACE)
			.append("!=").append(SPACE).append("null").append(SPACE).append("?").append(SPACE)
			.append(memberType).append(".clone()").append(SPACE).append(":").append(SPACE).append("new")
			.append(SPACE).append(memberType).append("())").append(SEMICOLON).append(ENTER);	
		}	
		
	}

}
