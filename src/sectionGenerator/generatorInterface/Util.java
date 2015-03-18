package sectionGenerator.generatorInterface;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Util implements CharacterAndSymbol{
	
	//字符串连接
	public static final StringBuilder joint (StringBuilder sb, CharSequence... args){
		
		for(CharSequence arg : args){
			
			sb.append(arg);
		}
		
		return sb;
	}
	
	//截取尖括号左边的字符
	public static final String getStrBeforeLeftAngleBracket (String memberType){
		
		String strType = memberType;
		
		if(memberType.contains(LAB)) strType = memberType.substring(0, memberType.indexOf("<"));
		
		return strType;		
	}
	
	public static final int getStrategyID(String strType,String[][] strategy){
		
		if(null == strategy) return -1;
		
		for(int i = 0, len = strategy.length; i < len; i++){
			
			List<String> strCompare = Arrays.asList(strategy[i]);
			
			for(String str : strCompare){
				if(str.equals(strType)) return i;
			}
		}
		
		return -1;
	}
	
	public static final <T extends Comparable<T>> int compareTo(Collection<T> a, Collection<T> b){
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
	
	public static final <K extends Comparable<K>, V extends Comparable<V>> int compareTo(Map<K, V> a, Map<K, V> b)
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
	
	public static final StringBuilder append(StringBuilder s, Collection<?> c)
	{
		if(c.isEmpty()) return s.append(LB).append(RB).append(COMMA);
		
		s.append(LB);
		
		for(Object o : c)
			s.append(o).append(COMMA);
		
		s.append(RB).append(COMMA);
		
		return s;
	}
	
	public static final StringBuilder append(StringBuilder s, Map<?, ?> m)
	{
		if(m.isEmpty()) return s.append(LB).append(RB).append(COMMA);
		
		s.append(LB);
		
		for(Entry<?, ?> e : m.entrySet())
			s.append(e.getKey()).append(COMMA).append(e.getValue()).append(SEMI);
		
		s.append(RB).append(COMMA);
		
		return s;
	}	
}
