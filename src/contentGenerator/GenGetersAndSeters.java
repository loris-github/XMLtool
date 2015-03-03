package contentGenerator;

import java.util.Map;
import java.util.Set;

import tool.XMLBean;

public class GenGetersAndSeters implements ContentGenerator{

	// create method get;	
	private void GenGet(StringBuffer fileContent,String memberName,String memberType){
		
		fileContent.append(TAB)
	       .append(PUBLIC)
	       .append(SPACE)
	       .append(memberType)
	       .append(SPACE)
	       .append("get")
	       .append(Character.toUpperCase(memberName.charAt(0)))
	       .append(memberName.substring(1))
	       .append("()").append(" {").append(ENTER)
	       .append(TAB).append(TAB)
	       .append("return this.")
	       .append(memberName)
	       .append(SEMICOLON).append(ENTER);
		
		fileContent.append(TAB).append("}")
	       .append(ENTER).append(ENTER);

	}
			
	// create method set;
	
	private void GenSet(StringBuffer fileContent,String memberName,String memberType){
		
		fileContent.append(TAB)
	       .append(PUBLIC)
	       .append(SPACE)
	       .append("void")
	       .append(SPACE)
	       .append("set")
	       .append(Character.toUpperCase(memberName.charAt(0)))
	       .append(memberName.substring(1))
	       .append("(").append(memberType)
	       .append(SPACE)
	       .append(memberName).append(")")
	       .append(" {").append(ENTER)
	       .append(TAB).append(TAB)
	       .append("this.").append(memberName)
	       .append(" = ").append(memberName)
	       .append(SEMICOLON).append(ENTER);
		
		fileContent.append(TAB).append("}")
	       .append(ENTER).append(ENTER);
		
	}

	@Override
	public void generateContent(StringBuffer fileContent,XMLBean xb) {
		
		Map<String,String> members = xb.getMembers();
		
		Set<String> keys = members.keySet();	
		for(String memberName: keys) {		
			String memberType = members.get(memberName);
			
			GenGet(fileContent, memberName, memberType);
			
			GenSet(fileContent, memberName, memberType);
				
		}

	}

}
