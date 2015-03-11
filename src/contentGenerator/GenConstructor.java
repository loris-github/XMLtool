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
						
			String strType = ContentKit.getStrBeforeLeftAngleBracket(memberType);
			
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
			
		} else if(ContentKit.isCollectionType(strType)) {
			
			String[] strOfSentence = ContentKit.collectionType.get(strType);
			
			String strConstruct = strOfSentence[0];
						
			genSentenceForSetListMap(memberName,memberType,fileContent,strConstruct);

		} else {
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE).append("=").append(SPACE)
			.append("new").append(SPACE).append(memberType).append("()").append(SEMICOLON).append(ENTER);		
		}
		
	}
	
	private void genSentenceForSetListMap(String memberName,String memberType,StringBuffer fileContent,String strConstruct){
		
		fileContent.append(TAB).append(TAB)
		.append("this.").append(memberName).append(SPACE).append("=").append(SPACE)
		.append("new").append(SPACE).append(strConstruct).append("()").append(SEMICOLON).append(ENTER);
		
	}
	
}
