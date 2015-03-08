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
			
			fileContent.append(strComma).append(memberType).append(SPACE).append(memberName);
			
			strComma = ",";
			
		} 
		
		fileContent.append(")").append(" {").append(ENTER);

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
			.append("=").append(SPACE).append(memberName).append(SEMICOLON).append(ENTER);				
			
		} else if("String".equals(strType)) {
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE)
			.append("=").append(SPACE).append("(").append(memberName).append(SPACE)
			.append("!=").append(SPACE).append("null").append(SPACE).append("?").append(SPACE)
			.append(memberName).append(SPACE).append(":").append(SPACE).append("\"\")").append(SEMICOLON).append(ENTER);
		
		} else if(ContentKit.isCollectionType(strType)) {
			
			String[] strOfSentence = ContentKit.collectionType.get(strType);
			
			String strConstruct = strOfSentence[0];
			
			String methodName = strOfSentence[1];
			
			genSentenceForSetListMap(memberName,memberType,fileContent,strConstruct,methodName);

		} else { 
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE)
			.append("=").append(SPACE).append("(").append(memberName).append(SPACE)
			.append("!=").append(SPACE).append("null").append(SPACE).append("?").append(SPACE)
			.append(memberType).append(".clone()").append(SPACE).append(":").append(SPACE).append("new")
			.append(SPACE).append(memberType).append("())").append(SEMICOLON).append(ENTER);	
		}	
		
	}

	private void genSentenceForSetListMap(String memberName,String memberType,StringBuffer fileContent,String strConstruct,String methodName){
			
		fileContent.append(TAB).append(TAB)
		.append("this.").append(memberName).append(SPACE)
		.append("=").append(SPACE).append("new").append(SPACE).append(strConstruct).append("()").append(SEMICOLON)
		.append(SPACE).append("if(null").append(SPACE).append("!=").append(SPACE).append(memberName).append(")").append(SPACE)
		.append("this.").append(memberName).append(".").append(methodName).append("(").append(memberName).append(")")
		.append(SEMICOLON).append(ENTER);
		
	}

}
