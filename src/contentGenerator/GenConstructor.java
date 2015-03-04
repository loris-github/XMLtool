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
			
			//genSentenceByType(memberName,memberType,fileContent);
			
			int judged = ContentKit.judgeByType(memberName, memberType, fileContent);
			
			genByJudged(judged,memberName,memberType,fileContent);
			
			
		} 	
		
		fileContent.append(TAB).append("}")
	       .append(ENTER).append(ENTER);
	}
	
	
	private void genByJudged(int judged,String memberName,String memberType,StringBuffer fileContent){		
		switch(judged){
		
		case 0:
			
			try {
				throw new Exception("can't find such type!");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
			
		case 1:
			break;
			
		case 2:
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE).append("=").append(SPACE)
			.append("\"\";").append(ENTER);	
			break;
			
		case 3:
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE).append("=").append(SPACE)
			.append("new").append(SPACE).append("Hash").append(memberType).append("();").append(ENTER);
			break;
			
		case 4:
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE).append("=").append(SPACE)
			.append("new").append(SPACE).append("Array").append(memberType).append("();").append(ENTER);	
			break;
			
		case 5:
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE).append("=").append(SPACE)
			.append("new").append(SPACE).append("Hash").append(memberType).append("();").append(ENTER);
			break;

		}

	}
	
	private void genSentenceByType (String memberName,String memberType,StringBuffer fileContent){
		
		if(	"byte".equals(memberType) ||
			"short".equals(memberType) ||
			"int".equals(memberType) ||
			"long".equals(memberType) ||
			"float".equals(memberType) ||
			"double".equals(memberType) ||
			"char".equals(memberType) ||
			"boolean".equals(memberType)){
			
			return;
			
		}else if("String".equals(memberType)){
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE).append("=").append(SPACE)
			.append("\"\";").append(ENTER);	
			
			return;
			
		}else if("Map<".equals(memberType.substring(0, 4))){
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE).append("=").append(SPACE)
			.append("new").append(SPACE).append("Hash").append(memberType).append("();").append(ENTER);	
			
			return;
			
		}else if("List<".equals(memberType.substring(0, 5))){
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE).append("=").append(SPACE)
			.append("new").append(SPACE).append("Array").append(memberType).append("();").append(ENTER);	
						
			return;
			
		}else if("Set<".equals(memberType.substring(0, 4))){
			
			fileContent.append(TAB).append(TAB)
			.append("this.").append(memberName).append(SPACE).append("=").append(SPACE)
			.append("new").append(SPACE).append("Hash").append(memberType).append("();").append(ENTER);
			
			return;
			
		}else{
			
			try {
				throw new Exception("can't find such type!");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
