package contentGenerator;

import java.util.Map;
import java.util.Set;

import tool.XMLBean;

public class GenCompareTo implements ContentGenerator {

	@Override
	public void generateContent(StringBuffer fileContent, XMLBean xb) {
		
		String beanName = xb.getBeanName();
		Map<String,String> members = xb.getMembers();
		Set<String> memberNames = members.keySet();

		fileContent.append(TAB).append(PUBLIC).append(SPACE)
	       .append("int").append(SPACE).append("compareTo(")
	       .append(beanName).append(SPACE).append("c)")
	       .append(SPACE).append("{").append(ENTER);
		
		fileContent.append(TAB).append(TAB)
		.append("if(c == this) return 0;").append(ENTER)
		.append(TAB).append(TAB)
		.append("if(c == null) return 1;").append(ENTER)
		.append(TAB).append(TAB)
		.append("int i;").append(ENTER);
		
		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
			
			String strType = ContentKit.getStrBeforeLeftAngleBracket(memberType);
			
			genByType(strType,memberName,memberType,fileContent);
			
		} 	
		
		fileContent.append(TAB).append(TAB)
		.append("return 0;").append(ENTER)
		.append(TAB).append("}").append(ENTER);		
	}
	
	private void genByType(String strType,String memberName,String memberType,StringBuffer fileContent){
		
		StringBuffer strBegin = new StringBuffer();
		
		strBegin.append(TAB).append(TAB)
		.append("i").append(SPACE).append("=").append(SPACE);
		
		StringBuffer strEnd = new StringBuffer();
		
		strEnd.append(SPACE).append("if(").append("i").append("!=").append(SPACE).append("0)")
		.append(SPACE).append("return i;").append(ENTER);
		
		
		StringBuffer strMiddle = new StringBuffer();
		
		if(ContentKit.isBasicType(strType)) {

			if("float".equals(strType)){
				
				strMiddle.append("Float.compare(this.").append(memberName).append(",")
				.append(SPACE).append("c.").append(memberName).append(");").append(SEMICOLON);
				
			} else if("double".equals(strType)){
				
				strMiddle.append("Double.compare(this.").append(memberName).append(",")
				.append(SPACE).append("c.").append(memberName).append(")").append(SEMICOLON);
				
				
			} else if("long".equals(strType)){
				
				strMiddle.append("Long.signum(this.").append(memberName).append(SPACE)
				.append("-").append(SPACE).append("c.").append(memberName).append(")").append(SEMICOLON);
				
			} else{
				
				strMiddle.append("this.").append(memberName).append(SPACE)
				.append("-").append(SPACE).append("c.").append(memberName).append(SEMICOLON);
			}

		} else if(ContentKit.isCollectionType(strType)) {
			
			strMiddle.append("contentGenerator.ContentKit.compareTo(this.")
			.append(memberName).append(",").append("c.").append(memberName).append(")").append(SEMICOLON);
			
		} else{
			
			strMiddle.append("this.").append(memberName)
			.append(".compareTo(c.").append(memberName).append(")").append(SEMICOLON);
			
		}
		
		fileContent.append(strBegin).append(strMiddle).append(strEnd);
		
	}
}
