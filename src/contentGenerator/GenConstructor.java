package contentGenerator;

import java.util.Map;
import java.util.Set;

import tool.XMLBean;

/* 
 * 1.如果是Stirng 为则为""
 * 2.如果是基本类型则忽略
 * 3.如果其他引用类型则调用无参构造方法
 */

public class GenConstructor implements ContentGenerator {
	@Override
	public void generateContent(StringBuffer fileContent, XMLBean xb) {
		
		String beanName = xb.getBeanName();
		Map<String,String> members = xb.getMembers();

		fileContent.append(TAB)
	       .append(PUBLIC)
	       .append(SPACE)
	       .append(beanName)
	       .append(SPACE)
	       .append("()").append(" {").append(ENTER);
		
		
		Set<String> memberNames = members.keySet();

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
			
			return ;	
			
		} else if("String".equals(strType)) {
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE).append("=").append(SPACE)
			.append("\"\";").append(ENTER);	
			
		} else if("Map".equals(strType) || "Set".equals(strType)) { 
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE).append("=").append(SPACE)
			.append("new").append(SPACE).append("Hash").append(memberType).append("();").append(ENTER);
			
		} else if("List".equals(strType)) {
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE).append("=").append(SPACE)
			.append("new").append(SPACE).append("Array").append(memberType).append("();").append(ENTER);	

		} else { 
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE).append("=").append(SPACE)
			.append("new").append(SPACE).append(memberType).append("()").append(SEMICOLON).append(ENTER);		
		}
		
	}
	
}
