package contentGenerator;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

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
		classCollecType.put("ArrayList", new String[]{"ArrayList","addAll"});
		classCollecType.put("HashSet", new String[]{"HashSet","addAll"});

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
	
	public static <T extends Comparable<T>> int compareTo(Collection<T> a, Collection<T> b){
		int c = a.size() - b.size();
		if(c != 0) return c;
		Iterator<T> ia = a.iterator();
		Iterator<T> ib = b.iterator();
		while(ia.hasNext())
		{
			c = ia.next().compareTo(ib.next());
			if(c != 0) return c;
		}
		return 0;
	}
	
	public static <K extends Comparable<K>, V extends Comparable<V>> int compareTo(Map<K, V> a, Map<K, V> b)
	{
		int c = a.size() - b.size();
		if(c != 0) return c;
		Iterator<Entry<K, V>> ia = a.entrySet().iterator();
		Iterator<Entry<K, V>> ib = b.entrySet().iterator();
		while(ia.hasNext())
		{
			Entry<K, V> ea = ia.next();
			Entry<K, V> eb = ib.next();
			c = ea.getKey().compareTo(eb.getKey());
			if(c != 0) return c;
			c = ea.getValue().compareTo(eb.getValue());
			if(c != 0) return c;
		}
		return 0;
	}
	
	public static StringBuffer append(StringBuffer s, Collection<?> c)
	{
		if(c.isEmpty()) return s.append("{},");
		s.append('{');
		for(Object o : c)
			s.append(o).append(',');
		s.setCharAt(s.length() - 1, '}');
		return s.append(',');
	}
	
	public static StringBuffer append(StringBuffer s, Map<?, ?> m)
	{
		if(m.isEmpty()) return s.append("{},");
		s.append('{');
		for(Entry<?, ?> e : m.entrySet())
			s.append(e.getKey()).append(',').append(e.getValue()).append(';');
		s.setCharAt(s.length() - 1, '}');
		return s.append(',');
	}
	
	public void generateContent(StringBuffer fileContent, XMLBean xb) {
	}
	
}
