package contentGenerator;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import tool.XMLBean;

public class GenImport implements ContentGenerator{
	
	public void generateContent(StringBuffer fileContent,XMLBean xb) {
		
		Map<String,String> members = xb.getMembers();
		Set<String> memberTypes = new HashSet<String>();		
		Set<String> memberNames = members.keySet();		
		for(String memberName: memberNames) memberTypes.add(members.get(memberName));		 

		Set<String> strImports = new HashSet<String>();
		
		for(String memberType: memberTypes) {
			
			String strType = ContentKit.getStrBeforeLeftAngleBracket(memberType, "*");

			if("Map".equals(strType) ||"Map[]".equals(strType)){
				
				strImports.add("import java.util.Map;");
				strImports.add("import java.util.HashMap;");
				
			} else if("List".equals(strType) ||"List[]".equals(strType)){
				
				strImports.add("import java.util.List;");
				strImports.add("import java.util.ArrayList;");
				
			} else if("Set".equals(strType) ||"Set[]".equals(strType)){
				
				strImports.add("import java.util.Set;");
				strImports.add("import java.util.HashSet;");
				
			} else if(ContentKit.isSubsetsOfListSetMap(strType)){

				strImports.add("import java.util."+strType+";");
			}
	
		}
		
		
		if(strImports.size()>0) {		
			for(String strImport : strImports) fileContent.append(strImport).append(ENTER);	
			fileContent.append(ENTER);
		}

	}
}
