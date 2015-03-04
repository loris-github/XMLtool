package contentGenerator;

import tool.XMLBean;

public class ContentKit implements ContentGenerator{

	public static int judgeByType (String memberName,String memberType,StringBuffer fileContent){
		
		if(	"byte".equals(memberType) ||
			"short".equals(memberType) ||
			"int".equals(memberType) ||
			"long".equals(memberType) ||
			"float".equals(memberType) ||
			"double".equals(memberType) ||
			"char".equals(memberType) ||
			"boolean".equals(memberType)){
			
			return 1;
			
		}else if("String".equals(memberType)){
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE).append("=").append(SPACE)
			.append("\"\";").append(ENTER);	
			
			return 2;
			
		}else if("Map<".equals(memberType.substring(0, 4))){
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE).append("=").append(SPACE)
			.append("new").append(SPACE).append("Hash").append(memberType).append("();").append(ENTER);	
			
			return 3;
			
		}else if("List<".equals(memberType.substring(0, 5))){
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE).append("=").append(SPACE)
			.append("new").append(SPACE).append("Array").append(memberType).append("();").append(ENTER);	
						
			return 4;
			
		}else if("Set<".equals(memberType.substring(0, 4))){
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE).append("=").append(SPACE)
			.append("new").append(SPACE).append("Hash").append(memberType).append("();").append(ENTER);
			
			return 5;
			
		}else{
			
			return 0;
			
		}
	}
	
	public void generateContent(StringBuffer fileContent, XMLBean xb) {
	}
	
}
