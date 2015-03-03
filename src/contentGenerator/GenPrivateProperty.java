package contentGenerator;

import java.util.Map;
import java.util.Set;

import tool.JFCreater;


public class GenPrivateProperty implements ContentGenerator {

	@Override
	public void generateContent(StringBuffer fileContent, JFCreater JFC) {
		
		Map<String,String> members = JFC.getMembers();
		
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
