package sectionGenerator.generatorInterface;

public class Segment implements CharacterAndSymbol {
	
	protected static StringBuilder joint (StringBuilder sb, CharSequence... args){
		
		for(CharSequence arg : args){
			
			sb.append(arg);
		}
		
		return sb;
	}

		
	// 生成方法Title,大括号之前的字符
	protected static StringBuilder getMethodTitle(String[] Title,String[] args){
		
		StringBuilder methodTitle = new StringBuilder(TAB);
		
		for(String part : Title) methodTitle.append(part).append(SPACE);
		
		methodTitle.append(LRB);
		
		for(String arg : args) methodTitle.append(arg).append(SPACE);
		
		methodTitle.append(RRB);
		
		return methodTitle;
	}
	
}
