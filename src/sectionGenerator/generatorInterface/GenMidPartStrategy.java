package sectionGenerator.generatorInterface;

import java.util.Arrays;
import java.util.List;

public class GenMidPartStrategy implements CharacterAndSymbol {

	//生成策略列表
	private static final String[] basicTypes = { BYTE, SHORT, INT, LONG, FLOAT, DOUBLE, CHAR, BOOLEAN };
	
	private static final String[] collectionTypes = { MAP, LIST, SET, HASHMAP, ARRAYLIST, HASHSET };
	
	//Constructor
	public static final String[][] CONSTRUCTOR = 	{		
													basicTypes, 
													{ STRING },
													{ MAP },
													{ LIST },
													{ SET }
													};

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//ConstructorWithParamaeters
	public static final String[][] CONSTRUCTOR_ARGS = {{ BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN },
													{ STRING },
													{}}; 	

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	//Equals
	public static final String[][] COMPARETO = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	//HashCode
	public static final String[][] strategyFor4 = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	//Reset
	public static final String[][] strategyFor5 = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	//Clone
	public static final String[][] strategyFor6 = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	//
	public static final String[][] strategyFor7 = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	//
	public static final String[][] strategyFor8 = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	
	////////////////////////////////////////////////////////////////////////////////////
	
	public static int getStrategyID(String strType,String[][] strategy){
		
		for(int i = 0, len = strategy.length; i < len; i++){
			
			List<String> strCompare = Arrays.asList(strategy[i]);
			
			for(String str : strCompare){
				if(str.equals(strType)) return i;
			}
		}
		return -1;
	}
	
}
