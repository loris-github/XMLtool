package contentGenerator;

import java.util.Map;
import java.util.Set;

import tool.XMLBean;


public class GenPrivateProperty implements ContentGenerator {

	@Override
	public void generateContent(StringBuffer fileContent, XMLBean xb) {
		
		Map<String,String> members = xb.getMembers();
		
		Set<String> keys = members.keySet();
		
		for(String memberName: keys) {
			
			String memberType = members.get(memberName);			
			addPrivateProperty (fileContent,memberName,memberType);			
		}
	}
	
	private void addPrivateProperty (StringBuffer fileContent,String memberName,String memberType) {
		fileContent.append(TAB).append(PRIVATE)
	       .append(SPACE)
	       .append(memberType)
	       .append(SPACE)
	       .append(memberName)
	       .append(SEMICOLON).append(ENTER);
	}

}
