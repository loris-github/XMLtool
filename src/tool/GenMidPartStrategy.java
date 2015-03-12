package tool;

import java.util.Arrays;

import sectionGenerator.generatorInterface.CharacterAndSymbol;

public class GenMidPartStrategy implements CharacterAndSymbol {
	
	//支持的类型
	private static final String[] supportedTypes = {BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN,STRING};
	
	
	//生成策略列表
	
	
	//Constructor
	private static final String[][] DF_Constructor = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}};
	
	public static final int[][] DS_Constructor = getDigiStrategy(DF_Constructor);
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//ConstructorWithParamaeters
	private static final String[][] DF_ConstructorWithParamaeters = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	
	public static final int[][] DS_ConstructorWithParamaeters = getDigiStrategy(DF_ConstructorWithParamaeters);

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	//Equals
	private static final String[][] strategyFor3 = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	//HashCode
	private static final String[][] strategyFor4 = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	//Reset
	private static final String[][] strategyFor5 = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	//Clone
	private static final String[][] strategyFor6 = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	//
	private static final String[][] strategyFor7 = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	//
	public static final String[][] strategyFor8 = {{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}}; 
	
	
	
	private static int[][] getDigiStrategy(String[][] Strategy){
		
		int outterLength = Strategy.length;
		
		int digitalizeStrategy[][] = new int[outterLength][];
		
		for(int i = 0; i < outterLength; i++){
			
			for(int j = 0, innerLength = Strategy[i].length; j < innerLength; j++){
				
				digitalizeStrategy[i][j] = getTypeId (Strategy[i][j]);
			}
			
		}

		return digitalizeStrategy;
	}
	
	//获得策略ID
	
	public static int getStrategy(int typeID,int[][] digiStrategy){
		
		for(int i = 0, len = digiStrategy.length; i < len; i++){
			
			if(Arrays.binarySearch(digiStrategy, typeID) > 0) return i;
			
		}
		
		return -1;
	}
	
	//获得类型ID
	public static int getTypeId(String type){

		for(int i = 0,len = supportedTypes.length; i < len; i++){
			
			if(supportedTypes.equals(type)) return i;
		} 
		
		return -1;
	}
}
