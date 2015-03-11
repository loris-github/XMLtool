package contentGenerator;

import java.util.Map;
import java.util.Set;

import tool.XMLBean;

public class GenAssign implements ContentGenerator {

	@Override
	public void generateContent(StringBuffer fileContent, XMLBean xb) {
		
		String beanName = xb.getBeanName();
		Map<String,String> members = xb.getMembers();
		Set<String> memberNames = members.keySet();
		
		fileContent.append(TAB).append(PUBLIC).append(SPACE)
	       .append("void").append(SPACE).append("assign(")
	       .append(beanName).append(SPACE).append("a)")
	       .append(SPACE).append("{").append(ENTER);
		
		fileContent.append(TAB).append(TAB)
		.append("if(a == this) return;").append(ENTER)
		.append(TAB).append(TAB)
		.append("if(a == null) {reset(); return;}").append(ENTER);
		
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
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE)
			.append("=").append(SPACE).append("a.").append(memberName).append(SEMICOLON).append(ENTER);
			
		} else if("String".equals(strType)){
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE)
			.append("=").append(SPACE).append("(a.").append(memberName).append(SPACE).append("!=")
			.append(SPACE).append("null").append(SPACE).append("?").append(SPACE).append("a.")
			.append(memberName).append(SPACE).append(":").append(SPACE)
			.append("\"\")").append(SEMICOLON).append(ENTER);

		} else if(ContentKit.isCollectionType(strType)) {
			
			String[] strOfSentence = ContentKit.collectionType.get(strType);
			
			String strConstruct = strOfSentence[0];
			
			String methodName = strOfSentence[1];
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(".clear()").append(SEMICOLON).append(SPACE)
			.append("if(a.").append(memberName).append(SPACE).append("!=").append(SPACE)
			.append("null)").append(SPACE).append("this.").append(memberName).append(".")
			.append(methodName).append("(a.").append(memberName).append(")").append(SEMICOLON).append(ENTER);
			
		} else{
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(".assign(a.").append(memberName)
			.append(")").append(SEMICOLON).append(ENTER);
			
		}
	}
}
