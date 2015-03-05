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
			
			String strType = ContentKit.getStrBeforeLeftAngleBracket(memberType);
			
			if(ContentKit.iskindOf(ContentKit.interCollecType,strType)){
								
				String[] strOfSentence = ContentKit.interCollecType.get(strType);				
				String strConstruct = strOfSentence[0];				
				strImports.add(new String("import java.util." + strType + SEMICOLON ));
				strImports.add(new String("import java.util." + strConstruct + SEMICOLON ));
				
			} else if(ContentKit.iskindOf (ContentKit.interCollecArrayType, strType)){
				
				String[] strOfSentence = ContentKit.interCollecArrayType.get(strType);				
				String strConstruct = strOfSentence[0];				
				strImports.add(new String("import java.util." + strConstruct + SEMICOLON ));
								
			} else if(ContentKit.iskindOf (ContentKit.classCollecType, strType)){
			
				strImports.add(new String("import java.util." + strType + SEMICOLON ));
				
			}
	
		}
				
		if(strImports.size()>0) {
			
			for(String strImport : strImports) fileContent.append(strImport).append(ENTER);	
			fileContent.append(ENTER);
		}

	}
}
