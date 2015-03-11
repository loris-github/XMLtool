package sectionGenerator.generatorInterface;

public class Sentence implements CharacterAndSymbol {

	// 生成方法Title,大括号之前的字符
	public static StringBuilder getMethodTitle(String[] Title,String[] args){
		
		StringBuilder methodTitle = new StringBuilder(TAB);
		
		for(String part : Title) methodTitle.append(part).append(SPACE);
		
		methodTitle.append(LRB);
		
		for(String arg : args) methodTitle.append(arg).append(SPACE);
		
		methodTitle.append(RRB);
		
		return methodTitle;
	}
	
	public static StringBuilder sentence_Assign (String leftPart,String rightPart){
		
		StringBuilder sentence = new StringBuilder();
		
		sentence
		.append(leftPart).append(SPACE)
		.append(ASSIGN).append(SPACE)
		.append(leftPart).append(SEMI);
		
		return sentence;
	}
	
	public static StringBuilder sentence_If (StringBuilder condition, StringBuilder deal){
		
		StringBuilder sentence = new StringBuilder();
		
		sentence
		.append(IF).append(LRB)
		.append(condition)
		.append(RRB).append(SPACE)
		.append(deal).append(SEMI);

		return sentence;
	}
	
	public static StringBuilder sentence_Select (StringBuilder condition, StringBuilder trueDeal, StringBuilder falseDeal){
		
		StringBuilder sentence = new StringBuilder();
		
		sentence.append(LRB)
		.append(condition).append(SPACE).append(QUSET).append(SPACE)
		.append(trueDeal).append(SPACE).append(COLON).append(SPACE)
		.append(falseDeal).append(RRB);

		return sentence;
	}
	
	public static StringBuilder getIndented(StringBuilder sentence){
		
		return new StringBuilder(TAB).append(TAB).append(sentence).append(ENTER);
	}
		
	
}
