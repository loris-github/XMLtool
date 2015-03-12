package sectionGenerator.generatorInterface;

public class Segment implements CharacterAndSymbol {
	
	protected static StringBuilder joint (StringBuilder sb, CharSequence... args){
		
		for(CharSequence arg : args){
			
			sb.append(arg);
		}
		
		return sb;
	}

	
	
}
