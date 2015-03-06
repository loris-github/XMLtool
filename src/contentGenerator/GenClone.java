package contentGenerator;

import java.util.Map;
import java.util.Set;

import tool.XMLBean;

public class GenClone implements ContentGenerator {

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
	       .append("clone()").append(" {").append(ENTER)
	       .append(TAB).append(TAB).append("return").append(SPACE)
	       .append("new").append(SPACE).append(beanName)
	       .append("(");
		
		// 生成参数
			String strComma = "";
			
			for(String memberName: memberNames){
				
				fileContent.append(strComma).append(memberName);	
				
				strComma = ",";
				
			} 
		
			fileContent.append(")").append(SEMICOLON).append(ENTER).append(TAB)
			.append("}").append(ENTER).append(ENTER);
	}

}
