package sectionGenerator.generatorInterface;

import java.util.Arrays;
import java.util.List;

public class GenMidPartStrategy implements CharacterAndSymbol {

	//生成策略列表
	private static final String[] basicTypes = { BYTE, SHORT, INT, LONG, FLOAT, DOUBLE, CHAR, BOOLEAN };
	
	private static final String[] collectionTypes = { MAP, LIST, SET, HASHMAP, ARRAYLIST, HASHSET };
	
	//Constructor
	public static final String[][] GCONSTRUCTOR = 	{		
													basicTypes, 
													{ STRING },
													{ MAP },
													{ LIST },
													{ SET }
													};

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//ConstructorWithParamaeters
	public static final String[][] GASSIGN =	{
												{ BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN },
												{ STRING },
													{}
												}; 	

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	//Equals
	public static final String[][] COMPARETO = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	//HashCode
	public static final String[][] GTOSTRING = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	//Reset
	public static final String[][] GRESET = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	//Clone
	public static final String[][] GHASHCODE = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	//
	public static final String[][] GCONSTRUCTORWITHARGS = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	//
	public static final String[][] GEQUALS = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	
	//
	public static final String[][] GCLONE = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
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
