package contentGenerator;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tool.XMLBean;

public class GenImport implements ContentGenerator{
	
	public void generateContent(StringBuffer fileContent,XMLBean xb) {
		
		Map<String,String> members = xb.getMembers();
		Set<String> memberTypes = new HashSet<String>();		
		Set<String> memberNames = members.keySet();		
		for(String memberName: memberNames) memberTypes.add(members.get(memberName));		 

		Set<String> strImports = new HashSet<String>();
		
		for(String memberType: memberTypes) {

			String strType = "*";
			
			if(memberType.contains("<")){
				
				strType = memberType.substring(0, memberType.indexOf("<"));
			}

			if("Map".equals(strType) ||"Map[]".equals(strType)){
				
				strImports.add("import java.util.Map;");
				strImports.add("import java.util.HashMap;");
				
			} else if("List".equals(strType) ||"List[]".equals(strType)){
				
				strImports.add("import java.util.List;");
				strImports.add("import java.util.ArrayList;");
				
			} else if("Set".equals(strType) ||"Set[]".equals(strType)){
				
				strImports.add("import java.util.Set;");
				strImports.add("import java.util.HashSet;");
				
			} else if(isisSubsetsOfListSetMap(strType)){

				strImports.add("import java.util."+strType+";");
			}
	
		}
		
		
		if(strImports.size()>0) {		
			for(String strImport : strImports) fileContent.append(strImport).append(ENTER);	
			fileContent.append(ENTER);
		}

	}
	
	private boolean isisSubsetsOfListSetMap(String memberType){
	
		if( "ArrayList".equals(memberType) ||
			"LinkedList".equals(memberType) ||
			"HashSet".equals(memberType) ||
			"TreeSet".equals(memberType) ||
			"LinkedSet".equals(memberType) ||
			"HashMap".equals(memberType)) return true;
		
		return false;
	}
}
