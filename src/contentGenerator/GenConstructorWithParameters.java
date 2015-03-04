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
		
		String strComma = "";
		
		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
			
			fileContent.append(strComma).append(SPACE).append(memberType).append(SPACE).append(memberName);
			strComma = ",";
			
		} 
		
		fileContent.append(")").append(" {").append(ENTER);

		for(String memberName: memberNames){
			
			String memberType = members.get(memberName);
			
			genSentenceByType(memberName,memberType,fileContent);
			
		} 	
		
		fileContent.append(TAB).append("}")
	       .append(ENTER).append(ENTER);

	}
	
	private void genSentenceByType(String memberName,String memberType,StringBuffer fileContent){
		
		
		
	}

}
