package contentGenerator;

import tool.XMLBean;

public class ContentKit implements ContentGenerator{

	public static String getStrBeforeLeftAngleBracket (String memberType,String strDefault){
		
		String strType = strDefault;
		
		if(memberType.contains("<")) strType = memberType.substring(0, memberType.indexOf("<"));
		
		return strType;		
	}
	
	public static boolean isBasicType(String strType){
		
		if(	"byte".equals(strType) ||
			"short".equals(strType) ||
			"int".equals(strType) ||
			"long".equals(strType) ||
			"float".equals(strType) ||
			"double".equals(strType) ||
			"char".equals(strType) ||
			"boolean".equals(strType)) return true;
				
		return false;
	}
	
	public static boolean isSubsetsOfListSetMap(String strType){
		
		if( "ArrayList".equals(strType) ||
			"LinkedList".equals(strType) ||
			"HashSet".equals(strType) ||
			"TreeSet".equals(strType) ||
			"LinkedSet".equals(strType) ||
			"HashMap".equals(strType)) return true;
		
		return false;
	}
	
	public static boolean isSetsOfListSetMap(String strType){
		
		if( "Map".equals(strType) ||
			"List".equals(strType) ||
			"Set".equals(strType) ){
			
			return true;
			
		} else if(isSubsetsOfListSetMap(strType)){
			
			return true;
		}

			return false;
	}
	
	public void generateContent(StringBuffer fileContent, XMLBean xb) {
	}
	
}
