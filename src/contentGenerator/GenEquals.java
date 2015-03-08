package contentGenerator;

import java.util.Map;
import java.util.Set;

import tool.XMLBean;

public class GenEquals implements ContentGenerator {

	@Override
	public void generateContent(StringBuffer fileContent, XMLBean xb) {
		
		
		String beanName = xb.getBeanName();
		Map<String,String> members = xb.getMembers();
		Set<String> memberNames = members.keySet();

		fileContent.append(TAB).append(PUBLIC).append(SPACE)
	       .append("boolean").append(SPACE)
	       .append("equals").append("(Object").append(SPACE)
	       .append("o)").append(ENTER).append("{").append(ENTER);
		
		fileContent.append(TAB).append(TAB)
		.append("if(o == this) return true;").append(ENTER)
		.append(TAB).append(TAB)
		.append("if(!(o instanceof").append(SPACE).append(beanName)
		.append(")) return false;").append(ENTER)
		.append(TAB).append(TAB)
		.append(beanName).append(SPACE).append("e").append(SPACE).append("=").append(SPACE)
		.append("(").append(beanName).append(")o").append(SEMICOLON).append(ENTER);
		
		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
			
			String strType = ContentKit.getStrBeforeLeftAngleBracket(memberType);
			
			genByType(strType,memberName,memberType,fileContent);
			
		} 		

		fileContent.append(TAB).append(TAB)
			.append("return true;").append(ENTER)			
			.append(TAB).append("}").append(ENTER).append(ENTER);
	}
	
	
	private void genByType(String strType,String memberName,String memberType,StringBuffer fileContent){	
		
		if(ContentKit.isBasicType(strType)) {
			
			fileContent.append(TAB).append(TAB)
			.append("if(this.").append(memberName).append(SPACE)
			.append("!=").append(SPACE)
			.append("e.").append(memberName).append(")").append(SPACE)
			.append("return false").append(SEMICOLON).append(ENTER);

		} else { 
			
			fileContent.append(TAB).append(TAB)
			.append("if(!this.").append(memberName).append(".equals(e.")
			.append(memberName).append("))").append(SPACE).append("return false;").append(ENTER);

		}

	}

}
