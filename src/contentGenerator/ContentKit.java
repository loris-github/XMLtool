package contentGenerator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import tool.XMLBean;

public class ContentKit implements ContentGenerator{
	
	public static HashSet<String> typeSet_Basic = new HashSet<String>();
	public static HashSet<String> typeSet_Collection = new HashSet<String>();
	
	//Set List Map
	public static HashMap<String,String[]> interCollecType = new HashMap<String,String[]>();
	
	//Set[] List[] Map[]
	public static HashMap<String,String[]> interCollecArrayType = new HashMap<String,String[]>();
	
	//HashMap AarryList HashSet 等
	public static HashMap<String,String[]> classCollecType = new HashMap<String,String[]>();

	public static HashMap<String,String[]> collectionType = new HashMap<String,String[]>();
	
	static{
		
		typeSet_Basic.add("byte");
		typeSet_Basic.add("short");
		typeSet_Basic.add("int");
		typeSet_Basic.add("long");
		typeSet_Basic.add("float");
		typeSet_Basic.add("double");
		typeSet_Basic.add("char");
		typeSet_Basic.add("boolean");
		
		/*
		 * key是需要对比的字符串
		 * 第一个字符是 初始化的方法名
		 * 第二个字符是 用于复制的方法名
		 * 如果需要新的容器类型支持，需要重新put一条
		 * */

		interCollecType.put("Map", new String[]{"HashMap","putAll"});
		interCollecType.put("List", new String[]{"ArrayList","addAll"});
		interCollecType.put("Set", new String[]{"HashSet","addAll"});
				
		interCollecArrayType.put("Map[]", new String[]{"Map","putAll"});
		interCollecArrayType.put("List[]", new String[]{"List","addAll"});
		interCollecArrayType.put("Set[]", new String[]{"Set","addAll"});
		
		classCollecType.put("HashMap", new String[]{"HashMap","putAll"});
		classCollecType.put("AarryList", new String[]{"ArrayList","addAll"});
		classCollecType.put("HashSet", new String[]{"HashMap","addAll"});

		collectionType.putAll(interCollecType);
		collectionType.putAll(classCollecType);

		typeSet_Collection.addAll(collectionType.keySet());
		
	}
	
	//截取尖括号左边的字符
	public static String getStrBeforeLeftAngleBracket (String memberType){
		
		String strType = memberType;
		
		if(memberType.contains("<")) strType = memberType.substring(0, memberType.indexOf("<"));
		
		return strType;		
	}
	
	public static boolean iskindOf(HashMap<String,String[]> typeMaps ,String strType){

			Set<String> types = typeMaps.keySet();
			
			for(String type : types) {
				
				if(type.equals(strType)) return true;			
			}

		return false;
	}
		
	public static boolean isBasicType(String strType){
		
		for(String type : typeSet_Basic) {
			
			if(type.equals(strType)) return true;			
		}
		
		return false;
	}
	
	public static boolean isCollectionType(String strType){
		
		for(String type : typeSet_Collection) {
			
			if(type.equals(strType)) return true;			
		}
		
		return false;
	}
	
	public void generateContent(StringBuffer fileContent, XMLBean xb) {
	}
	
}
